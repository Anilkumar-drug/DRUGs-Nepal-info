package com.example.ui.components

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import android.speech.RecognitionListener
import android.speech.RecognizerIntent
import android.speech.SpeechRecognizer
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.*
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.MicNone
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.example.ui.theme.MedicalBlue500
import com.example.ui.theme.Red500
import java.util.Locale

/**
 * Modern, animated voice-to-text search microphone button for Android Compose.
 * Uses Android's SpeechRecognizer and RecognizerIntent for real-time speech input
 * supporting both English and Nepali speech recognition.
 */
@Composable
fun VoiceSearchButton(
    onSpokenText: (String) -> Unit,
    modifier: Modifier = Modifier,
    size: Dp = 36.dp,
    activeColor: Color = Red500,
    idleColor: Color = MedicalBlue500,
    testTag: String = "voice_search_mic_button"
) {
    val context = LocalContext.current
    var isListening by remember { mutableStateOf(false) }

    // Pulsing animation when voice recording is actively listening
    val infiniteTransition = rememberInfiniteTransition(label = "micPulse")
    val pulseScale by infiniteTransition.animateFloat(
        initialValue = 1f,
        targetValue = 1.25f,
        animationSpec = infiniteRepeatable(
            animation = tween(600, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "micPulseScale"
    )

    val animatedColor by animateColorAsState(
        targetValue = if (isListening) activeColor else idleColor,
        label = "micColor"
    )

    // SpeechRecognizer setup
    val speechRecognizer = remember {
        if (SpeechRecognizer.isRecognitionAvailable(context)) {
            SpeechRecognizer.createSpeechRecognizer(context)
        } else {
            null
        }
    }

    DisposableEffect(speechRecognizer) {
        onDispose {
            try {
                speechRecognizer?.destroy()
            } catch (e: Exception) {
                // Ignore cleanup error
            }
        }
    }

    val startListening = {
        if (speechRecognizer == null) {
            Toast.makeText(
                context,
                "Voice recognition is not available on this device",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            try {
                val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH).apply {
                    putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM)
                    putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault().toLanguageTag())
                    putExtra(RecognizerIntent.EXTRA_PROMPT, "Speak drug, brand, or protocol name (e.g. Paracetamol, Moxclave, Asthma)...")
                    putExtra(RecognizerIntent.EXTRA_MAX_RESULTS, 3)
                }

                speechRecognizer.setRecognitionListener(object : RecognitionListener {
                    override fun onReadyForSpeech(params: Bundle?) {
                        isListening = true
                    }

                    override fun onBeginningOfSpeech() {
                        isListening = true
                    }

                    override fun onRmsChanged(rmsdB: Float) {}

                    override fun onBufferReceived(buffer: ByteArray?) {}

                    override fun onEndOfSpeech() {
                        isListening = false
                    }

                    override fun onError(error: Int) {
                        isListening = false
                        val errorMessage = when (error) {
                            SpeechRecognizer.ERROR_NO_MATCH -> "No speech recognized. Please try again."
                            SpeechRecognizer.ERROR_SPEECH_TIMEOUT -> "Speech timeout. Tap mic again."
                            SpeechRecognizer.ERROR_AUDIO -> "Audio recording error"
                            else -> "Voice recognition error ($error)"
                        }
                        // Only show toast if user actively spoke or timed out
                        if (error != SpeechRecognizer.ERROR_NO_MATCH && error != SpeechRecognizer.ERROR_SPEECH_TIMEOUT) {
                            Toast.makeText(context, errorMessage, Toast.LENGTH_SHORT).show()
                        }
                    }

                    override fun onResults(results: Bundle?) {
                        isListening = false
                        val matches = results?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                        if (!matches.isNullOrEmpty()) {
                            val recognized = matches[0]
                            onSpokenText(recognized)
                        }
                    }

                    override fun onPartialResults(partialResults: Bundle?) {
                        val matches = partialResults?.getStringArrayList(SpeechRecognizer.RESULTS_RECOGNITION)
                        if (!matches.isNullOrEmpty()) {
                            onSpokenText(matches[0])
                        }
                    }

                    override fun onEvent(eventType: Int, params: Bundle?) {}
                })

                speechRecognizer.startListening(intent)
                isListening = true
            } catch (e: Exception) {
                isListening = false
                Toast.makeText(context, "Could not start voice recognition", Toast.LENGTH_SHORT).show()
            }
        }
    }

    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            startListening()
        } else {
            Toast.makeText(
                context,
                "Microphone permission is required for voice-to-text search",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.size(size)
    ) {
        // Glowing background halo when actively listening
        if (isListening) {
            Box(
                modifier = Modifier
                    .size(size)
                    .scale(pulseScale)
                    .background(activeColor.copy(alpha = 0.25f), shape = CircleShape)
            )
        }

        IconButton(
            onClick = {
                if (isListening) {
                    try {
                        speechRecognizer?.stopListening()
                    } catch (e: Exception) {}
                    isListening = false
                } else {
                    val permissionCheck = ContextCompat.checkSelfPermission(
                        context,
                        Manifest.permission.RECORD_AUDIO
                    )
                    if (permissionCheck == PackageManager.PERMISSION_GRANTED) {
                        startListening()
                    } else {
                        permissionLauncher.launch(Manifest.permission.RECORD_AUDIO)
                    }
                }
            },
            modifier = Modifier
                .size(size)
                .testTag(testTag)
        ) {
            Icon(
                imageVector = if (isListening) Icons.Default.Mic else Icons.Default.MicNone,
                contentDescription = if (isListening) "Listening... Tap to stop" else "Search with Voice",
                tint = animatedColor,
                modifier = Modifier.size(size * 0.58f)
            )
        }
    }
}
