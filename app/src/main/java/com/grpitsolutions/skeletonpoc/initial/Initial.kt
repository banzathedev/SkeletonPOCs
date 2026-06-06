package com.grpitsolutions.skeletonpoc.initial

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle

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
    }
}

@Composable
fun SkeletonButton(text: String, onAction: () -> Unit ){
    Button(
        onClick = {onAction()}
    ) { Text(text = text) }
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