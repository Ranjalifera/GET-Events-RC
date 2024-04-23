package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.myapplication.data.DataSource
import com.example.myapplication.model.Event


@Composable
fun Evenement(activity: Activity) {
    EventList(
        eventList = DataSource().loadEvent(),
        activity
    )
}

@Composable
fun EventCard(event: Event, activity: Activity) {
    Card() {
        Column {
            Text(
                text = LocalContext.current.getString(event.stringResourceId),
                modifier = Modifier.padding(16.dp),
                fontSize = 24.sp,
                style = MaterialTheme.typography.headlineSmall
            )
            Text(
                text = LocalContext.current.getString(event.stringResources),
                modifier = Modifier.padding(16.dp),
                fontSize = 16.sp,
                style = MaterialTheme.typography.headlineSmall,
                color = colorResource(R.color.purple_200)
            )
            Image(
                painter = painterResource(event.imageResourceId),
                contentDescription = stringResource(event.stringResourceId),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(194.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier,
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {
                    val navigate = Intent(activity, FormulaireTest::class.java)
                    ContextCompat.startActivity(activity,navigate, Bundle.EMPTY)
                              },
                    modifier = Modifier.padding(bottom = 4.dp).padding(start = 4.dp)
                ) {
                    Text(stringResource(R.string.modif))
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
        }
    }
}

//@Preview
//@Composable
//private fun EventCardPreview() {
//    EventCard(Event(R.string.conf, R.drawable.conf))
//}

@Composable
fun EventList(eventList: List<Event>, activity: Activity) {
    LazyColumn() {
        items(eventList) {event ->
            EventCard(
                event = event,
                activity
            )
        }
    }
}