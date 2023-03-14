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
package dev.xero.paper.presentation.notes.edit_notes

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import dev.xero.paper.presentation.notes.edit_notes.edit_note_components.BackButton
import dev.xero.paper.presentation.notes.edit_notes.edit_note_components.InputBox
import dev.xero.paper.presentation.notes.edit_notes.edit_note_components.SaveNoteButton
import dev.xero.paper.presentation.notes.edit_notes.utils.InputType
import dev.xero.paper.presentation.ui.theme.Primary
import dev.xero.paper.presentation.ui.theme.Secondary
import dev.xero.paper.presentation.ui.theme.SurfaceDark

@Composable
fun EditNoteScreen(
	modifier: Modifier = Modifier,
	viewModel: EditNoteScreenViewModel,
	onBackButtonClicked: () -> Unit,
	onSaveNoteButtonClicked: () -> Unit
) {
	val isDarkTheme = isSystemInDarkTheme()
	val title = viewModel.title
	val content = viewModel.content
	val focusManager = LocalFocusManager.current
	val focusRequester = remember { FocusRequester() }

	Scaffold(
		topBar = {
			Row(
				modifier = modifier
					.fillMaxWidth()
					.background(
						when (isDarkTheme) {
							true -> SurfaceDark
							else -> Secondary
						}
					)
			) {
				BackButton(
					isDarkTheme = isDarkTheme,
					modifier = Modifier.padding(
						horizontal = 6.dp,
						vertical = 8.dp
					),
					onButtonClick = onBackButtonClicked
				)
			}
		},
		floatingActionButton = {
			FloatingActionButton(
				onClick = {
					viewModel.addNote()
					onSaveNoteButtonClicked()
				},
				backgroundColor = Primary,
				shape = RoundedCornerShape(4.dp),
				elevation = FloatingActionButtonDefaults.elevation(
					defaultElevation = 0.dp,
					pressedElevation = 0.dp,
					focusedElevation = 0.dp,
					hoveredElevation = 0.dp
				)
			) {
				SaveNoteButton(
					isDarkTheme = isDarkTheme
				)
			}
		}
	) {padding ->
		Column(
			verticalArrangement = Arrangement.spacedBy(4.dp)
		) {
			InputBox(
				inputType = InputType.Title,
				isDarkTheme = isDarkTheme,
				value = title,
				onValueChange = {
					viewModel.updateTitle(it)
				},
				keyboardActions = KeyboardActions(
					onNext = { focusManager.moveFocus(FocusDirection.Down) }
				),
				keyboardOptions = KeyboardOptions.Default.copy(
					imeAction = ImeAction.Next
				),
				focusRequester = focusRequester
			)

			Canvas(
				modifier = Modifier
					.size(
						width = 100.dp,
						height = 2.dp
					)
					.padding(start = 12.dp)
			) {
				drawRoundRect(
					color = Primary,
					size = size
				)
			}

			InputBox(
				inputType = InputType.Content,
				isDarkTheme = isDarkTheme,
				value = content,
				onValueChange = {
					viewModel.updateContent(it)
				},
				keyboardActions = KeyboardActions(
					onDone = { focusManager.clearFocus() }
				),
				keyboardOptions = KeyboardOptions.Default.copy(
					imeAction = ImeAction.Done
				)
			)
		}
	}
}