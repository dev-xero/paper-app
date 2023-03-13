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

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.xero.paper.domain.model.NoteDBEntity
import dev.xero.paper.domain.usecases.NoteUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class EditNoteScreenViewModel @Inject constructor (
	val useCases: NoteUseCases
) : ViewModel() {
	var title: String by mutableStateOf("")
	var content: String by mutableStateOf("")

	fun updateTitle(value: String) {
		title = value
		val newNote = NoteDBEntity(
			title = title,
			content = content
		)
		addNote(newNote)
	}

	fun updateContent(value: String) {
		content = value
		val newNote = NoteDBEntity(
			title = title,
			content = content
		)
		addNote(newNote)
	}

	fun addNote(note: NoteDBEntity) {
		viewModelScope.launch {
			useCases.addNoteUseCase(note)
		}
	}

}