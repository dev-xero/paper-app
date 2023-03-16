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
package dev.xero.paper.presentation.notes.notes_list

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.xero.paper.domain.model.NoteDBEntity
import dev.xero.paper.presentation.notes.notes_list.components.*
import dev.xero.paper.presentation.ui.theme.*
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
	modifier: Modifier = Modifier,
	viewModel: HomeScreenViewModel = hiltViewModel(),
	onAddNoteButtonClicked: () -> Unit,
	onEditNoteButtonClicked: (note: NoteDBEntity) -> Unit
) {
	val notes = viewModel.notes.observeAsState(initial = emptyList())
	val isDarkTheme = isSystemInDarkTheme()

	/*TODO: FAKE DATA, REPLACE LATER */
	var searchContentFake = ""

	val coroutineScope = rememberCoroutineScope()
	val modalSheetState = rememberModalBottomSheetState(
		initialValue = ModalBottomSheetValue.Hidden,
		confirmStateChange = { it != ModalBottomSheetValue.HalfExpanded },
		skipHalfExpanded = true
	)

	ModalBottomSheetLayout(
		sheetState = modalSheetState,
		sheetShape = RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp),
		sheetContent = {
			Column {
				Text(
					text = "Do you want to delete this note?",
					style = MaterialTheme.typography.h3,
					fontSize = 20.sp,
					modifier = modifier.padding(
						top = 24.dp,
						start = 24.dp,
						end = 24.dp,
						bottom = 12.dp
					)
				)
				Text(
					text = "Deleting a note removes it permanently, it can't be undone.",
					style = MaterialTheme.typography.body1,
					fontSize = 16.sp,
					modifier = modifier.padding(
						start = 24.dp,
						end = 24.dp,
						bottom = 12.dp
					),
					color = when(isDarkTheme) {
						true -> Grey100
						else -> Grey500
					}
				)
				Button(
					onClick = {
						coroutineScope.launch {
							viewModel.deleteNote()
							modalSheetState.hide()
						}
					},
					modifier = Modifier.padding(
						vertical = 12.dp,
						horizontal = 24.dp
					)
				) {
					Text(
						text = "Delete Note",
						style = MaterialTheme.typography.subtitle2,
						fontWeight = FontWeight.Bold
					)
				}
			}
		},
		scrimColor = when(isDarkTheme) {
			true -> Color.Black.copy(alpha = 0.6f)
			else -> Color.Black.copy(alpha = 0.6f)
		},
		sheetBackgroundColor = when(isDarkTheme) {
			true -> BgDark
			else -> OnSurface
		}
	) {
		Scaffold(
			topBar = {
				SearchBar(
					searchContent = searchContentFake,
					onSearchContentChange = { searchContentFake = it },
					deviceThemeDark = isDarkTheme,
				)
			},

			floatingActionButton = {
				FloatingActionButton(
					onClick = onAddNoteButtonClicked,
					shape = RoundedCornerShape(4.dp),
					backgroundColor = Primary,
					elevation = FloatingActionButtonDefaults.elevation(
						defaultElevation = 0.dp,
						pressedElevation = 0.dp,
						focusedElevation = 0.dp,
						hoveredElevation = 0.dp
					),
				) {
					AddNoteButton(isDarkTheme = isDarkTheme)
				}
			}
		)
		{ padding ->
			fun onTap(note: NoteDBEntity) {
				onEditNoteButtonClicked(note)
			}

			fun onDoubleTap(note: NoteDBEntity) {
				coroutineScope.launch {
					if (modalSheetState.isVisible)
						modalSheetState.hide()
					else
						modalSheetState.animateTo(ModalBottomSheetValue.Expanded)
				}
				viewModel.selectNote(note)
			}

			Column(
				modifier = Modifier.fillMaxWidth()
			) {
				HomeDisplay(
					isDarkTheme = isDarkTheme,
					modifier = Modifier.padding(horizontal = 12.dp)
				)

				if (notes.value.isEmpty()) {
					Box(contentAlignment = Alignment.Center) {
						LazyColumn(
							modifier = Modifier.fillMaxSize(),
							verticalArrangement = Arrangement.Center
						) {
							item {
								EmptyNoteListDisplay(
									isDarkTheme = isDarkTheme,
									modifier = Modifier.padding(bottom = 64.dp)
								)
							}
						}
					}
				}

				NoteGrid(
					notes = notes,
					isDarkTheme = isDarkTheme,
					modifier = Modifier.padding(top = 12.dp),
					onDoubleTap = {
						onDoubleTap(it)
					},
					onTap = {
						onTap(it)
					}
				)
			}
		}
	}
}