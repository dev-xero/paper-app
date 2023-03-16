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
package dev.xero.paper.presentation.notes.notes_list.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import dev.xero.paper.domain.model.NoteDBEntity

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun NoteGrid(
	notes: State<List<NoteDBEntity>>,
	isDarkTheme: Boolean,
	onDoubleTap: (note: NoteDBEntity) -> Unit,
	modifier: Modifier = Modifier
) {
	LazyVerticalStaggeredGrid(
		columns = StaggeredGridCells.Adaptive(128.dp),
		modifier = modifier
			.fillMaxSize()
			.padding(horizontal = 12.dp),
		contentPadding = PaddingValues(12.dp),
		horizontalArrangement = Arrangement.spacedBy(8.dp),
		verticalArrangement = Arrangement.spacedBy(8.dp)
	) {
		items(notes.value, key = { note -> note.id }) { note ->
			NoteItem(
				note = note,
				isDarkTheme = isDarkTheme,
				onDoubleTap = { onDoubleTap(note) }
			)
		}
	}
}