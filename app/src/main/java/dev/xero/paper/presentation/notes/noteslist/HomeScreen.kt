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
package dev.xero.paper.presentation.notes.noteslist

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import dev.xero.paper.presentation.notes.noteslist.components.SearchBar

@Composable
fun HomeScreen(
	modifier: Modifier = Modifier,
	viewModel: HomeScreenViewModel = hiltViewModel()
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
		}
	)
	{ padding ->
		LazyColumn(
			modifier = modifier.padding(8.dp)
		) {
			items(notes.value, key = { note -> note.id }) { note ->
				Text(text = note.title)
			}
		}
	}
}