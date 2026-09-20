package com.example.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ui.theme.Red500

@Composable
fun PractitionerLoginDialog(
    isLoggedIn: Boolean,
    initialName: String,
    initialDegree: String,
    initialCouncilNo: String,
    onDismissRequest: () -> Unit,
    onSave: (name: String, degree: String, councilNo: String) -> Unit,
    onLogout: () -> Unit
) {
    var tempName by remember { mutableStateOf(initialName) }
    var tempDegree by remember { mutableStateOf(initialDegree) }
    var tempCouncil by remember { mutableStateOf(initialCouncilNo) }

    AlertDialog(
        onDismissRequest = onDismissRequest,
        modifier = Modifier.testTag("practitioner_login_dialog"),
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.primaryContainer,
                    modifier = Modifier.size(38.dp)
                ) {
                    Box(contentAlignment = Alignment.Center) {
                        Icon(
                            imageVector = if (isLoggedIn) Icons.Default.Badge else Icons.AutoMirrored.Filled.Login,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                }
                Column {
                    Text(
                        text = if (isLoggedIn) "Practitioner Profile" else "Practitioner Sign In",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "Optional Credentials & Clinical Info",
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
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                Surface(
                    shape = RoundedCornerShape(10.dp),
                    color = MaterialTheme.colorScheme.surfaceVariant.copy(alpha = 0.5f),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = "You can use Drugs Nepal without logging in. Providing your name, degree, and council number is optional and personalizes dose calculations & exports.",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.padding(10.dp),
                        lineHeight = 16.sp
                    )
                }

                // Name input (Optional)
                OutlinedTextField(
                    value = tempName,
                    onValueChange = { tempName = it },
                    label = { Text("Physician / Clinician Name (Optional)") },
                    placeholder = { Text("e.g. Dr. Prabhat Sharma") },
                    leadingIcon = {
                        Icon(Icons.Default.Person, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("login_name_input")
                )

                // Degree input (Optional)
                OutlinedTextField(
                    value = tempDegree,
                    onValueChange = { tempDegree = it },
                    label = { Text("Degree / Qualifications (Optional)") },
                    placeholder = { Text("e.g. MBBS, MD, B.Pharm, BDS, MDGP") },
                    leadingIcon = {
                        Icon(Icons.Default.School, contentDescription = null, tint = MaterialTheme.colorScheme.primary)
                    },
                    singleLine = true,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .testTag("login_degree_input")
                )

                // Council Reg. Number input (Optional)
                OutlinedTextField(
                    value = tempCouncil,
                    onValueChange = { tempCouncil = it },
                    label = { Text("Council Reg. Number (Optional)") },
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
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    onSave(tempName, tempDegree, tempCouncil)
                },
                shape = RoundedCornerShape(10.dp),
                modifier = Modifier.testTag("login_save_button")
            ) {
                Text(if (isLoggedIn) "Save Changes" else "Sign In / Continue")
            }
        },
        dismissButton = {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                if (isLoggedIn) {
                    TextButton(
                        onClick = {
                            onLogout()
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
