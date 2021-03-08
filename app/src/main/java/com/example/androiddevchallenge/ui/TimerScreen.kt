/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.data.TimerState

@Composable
fun TimerScreen(
    state: TimerState,
    isStarted: Boolean,
    onStartClicked: () -> Unit,
    onStopClicked: () -> Unit,
    onMinutesPlusClicked: () -> Unit,
    onMinutesMinusClicked: () -> Unit,
    onSecondsPlusClicked: () -> Unit,
    onSecondsMinusClicked: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(color = Color.Transparent)
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center
    ) {
        TimerControl(
            modifier = Modifier.weight(3f),
            number = state.minutes,
            onPlusClicked = { onMinutesPlusClicked.invoke() },
            onNegClicked = { onMinutesMinusClicked.invoke() }
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            TimerButton(
                isStarted = isStarted,
                onStartClicked = { onStartClicked.invoke() },
                onStopClicked = { onStopClicked.invoke() }
            )
        }
        TimerControl(
            modifier = Modifier.weight(3f),
            number = state.seconds,
            onPlusClicked = { onSecondsPlusClicked.invoke() },
            onNegClicked = { onSecondsMinusClicked.invoke() }
        )
    }
}
