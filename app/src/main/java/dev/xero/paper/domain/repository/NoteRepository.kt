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
package dev.xero.paper.domain.repository

import dev.xero.paper.domain.model.NoteDBEntity
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
	fun getAllNotes()
		: Flow<List<NoteDBEntity>>

	suspend fun getNoteById(id: Long)
		: NoteDBEntity?

	suspend fun addNote(note: NoteDBEntity)

	suspend fun updateNote(note: NoteDBEntity)

	suspend fun deleteNote(note: NoteDBEntity)
}