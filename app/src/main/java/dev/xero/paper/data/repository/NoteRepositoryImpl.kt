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
package dev.xero.paper.data.repository

import dev.xero.paper.data.datasource.db.NoteDAO
import dev.xero.paper.domain.model.NoteDBEntity
import dev.xero.paper.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NoteRepositoryImpl @Inject constructor (
	private val dao: NoteDAO
) : NoteRepository {
	override fun getAllNotes(): Flow<List<NoteDBEntity>> {
		return dao.getAllNotes()
	}

	override suspend fun getNoteById(id: Long): NoteDBEntity? {
		return dao.getNoteById(id)
	}

	override fun searchNotes(query: String): Flow<List<NoteDBEntity>>? {
		return dao.searchNotes(query)
	}


	override suspend fun addNote(note: NoteDBEntity) {
		return dao.addNote(note)
	}

	override suspend fun updateNote(note: NoteDBEntity) {
		return dao.updateNote(note)
	}

	override suspend fun deleteNote(note: NoteDBEntity) {
		return dao.deleteNote(note)
	}
}