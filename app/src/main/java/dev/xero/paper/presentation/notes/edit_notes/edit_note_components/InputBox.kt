/*
 * Copyright (C) 2023 - Xero
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
package dev.xero.paper.presentation.notes.edit_notes.edit_note_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import dev.xero.paper.presentation.notes.edit_notes.utils.InputType
import dev.xero.paper.presentation.ui.theme.*

@Composable
fun InputBox(
	modifier: Modifier = Modifier,
	inputType: InputType,
	isDarkTheme: Boolean,
	value: String,
	onValueChange: (String) -> Unit,
	keyboardActions: KeyboardActions,
	keyboardOptions: KeyboardOptions,
	focusRequester: FocusRequester? = null
) {
	val colorMap: Map<String, Color> = mapOf(
		"main" to when(isDarkTheme) {
			true -> BgDark
			else -> OnSurface
		},
		"placeholder_title" to when(isDarkTheme) {
			true -> OnSurface
			else -> Grey500
		},
		"placeholder_content" to when(isDarkTheme) {
			true -> Grey100
			else -> Grey100
		}
	)

	OutlinedTextField(
		value = value,
		onValueChange = onValueChange,
		modifier = when(inputType) {
			InputType.Title -> {
				modifier
					.fillMaxWidth()
					.focusRequester(focusRequester!!)
			}
			else -> modifier.fillMaxWidth()
	  },
		singleLine = inputType == InputType.Title,
		textStyle = if (inputType == InputType.Title) {
			MaterialTheme.typography.h3
		} else {
			MaterialTheme.typography.h4
	  },
		placeholder = {
			Text(
				text = if (inputType == InputType.Title) "Title" else "content...",
				style = if (inputType == InputType.Title) {
					MaterialTheme.typography.h3
				} else {
					MaterialTheme.typography.h4
				}
			)
		},
		colors = TextFieldDefaults.outlinedTextFieldColors(
			backgroundColor = colorMap["main"]!!,
			focusedBorderColor = colorMap["main"]!!,
			unfocusedBorderColor = colorMap["main"]!!,
			placeholderColor = when(inputType) {
				InputType.Title -> colorMap["placeholder_title"]!!
				else -> colorMap["placeholder_content"]!!
			},
			cursorColor = Primary,
			textColor = when(inputType) {
				InputType.Title -> {
					if (isDarkTheme) OnSurface else Grey500
				}
				else -> {
					if (isDarkTheme) Grey100 else Grey300
				}
			}
		),
		keyboardActions = keyboardActions,
		keyboardOptions = keyboardOptions
	)

	if (inputType == InputType.Title) {
		LaunchedEffect(Unit) {
			focusRequester!!.requestFocus()
		}
	}
}