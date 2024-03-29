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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.xero.paper.domain.model.NoteDBEntity
import dev.xero.paper.domain.usecases.NoteUseCases
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
	private val noteUseCases: NoteUseCases
) : ViewModel() {
	var notes: LiveData<List<NoteDBEntity>> = noteUseCases.getNotesUseCase().map {
		it.asReversed()
	}.asLiveData()

	private var selectedNote: NoteDBEntity? = null
	var searchQuery: String by mutableStateOf("")

	fun selectNote(note: NoteDBEntity) {
		selectedNote = note
	}

	fun updateSearchQuery(query: String) {
		searchQuery = query
		notes = if (searchQuery.isNotBlank()) {
			noteUseCases.getNotesUseCase().map {
				it.asReversed().filter { note ->
					note.title.lowercase().contains(searchQuery.lowercase())
				}
			}.asLiveData()
		} else {
			noteUseCases.getNotesUseCase().map {
				it.asReversed()
			}.asLiveData()
		}
	}

	fun deleteNote() {
		if (selectedNote != null) {
			viewModelScope.launch {
				noteUseCases.deleteNoteUseCase(selectedNote!!)
			}
		}
	}

}