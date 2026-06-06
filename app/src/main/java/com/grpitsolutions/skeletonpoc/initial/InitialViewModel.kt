package com.grpitsolutions.skeletonpoc.initial

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.grpitsolutions.core.domain.card.Card
import com.grpitsolutions.core.domain.card.LocalCardDataSource
import com.grpitsolutions.core.domain.user.LocalUserDataSource
import com.grpitsolutions.core.domain.user.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class InitialViewModel(
    private val localUserDataSource: LocalUserDataSource,
    private val localCardDataSource: LocalCardDataSource
) : ViewModel() {

    private var hasLoadedInitialData = false

    private val _state = MutableStateFlow(InitialState())
    val state = _state
        .onStart {
            if (!hasLoadedInitialData) {
                /** Load initial data here **/
                hasLoadedInitialData = true
            }
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000L),
            initialValue = InitialState()
        )

    fun onAction(action: InitialAction) {
        when (action) {
            InitialAction.AddCard -> { tryAddCard() }
            InitialAction.AddPerson -> { tryAddPerson() }
            InitialAction.ListAllCards -> TODO()
            InitialAction.ListAllPersons -> TODO()
        }
    }

    private fun tryAddPerson(){
        val userGenerated = generateRandomUser()
        Log.d("RND USER","RND User created: ${userGenerated.toString()}")
        viewModelScope.launch {
            localUserDataSource.upsertUser(user = userGenerated)
        }
    }

   private fun generateRandomUser(): User {
        val sampleNames = listOf("Alice", "Bob", "Charlie", "Diana", "Ethan", "Fiona", "George", "Hannah")

        return User(
            name = sampleNames.random(),
            age = (18..99).random(),
            document = (100000000..999999999).random()
        )
    }

    private fun tryAddCard(){
        val cardGenerated = generateRandomCard()
        Log.d("RND CARD", "RND Card created: ${cardGenerated.toString()}")
        viewModelScope.launch {
            localCardDataSource.upsertCard(cardGenerated)
        }
    }

    fun generateRandomCard(): Card {
        val sampleNames = listOf("JOHN DOE", "JANE SMITH", "ALICE JOHNSON", "BOB WILLIAMS", "CARLOS SILVA")

        return Card(
            nameOnCard = sampleNames.random(),
            cardNumber = (100000000..999999999).random(),
            cardCvv = (100..999).random()
        )
    }

}