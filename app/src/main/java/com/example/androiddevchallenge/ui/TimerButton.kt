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

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pause
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.green
import com.example.androiddevchallenge.ui.theme.red

@Composable
fun TimerButton(
    isStarted: Boolean,
    onStartClicked: () -> Unit,
    onStopClicked: () -> Unit
) {
    Button(
        onClick = {
            if (isStarted) {
                onStopClicked.invoke()
            } else {
                onStartClicked.invoke()
            }
        },
        shape = RoundedCornerShape(50),
        contentPadding = PaddingValues(12.dp),
        elevation = ButtonDefaults.elevation(
            defaultElevation = 24.dp,
            pressedElevation = 4.dp
        ),
        colors = if (isStarted) {
            ButtonDefaults.buttonColors(backgroundColor = red)
        } else {
            ButtonDefaults.buttonColors(backgroundColor = green)
        },
        modifier = Modifier.size(50.dp)
    ) {
        Icon(
            imageVector = if (isStarted) {
                Icons.Default.Pause
            } else {
                Icons.Default.PlayArrow
            },
            contentDescription = "",
            tint = Color.White,
            modifier = Modifier.fillMaxSize()
        )
    }
}
