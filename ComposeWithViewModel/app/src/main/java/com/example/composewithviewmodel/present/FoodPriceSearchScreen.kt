package com.example.composewithviewmodel.present

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedButton
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composewithviewmodel.R
import com.example.composewithviewmodel.ui.theme.ComposeWithViewModelTheme
import androidx.lifecycle.viewmodel.compose.viewModel

//main screen
@Composable
fun FPSScreen(
    modifier: Modifier = Modifier,
    foodViewModel: FoodViewModel = viewModel()
) {
    val foodState by foodViewModel.foodState.collectAsState()
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        searchText(
            userSearch = foodViewModel.userSearchString,
            noSuchFood = foodState.noSuchFood,
            onUserSearchChanged = {foodViewModel.updateUserSearch(it)},
            searchFood = {foodViewModel.checkUserSearch()}
        )
        resultText(
            matchedFood = foodState.currentFood,
            matchedFoodPrice = foodState.currentPrice
        )
        cleanButton()
    }
}

//search text field:
@Composable
fun searchText(
    modifier: Modifier = Modifier,
    userSearch: String,
    noSuchFood: Boolean,
    onUserSearchChanged:(String) -> Unit,
    searchFood:() -> Unit
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(),
        value = userSearch,
        singleLine = true,
        onValueChange = onUserSearchChanged,
        isError = noSuchFood,
        label = {
            if(noSuchFood)
                Text(stringResource(R.string.noSuchFood))
            else
                Text(stringResource(R.string.searchFood))
        },
        keyboardOptions = KeyboardOptions.Default.copy(
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(
            onDone = { searchFood()}
        )
    )
}

//result text
@Composable
fun resultText(
    modifier:Modifier = Modifier,
    matchedFood: String,
    matchedFoodPrice: Int?
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "$matchedFood",
            fontSize = 30.sp
        )
        Text(
            text = matchedFoodPrice.toString(),
            fontSize = 30.sp
        )
    }
}

//clean button
@Composable
fun cleanButton() {
    OutlinedButton(
        onClick = {},
    ) {
        Text(stringResource(R.string.cleanButton))
    }
}

@Preview
@Composable
fun pre() {
    ComposeWithViewModelTheme {
        FPSScreen()
    }
}