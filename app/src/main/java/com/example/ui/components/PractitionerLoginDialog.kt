package com.example.ui.components

import android.net.Uri
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.ui.theme.DimsTealPrimary
import com.example.ui.theme.Emerald400
import com.example.ui.theme.Red500

@Composable
fun DoctorAvatarView(
    avatarString: String,
    modifier: Modifier = Modifier,
    sizeDp: Int = 40,
    fontSizeSp: Int = 20
) {
    val isPhotoUri = avatarString.startsWith("content://") || 
                     avatarString.startsWith("file://") || 
                     avatarString.startsWith("http://") || 
                     avatarString.startsWith("https://")

    Surface(
        shape = CircleShape,
        color = DimsTealPrimary.copy(alpha = 0.2f),
        border = BorderStroke(1.2.dp, DimsTealPrimary),
        modifier = modifier.size(sizeDp.dp)
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            if (isPhotoUri) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(Uri.parse(avatarString))
                        .crossfade(true)
                        .build(),
                    contentDescription = "Profile Photo",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(CircleShape)
                )
            } else {
                Text(
                    text = avatarString.ifBlank { "👨‍⚕️" },
                    fontSize = fontSizeSp.sp
                )
            }
        }
    }
}

@Composable
fun PractitionerLoginDialog(
    isLoggedIn: Boolean,
    initialName: String,
    initialDegree: String,
    initialCollege: String = "",
    initialCouncilNo: String = "",
    initialMobile: String = "",
    initialAvatar: String = "👨‍⚕️",
    onDismissRequest: () -> Unit,
    onSave: (name: String, degree: String, college: String, councilNo: String, mobile: String, avatar: String) -> Unit,
    onLogout: () -> Unit
) {
    val context = LocalContext.current
    var tempName by remember { mutableStateOf(initialName) }
    var tempDegree by remember { mutableStateOf(initialDegree) }
    var tempCollege by remember { mutableStateOf(initialCollege) }
    var tempCouncil by remember { mutableStateOf(initialCouncilNo) }
    var tempMobile by remember { mutableStateOf(initialMobile) }
    var tempAvatar by remember { mutableStateOf(initialAvatar.ifBlank { "👨‍⚕️" }) }

    // Android Zero-Permission Photo Picker for Doctor Profile Photo
    val photoPickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.PickVisualMedia()
    ) { uri: Uri? ->
        if (uri != null) {
            tempAvatar = uri.toString()
            Toast.makeText(context, "Photo selected successfully!", Toast.LENGTH_SHORT).show()
        }
    }

    val avatarOptions = remember {
        listOf("👨‍⚕️", "👩‍⚕️", "🩺", "🏥", "🔬", "💊", "⚕️", "💉", "🧑‍⚕️")
    }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = Modifier.testTag("practitioner_login_dialog"),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                DoctorAvatarView(
                    avatarString = tempAvatar,
                    sizeDp = 44,
                    fontSizeSp = 22
                )
                Column {
                    Text(
                        text = if (isLoggedIn) "Practitioner Profile" else "Practitioner Sign In",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Physician & Clinical Credentials",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        text = {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Column(modifier = Modifier.padding(10.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(
                            text = "Sign in or save your clinician details to personalize prescription exports, calculation headers, and clinical guidelines.",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                            lineHeight = 16.sp
                        )
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.End
                        ) {
                            TextButton(
                                onClick = {
                                    tempName = "Dr. Anel Kumar Sah"
                                    tempCollege = "BPKIHS Dharan / Tribhuvan University"
                                    tempDegree = "MBBS, MD (Internal Medicine)"
                                    tempCouncil = "NMC-28491"
                                    tempMobile = "+977-9841234567"
                                    tempAvatar = "👨‍⚕️"
                                    Toast.makeText(context, "Filled sample doctor profile", Toast.LENGTH_SHORT).show()
                                },
                                contentPadding = PaddingValues(horizontal = 6.dp, vertical = 2.dp)
                            ) {
                                Icon(Icons.Default.AutoAwesome, contentDescription = null, modifier = Modifier.size(14.dp), tint = DimsTealPrimary)
                                Spacer(modifier = Modifier.width(4.dp))
                                Text("Fill Demo Profile", fontSize = 11.sp, color = DimsTealPrimary, fontWeight = FontWeight.Bold)
                            }
                        }
                    }
                }

                // Profile Photo / Avatar Section with Device Photo Picker & Avatar Emojis
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Profile Photo / Avatar:",
                            fontSize = 12.sp,
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.primary
                        )

                        // Button to pick actual photo from device
                        FilledTonalButton(
                            onClick = {
                                photoPickerLauncher.launch(
                                    PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly)
                                )
                            },
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp),
                            shape = RoundedCornerShape(8.dp),
                            modifier = Modifier.testTag("pick_photo_button")
                        ) {
                            Icon(Icons.Default.PhotoCamera, contentDescription = null, modifier = Modifier.size(14.dp))
                            Spacer(modifier = Modifier.width(4.dp))
                            Text("Choose Photo", fontSize = 11.sp)
                        }
                    }

                    // Avatar Emoji / Icons selection
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .horizontalScroll(rememberScrollState()),
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        avatarOptions.forEach { avatar ->
                            val isSelected = tempAvatar == avatar
                            Surface(
                                shape = CircleShape,
                                color = if (isSelected) DimsTealPrimary.copy(alpha = 0.25f) else MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                                border = BorderStroke(if (isSelected) 2.dp else 1.dp, if (isSelected) DimsTealPrimary else MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)),
                                modifier = Modifier
                                    .size(40.dp)
                                    .clickable { tempAvatar = avatar }
                                    .testTag("avatar_option_$avatar")
                            ) {
                                Box(contentAlignment = Alignment.Center) {
                                    Text(text = avatar, fontSize = 20.sp)
                                }
                            }
                        }
                    }
                }

                // Name input
                OutlinedTextField(
                    value = tempName,
                    onValueChange = { tempName = it },
                    label = { Text("Physician / Clinician Name") },
                    placeholder = { Text("e.g. Dr. Anel Kumar Sah") },
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("login_name_input")
                )

                // Medical College / Hospital / University input
                OutlinedTextField(
                    value = tempCollege,
                    onValueChange = { tempCollege = it },
                    label = { Text("Medical College / Hospital") },
                    placeholder = { Text("e.g. BPKIHS Dharan, IOM, KMC, AIIMS, NAMS") },
                    leadingIcon = {
                        Icon(Icons.Default.Apartment, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("login_college_input")
                )

                // Degree / Qualifications input
                OutlinedTextField(
                    value = tempDegree,
                    onValueChange = { tempDegree = it },
                    label = { Text("Degree / Qualifications") },
                    placeholder = { Text("e.g. MBBS, MD (Medicine), B.Pharm, DM, MS") },
                    leadingIcon = {
                        Icon(Icons.Default.School, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("login_degree_input")
                )

                // Council Registration Number input
                OutlinedTextField(
                    value = tempCouncil,
                    onValueChange = { tempCouncil = it },
                    label = { Text("Council Reg. Number") },
                    placeholder = { Text("e.g. NMC-28491 / Pharmacy Council") },
                    leadingIcon = {
                        Icon(Icons.Default.VerifiedUser, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("login_council_input")
                )

                // Mobile / Phone Number input
                OutlinedTextField(
                    value = tempMobile,
                    onValueChange = { tempMobile = it },
                    label = { Text("Mobile / Contact Number") },
                    placeholder = { Text("e.g. +977-9841234567") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone),
                    leadingIcon = {
                        Icon(Icons.Default.Phone, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("login_mobile_input")
                )
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    val finalName = if (tempName.isBlank() && tempMobile.isNotBlank()) "Dr. ($tempMobile)"
                                    else if (tempName.isBlank()) "Dr. Clinician"
                                    else tempName
                    onSave(finalName, tempDegree, tempCollege, tempCouncil, tempMobile, tempAvatar)
                    Toast.makeText(context, "Practitioner logged in successfully!", Toast.LENGTH_SHORT).show()
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.testTag("login_save_button")
            ) {
                Icon(Icons.AutoMirrored.Filled.Login, contentDescription = null, modifier = Modifier.size(16.dp))
                Spacer(modifier = Modifier.width(6.dp))
                Text(if (isLoggedIn) "Save Changes" else "Sign In / Continue")
            }
        },
        dismissButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                if (isLoggedIn) {
                    TextButton(
                        onClick = {
                            onLogout()
                            Toast.makeText(context, "Logged out successfully", Toast.LENGTH_SHORT).show()
                            onDismissRequest()
                        },
                        colors = ButtonDefaults.textButtonColors(contentColor = Red500)
                    ) {
                        Text("Log Out")
                    }
                }
                TextButton(
                    onClick = onDismissRequest,
                    modifier = Modifier.testTag("login_cancel_button")
                ) {
                    Text(if (isLoggedIn) "Cancel" else "Continue as Guest")
                }
            }
        }
    )
}
