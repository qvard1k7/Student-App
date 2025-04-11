package kz.kanat.studentapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import kz.kanat.studentapp.ui.theme.Pink40
import kz.kanat.studentapp.ui.theme.Purple40
import kz.kanat.studentapp.ui.theme.Purple80
import kz.kanat.studentapp.ui.theme.StudentAppTheme
import kz.kanat.studentapp.ui.theme.Typography

@Composable
fun HomeScreen(navController: NavController) {
    StudentAppTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                Row {
                    Text(
                        modifier = Modifier.weight(2f),
                        text = "Today's Classes",
                        style = Typography.bodyLarge,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600
                    )
                    Row(
                        modifier = Modifier.weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Open schedule",
                            style = Typography.bodyMedium,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = Pink40
                        )
                        Icon(
                            imageVector = Icons.AutoMirrored.Outlined.KeyboardArrowRight,
                            contentDescription = null,
                            tint = Color.Gray
                        )
                    }

                }

                Spacer(Modifier.size(32.dp))
                TodayClasses()

                NewsTab()
            }
        }
    }
}

@Composable
fun TodayClasses() {
    OutlinedCard(
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
        ),
        border = BorderStroke(1.dp, Color.LightGray),
        modifier = Modifier
            .height(height = 100.dp)
            .fillMaxWidth()
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(
                text = "Digital Thinking",
                style = Typography.bodyMedium,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400
            )

            Row {
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "09:00 - 11:00",
                    style = Typography.bodyMedium,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Gray
                )
                Text(
                    modifier = Modifier.padding(4.dp),
                    text = "Main auditorium",
                    style = Typography.bodyMedium,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Gray
                )
            }

            Text(
                modifier = Modifier.weight(2f),
                text = "Mam Mahnoor",
                style = Typography.bodyMedium,
                fontSize = 12.sp,
                fontWeight = FontWeight.W400
            )
        }
    }
}

@Composable
fun NewsTab() {
    var tabIndex by remember { mutableStateOf(0) }

    val tabs = listOf("News", "Events")

    Column {
        TabRow(selectedTabIndex = tabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> {
                NewsList()
            }

            1 -> {
                EventList()
            }
        }
    }
}

@Composable
fun NewsCard(
    title: String,
    description: String,
    date: String,
    dateBackgroundColor: Color
) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
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
                Box(
                    modifier = Modifier
                        .background(dateBackgroundColor, shape = RoundedCornerShape(20.dp))
                        .padding(horizontal = 12.dp, vertical = 4.dp)
                ) {
                    Text(
                        text = date,
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = description,
                fontSize = 14.sp,
                color = Color.Gray
            )
        }
    }
}

@Composable
fun NewsList() {
    val newsItems = listOf(
        NewsItem(
            title = "FBISE",
            description = "The Federal Board of Intermediate and Secondary Education (FBISE) has officially announced the date for the results of the Secondary School Certificate (SSC) Part I & II 1st Annual Examinations.",
            date = "May 01",
            dateBackgroundColor = Color(0xFFB39DDB) // Light Purple
        ),
        NewsItem(
            title = "Gaza",
            description = "The Pakistan Medical and Dental Council (PM&DC) has permitted medical/dental students from Gaza to complete their studies in Pakistan.",
            date = "June 07",
            dateBackgroundColor = Color(0xFF81C784) // Light Green
        )
        // Можно добавить больше новостей здесь
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp, vertical = 8.dp)
    ) {
        items(newsItems) { item ->
            NewsCard(
                title = item.title,
                description = item.description,
                date = item.date,
                dateBackgroundColor = item.dateBackgroundColor
            )
        }
    }
}

@Composable
fun EventList() {
    val events = listOf(
        EventItem(
            title = "IDP Study Abroad Expo",
            location = "Islamabad",
            date = "Wed, 28 Feb 2024",
            imageRes = kz.kanat.studentapp.R.drawable.expo // замените на ваш ресурс
        ),
        EventItem(
            title = "Pathways to Development Conference",
            location = "Lahore",
            date = "Fri, 19 Apr 2024",
            imageRes = kz.kanat.studentapp.R.drawable.expo// замените на ваш ресурс
        )
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        items(events) { event ->
            EventCard(event = event)
        }
    }
}


@Composable
fun EventCard(event: EventItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(12.dp)
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp)
            ) {
                Text(
                    text = event.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = event.location,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
                Spacer(modifier = Modifier.height(2.dp))
                Text(
                    text = event.date,
                    color = Color.Gray,
                    fontSize = 14.sp
                )
            }

            Image(
                painter = painterResource(id = event.imageRes),
                contentDescription = event.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(90.dp)
                    .clip(RoundedCornerShape(12.dp))
            )
        }
    }
}

data class EventItem(
    val title: String,
    val location: String,
    val date: String,
    val imageRes: Int // Drawable resource ID
)


data class NewsItem(
    val title: String,
    val description: String,
    val date: String,
    val dateBackgroundColor: Color
)




