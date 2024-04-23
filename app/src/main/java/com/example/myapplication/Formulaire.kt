package com.example.myapplication


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.compose.material3.Icon
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.core.content.ContextCompat
import com.example.myapplication.ui.theme.MyApplicationTheme


@Composable
fun FormulaireLayout(activity: Activity) {
    Column(
        modifier = Modifier
            .statusBarsPadding()
            .padding(horizontal = 40.dp)
            .padding(top = 24.dp)
            .verticalScroll(rememberScrollState())
            .safeDrawingPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        //Date
        Text(
            text = stringResource(R.string.date),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditDateField(
            label = R.string.date,
            leadingIcon = R.drawable.calendrier1,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )

        //Heure
        Text(
            text = stringResource(R.string.heure),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditHeureField(
            label = R.string.heure,
            leadingIcon = R.drawable.lhorloge1,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )

        //Lieu
        Text(
            text = stringResource(R.string.lieu),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditLieuField(
            label = R.string.lieu,
            leadingIcon = R.drawable.marqueur1,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )

        //Nom événement
        Text(
            text = stringResource(R.string.nom_event),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditNomField(
            label = R.string.nom_event,
            leadingIcon = R.drawable.calendar_star1,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )

        //Type événement
        Text(
            text = stringResource(R.string.theme),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditTypeField(
            label = R.string.theme,
            leadingIcon = R.drawable.category1,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )

        //Participants
        Text(
            text = stringResource(R.string.participants),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditParticipantsField(
            label = R.string.participants,
            leadingIcon = R.drawable.users_alt1,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )

        //Descri
        Text(
            text = stringResource(R.string.descri),
            modifier = Modifier
                .padding(bottom = 16.dp)
                .align(alignment = Alignment.Start)
        )
        EditDescriField(
            label = R.string.descri,
            leadingIcon = R.drawable.edit1,
            modifier = Modifier
                .padding(bottom = 16.dp)
                .fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(150.dp))

        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = {
                val navigate = Intent(activity, EvenementTest::class.java)
                ContextCompat.startActivity(activity,navigate, Bundle.EMPTY)
            }) {
                Text(stringResource(R.string.retour))
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(onClick = {
                val navigate = Intent(activity, CongratsTest::class.java)
                ContextCompat.startActivity(activity,navigate, Bundle.EMPTY)
            }) {
                Text(stringResource(R.string.confirmer))
            }
        }
    }
}

//Textfield date
@Composable
fun EditDateField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {

    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.format_date)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer la date...")
        }
    )
}

//Textfield heure
@Composable
fun EditHeureField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.format_heure)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer l'heure...")
        }
    )
}

//Textfield Lieu
@Composable
fun EditLieuField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.adresse)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer le lieu...")
        }
    )
}

//Textfield nom événement
@Composable
fun EditNomField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.event)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer le nom de l'évènement...")
        }
    )
}

//Textfield type événement
@Composable
fun EditTypeField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.type)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer le type d'évènement...")
        }
    )
}

//Participants
@Composable
fun EditParticipantsField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.membres)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer les participants...")
        }
    )
}

//Description de l'évènement
@Composable
fun EditDescriField(
    @StringRes label: Int,
    @DrawableRes leadingIcon: Int,
    modifier: Modifier = Modifier
) {
    var amountInput by remember { mutableStateOf("") }
    OutlinedTextField(
        value = amountInput,
        leadingIcon = {Icon(painter = painterResource(id = leadingIcon), null)},
        onValueChange = {amountInput = it},
        label = { Text(stringResource(R.string.resume)) },
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
        modifier = modifier,
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = Color.White,
            focusedContainerColor = Color.Transparent
        ),
        placeholder = {
            Text("Entrer une description sur l'évènement...")
        }
    )
}

@Composable
fun SplashScreen(activity: Activity) {
    val image = painterResource(R.drawable.background_get)
    Box() {
        Image(
            modifier = Modifier.size(900.dp),
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.FillHeight,
        )
        FormulaireLayout(activity)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SplashScreenPreview() {
//    MyApplicationTheme {
//        SplashScreen()
//    }
//}