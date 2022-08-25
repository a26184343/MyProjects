package com.example.composewithviewmodel.present

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.composewithviewmodel.data.getFoodPriceList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FoodViewModel : ViewModel() {
    private val _foodState = MutableStateFlow(FoodState())
    val foodState: StateFlow<FoodState> = _foodState.asStateFlow()

    var userSearchString by mutableStateOf("")
        private set

    init {
        reset()
    }

    fun reset() {
        userSearchString = ""
        _foodState.value = FoodState(currentFood = "", currentPrice = 0)
    }

    fun userSearchFood(foodName: String) {
        userSearchString = foodName
    }

    //listen to the text field and update the change
    fun updateUserSearch(searchString: String) {
        userSearchString = searchString
    }

    //check the user's search is in the map
    fun checkUserSearch() {
        if(getFoodPriceList.containsKey(userSearchString))
            updateFoodState(userSearchString)
        else {
            _foodState.update {currentState ->
                currentState.copy(noSuchFood = true)
            }
        }
    }

    //update food state
    fun updateFoodState(foodName: String) {
        _foodState.update {currentState ->
            currentState.copy(
                currentFood = foodName,
                currentPrice = getFoodPriceList.get(foodName),
                noSuchFood = false
            )
        }
    }
}