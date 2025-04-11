package kz.kanat.studentapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kz.kanat.studentapp.R
import kz.kanat.studentapp.ui.theme.StudentAppTheme

@Composable
fun ScheduleScreen(navController: NavController) {
    StudentAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ProfileScreen()
        }
    }
}

@Composable
fun ProfileScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Text(
            text = "Profile",
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // User info
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            Image(
                painter = painterResource(id = R.drawable.placeholder), // Заменить на своё изображение
                contentDescription = "Profile Image",
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
            )
            Spacer(modifier = Modifier.width(12.dp))
            Column {
                Text("Ammar Ali", fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("SU92-BCSCM-S23-040", color = Color.Gray, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // GPA and Credits
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            InfoBox(title = "Credit earns", value = "50/130")
            InfoBox(title = "GPA", value = "3.02")
            InfoBox(title = "Year student", value = "2")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Statistics
        Card(
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color(0xFFEBEBEB)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Statistics", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50)),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp)
                    ) {
                        Text("Mark Attend", fontSize = 12.sp, color = Color.White)
                    }
                }

                Text("Monday, 06 June 2024", color = Color.Gray, fontSize = 12.sp)

                Spacer(modifier = Modifier.height(12.dp))

                Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
                    StatItem("Attendance", "90%")
                    StatItem("Task & Work", "70%")
                    StatItem("Quiz", "85%")
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Dashboard
        Card(
            shape = RoundedCornerShape(16.dp),
            border = BorderStroke(1.dp, Color(0xFFEBEBEB)),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Dashboard", fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(12.dp))
                DashboardItem(icon = Icons.Default.Settings, label = "Setting")
                DashboardItem(icon = Icons.Default.Person, label = "Achievement")
                DashboardItem(icon = Icons.Default.Lock, label = "Privacy")
            }
        }
    }
}

@Composable
fun InfoBox(title: String, value: String) {
    Column(
        modifier = Modifier
            .width(100.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Color(0xFFF3E8FF))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(value, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Text(title, color = Color.Gray, fontSize = 12.sp)
    }
}

@Composable
fun StatItem(title: String, percent: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Icon(Icons.Default.PlayArrow, contentDescription = null, modifier = Modifier.size(32.dp))
        Text(title, fontSize = 12.sp)
        Text(percent, fontWeight = FontWeight.Bold, fontSize = 14.sp)
    }
}

@Composable
fun DashboardItem(icon: ImageVector, label: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(vertical = 8.dp)
            .clickable { }
    ) {
        Icon(icon, contentDescription = null, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(12.dp))
        Text(label, fontSize = 14.sp)
    }
}
