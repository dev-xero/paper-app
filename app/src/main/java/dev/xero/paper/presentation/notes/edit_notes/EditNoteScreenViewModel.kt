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

import android.util.Log
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
	private val useCases: NoteUseCases,
) : ViewModel() {

	var title: String by mutableStateOf("")
	var content: String by mutableStateOf("")
	var currentNote: NoteDBEntity? = null

	fun updateTitle(value: String) {
		title = value
	}

	fun updateContent(value: String) {
		content = value
	}

	fun addNote() {
		val newNote = NoteDBEntity(
			title = title.ifBlank { "Title" },
			content = content
		)
		viewModelScope.launch {
			useCases.addNoteUseCase(newNote)
		}
	}

	fun getNote(id: Long) {
		viewModelScope.launch {
			currentNote = useCases.getNoteUseCase(id)
			if (currentNote != null) {
				title = currentNote!!.title
				content = currentNote!!.content
			}
		}
	}

	fun updateNote() {
		val updatedNote = NoteDBEntity(
			id = currentNote!!.id,
			title = title,
			content = content
		)
		Log.d("APP", currentNote.toString())
		viewModelScope.launch {
			useCases.updateNoteUseCase(updatedNote)
		}
	}

}