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

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideIn
import androidx.compose.animation.slideOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntOffset
import com.example.androiddevchallenge.ui.theme.gray
import com.example.androiddevchallenge.ui.theme.lightGray

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun AnimatedScreen(
    time: Int
) {
    Box(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = lightGray)
    )
    AnimatedVisibility(
        time == 0,
        enter = slideIn(
            { fullSize -> IntOffset(0, fullSize.height * 2) },
            tween(
                1000,
                easing = LinearOutSlowInEasing
            )
        ),
        exit = slideOut(
            { fullSize -> IntOffset(0, fullSize.height) },
            tween(
                time,
                easing = FastOutSlowInEasing
            )
        )
    ) {
        Box(
            Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background(color = gray)
        )
    }
}
