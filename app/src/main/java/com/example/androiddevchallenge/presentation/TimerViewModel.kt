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
package com.example.androiddevchallenge.presentation

import android.os.CountDownTimer
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.TimerState

class TimerViewModel : ViewModel() {

    private var timer: CountDownTimer? = null

    var isStarted by mutableStateOf(false)
        private set

    var timerState by mutableStateOf(TimerState())

    var totalMilliseconds by mutableStateOf(0)

    fun Long.toTimerState() =
        TimerState(
            minutes = ((this / 1000) / 60).toInt(),
            seconds = ((this / 1000) % 60).toInt(),
        )

    fun TimerState.toMilliseconds() =
        ((this.minutes * 60 + this.seconds) * 1000).toLong()

    fun startCountdown() {
        isStarted = true
        totalMilliseconds = timerState.toMilliseconds().toInt()
        timer = object : CountDownTimer(timerState.toMilliseconds(), 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timerState = millisUntilFinished.toTimerState()
            }

            override fun onFinish() {
                stopCountdown()
            }
        }.start()
    }

    fun stopCountdown() {
        isStarted = false
        timer?.apply {
            cancel()
            timer = null
        }
    }

    fun incrementMinutes() {
        timerState = timerState.run {
            when {
                timerState.minutes >= 59 -> {
                    copy(
                        minutes = 0,
                        seconds = 0
                    )
                }
                else -> {
                    copy(minutes = minutes + 1)
                }
            }
        }
    }

    fun decrementMinutes() {
        timerState = timerState.run {
            when {
                timerState.minutes <= 0 -> {
                    copy(minutes = 59)
                }
                else -> copy(minutes = minutes - 1)
            }
        }
    }

    fun incrementSeconds() {
        timerState = timerState.run {
            val setMinutes = if (timerState.minutes < 59) {
                timerState.minutes + 1
            } else {
                0
            }
            when {
                timerState.seconds >= 59 -> {
                    copy(
                        minutes = setMinutes,
                        seconds = 0
                    )
                }
                else -> {
                    copy(seconds = seconds + 1)
                }
            }
        }
    }

    fun decrementSeconds() {
        timerState = timerState.run {
            when {
                timerState.seconds <= 0 -> {
                    copy(seconds = 59)
                }
                else -> copy(seconds = seconds - 1)
            }
        }
    }
}
