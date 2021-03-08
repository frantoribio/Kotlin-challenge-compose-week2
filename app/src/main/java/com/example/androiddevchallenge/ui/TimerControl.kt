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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExposureNeg1
import androidx.compose.material.icons.filled.ExposurePlus1
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.gray

@Composable
fun TimerControl(
    modifier: Modifier = Modifier,
    number: Int,
    onPlusClicked: () -> Unit,
    onNegClicked: () -> Unit
) {
    Column(
        modifier = modifier
            .padding(20.dp)
            .height(400.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Button(
            onClick = {
                onPlusClicked.invoke()
            },
            shape = RoundedCornerShape(50),
            contentPadding = PaddingValues(12.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 24.dp,
                pressedElevation = 4.dp
            ),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ExposurePlus1,
                contentDescription = "",
                tint = gray,
                modifier = Modifier.fillMaxSize()
            )
        }
        TimerText(
            number = number,
            modifier = Modifier
        )
        Button(
            onClick = {
                onNegClicked.invoke()
            },
            shape = RoundedCornerShape(50),
            contentPadding = PaddingValues(12.dp),
            elevation = ButtonDefaults.elevation(
                defaultElevation = 24.dp,
                pressedElevation = 4.dp
            ),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
            modifier = Modifier.size(50.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ExposureNeg1,
                contentDescription = "",
                tint = gray,
                modifier = Modifier.fillMaxSize()
            )
        }
    }
}
