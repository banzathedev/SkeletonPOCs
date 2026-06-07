package com.grpitsolutions.skeletonpoc.initial

import android.graphics.fonts.FontStyle
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.grpitsolutions.core.domain.card.Card

import com.grpitsolutions.skeletonpoc.ui.theme.SkeletonPOCTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun InitialRoot(
    viewModel: InitialViewModel = koinViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    InitialScreen(
        state = state,
        onAction = viewModel::onAction
    )
}

@Composable
fun InitialScreen(
    state: InitialState,
    onAction: (InitialAction) -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(24.dp))
        SkeletonButton("add randomPerson") { onAction(InitialAction.AddPerson) }
        SkeletonButton("add paymentCard") { onAction(InitialAction.AddCard) }
        SkeletonButton("listCards") { onAction(InitialAction.ListAllCards) }
        Spacer(Modifier.height(24.dp))
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = state.cardList,
                key = { card -> card.cardCvv } // Otimização para ajudar o Compose a identificar itens únicos
            ) { card ->
                CardItem(item = card)
            }
        }
    }
}

@Composable
fun SkeletonButton(text: String, onAction: () -> Unit ){
    Button(
        onClick = {onAction()}
    ) { Text(text = text) }
}

@Composable
fun CardItem(item: Card){
    androidx.compose.material3.Card(
        modifier = Modifier.fillMaxWidth(),
        border = BorderStroke(width = 2.dp, color = Color.Black)
    ) {
        Column(
            modifier = Modifier.padding(12.dp)
        ) {
            Text(
                text = "card info",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
            Text(text = "Name on card : ${item.nameOnCard}")
            Text(text = "Card number : ${item.cardNumber}")
            Text(text = "Card cvv : ${item.cardCvv}")
            Text(text = "Card id: ${item.cardID}")
        }
    }
}

@Preview
@Composable
private fun CardPrev(){
    SkeletonPOCTheme() {
        CardItem(Card(
            nameOnCard = "Jane Doe",
            cardNumber = 122454321,
            cardCvv = 123,
            cardID = 1333
        ))
    }
}

@Preview
@Composable
private fun Preview() {
    SkeletonPOCTheme() {
        InitialScreen(
            state = InitialState(),
            onAction = {}
        )
    }
}