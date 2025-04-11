package kz.kanat.studentapp.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.navigation.NavGraph.Companion.findStartDestination
import kz.kanat.studentapp.Screens
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
                        text = "Сегодняшние занятия",
                        style = Typography.bodyLarge,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.W600
                    )
                    Row(
                        modifier = Modifier.weight(1f).clickable {
                            navController.navigate(Screens.Schedule.route) {
                                popUpTo(navController.graph.findStartDestination().id) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        verticalAlignment = Alignment.CenterVertically,

                    ) {
                        Text(
                            text = "Открыть расписание",
                            style = Typography.bodyMedium,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.W400,
                            color = Pink40,
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
                Spacer(Modifier.size(32.dp))
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
                text = "Использовать технологии работы с базами данных",
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
                    text = "Корпус №2, №76 ауд",
                    style = Typography.bodyMedium,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.W400,
                    color = Color.Gray
                )
            }

            Text(
                modifier = Modifier.weight(2f),
                text = "Ишутина И.Р",
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

    val tabs = listOf("Новости", "Ивенты")

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
            title = "Международный день книгодарения",
            description = "В Международный день книгодарения, 14 февраля, члены Атырауского еврейского этнокультурного объединения «Алия» сделали особенный подарок студентам нашего колледжа.\n" +
                    "Директор колледжа Мухтаров М. Х. поприветствовал гостей от лица преподавателей и студентов. ",
            date = "14.02.2025",
            dateBackgroundColor = Color(0xFFB39DDB) // Light Purple
        ),
        NewsItem(
            title = "Технологиялық процестерді автоматтандыру және басқару",
            description = "Колледжіміздің “Технологиялық процестерді автоматтандыру және басқару “ мамандығының 2 курс студенттері алғашқы оқу-өндірістік тәжірибелерін колледж қабырғасында өткізіп теориялық білімдерін практикада бекітті.",
            date = "13.01.2025",
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
            title = "Национальный чемпионат \"WorldSkills Kazakhstan-2025\"",
            location = "ПСВК",
            date = "Ноябрь 2025",
            imageRes = kz.kanat.studentapp.R.drawable.word_class // замените на ваш ресурс
        ),
        EventItem(
            title = "Құқықбұзушылықтан алдын алу",
            location = "ПСВК",
            date = "Апрель 2025",
            imageRes = kz.kanat.studentapp.R.drawable.image// замените на ваш ресурс
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




