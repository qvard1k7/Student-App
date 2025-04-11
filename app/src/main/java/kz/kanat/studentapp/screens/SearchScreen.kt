package kz.kanat.studentapp.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kz.kanat.studentapp.ui.theme.StudentAppTheme

@Composable
fun SearchScreen(navController: NavController) {
    StudentAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            ScheduleScreen()
        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScheduleScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Text(
            text = "Schedule",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Text(
            text = "06 Mon\nJuly,2024",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp)
        )

        DaysRow()

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            item {
                CourseItem(
                    time = "11:35 - 13:05",
                    title = "Computer Science",
                    lecture = "Lecture 2: Data management",
                    location = "Room 2 - I24",
                    teacher = "Mam Laiba Khalid",
                    backgroundColor = Color(0xFFA5F4A7)
                )
            }
            item {
                CourseItem(
                    time = "13:15 - 14:45",
                    title = "Digital Marketing",
                    lecture = "Lecture 3: Shopify Creation",
                    location = "Room 3A - G4",
                    teacher = "Mam Hira",
                    backgroundColor = Color(0xFFF4F98E)
                )
            }
            item {
                CourseItem(
                    time = "15:10 - 16:40",
                    title = "Digital Marketing",
                    lecture = "Lecture 3: Shopify Creation",
                    location = "Room 7B - B1",
                    teacher = "Mam Hira",
                    backgroundColor = Color(0xFFD2E1F8)
                )
            }
        }
    }
}

@Composable
fun DaysRow() {
    val days = listOf("04", "05", "06", "07", "08", "09", "10")
    val selectedDay = "06"
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        days.forEach {
            val isSelected = it == selectedDay
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = it,
                    fontWeight = FontWeight.Bold,
                    color = if (isSelected) Color.White else Color.Black,
                    modifier = Modifier
                        .background(
                            if (isSelected) Color(0xFF8B1FA9) else Color.Transparent,
                            shape = CircleShape
                        )
                        .padding(8.dp)
                )
            }
        }
    }
}

@Composable
fun CourseItem(
    time: String,
    title: String,
    lecture: String,
    location: String,
    teacher: String,
    backgroundColor: Color
) {
    Column(
        modifier = Modifier
            .padding(vertical = 8.dp)
    ) {
        Text(time, color = Color.Gray, fontSize = 14.sp)

        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.padding(16.dp)) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Icon(Icons.Default.MoreVert, contentDescription = null)
                }
                Text(lecture, fontSize = 14.sp, color = Color.DarkGray)
                Spacer(modifier = Modifier.height(8.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.LocationOn, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(location, fontSize = 12.sp)
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Icon(Icons.Default.Person, contentDescription = null, modifier = Modifier.size(16.dp))
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(teacher, fontSize = 12.sp)
                }
            }
        }
    }
}
