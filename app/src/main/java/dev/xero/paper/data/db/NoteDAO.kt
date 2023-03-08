/*
 * Copyright (C) 2023 Dev Xero
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package dev.xero.paper.data.db

import androidx.room.*
import dev.xero.paper.data.db.entities.Note

/**
 * [2023] Dev XERO - PAPER
 *
 * [NoteDAO] Note Data Access Object
 *
 * [getNotes] - Return a List of [Note]
 * [getNote] - Return a particular [Note] by id, nullable
 * [addNote] - Add a note
 * [deleteNote] - Delete a note
 * */
@Dao
interface NoteDAO {

	@Query("SELECT * FROM notes")
	fun getNotes(): List<Note>

	@Query("SELECT * FROM notes WHERE id =:id")
	suspend fun getNote(id: Int): Note?

	@Insert(onConflict = OnConflictStrategy.REPLACE)
	suspend fun addNote(note: Note)

	@Delete
	suspend fun deleteNote(note: Note)
}