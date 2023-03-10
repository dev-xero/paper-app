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

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.xero.paper.domain.model.NoteDBEntity
import dev.xero.paper.domain.usecases.NoteUseCases
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
	private val noteUseCases: NoteUseCases
) : ViewModel() {
	var notes: LiveData<List<NoteDBEntity>> = noteUseCases.getNotesUseCase().asLiveData()

	fun addNote(note: NoteDBEntity) {
		viewModelScope.launch {
			noteUseCases.addNoteUseCase(note)
		}
	}

}