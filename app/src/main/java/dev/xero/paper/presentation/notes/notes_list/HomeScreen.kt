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
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.FloatingActionButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.xero.paper.domain.model.NoteDBEntity
import dev.xero.paper.presentation.notes.notes_list.components.*
import dev.xero.paper.presentation.ui.theme.Primary

@Composable
fun HomeScreen(
	modifier: Modifier = Modifier,
	viewModel: HomeScreenViewModel = hiltViewModel(),
	onAddNoteButtonClicked: () -> Unit
) {
	val notes = viewModel.notes.observeAsState(initial = emptyList())
	val isDarkTheme = isSystemInDarkTheme()

	/*TODO: FAKE DATA, REPLACE LATER */
	var searchContentFake = ""

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
		Column(
			modifier = modifier.fillMaxWidth()
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
				modifier = Modifier.padding(top = 12.dp)
			)
		}
	}
}