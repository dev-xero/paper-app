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

import androidx.room.Database
import dev.xero.paper.data.db.entities.Note

/**
 * [2023] Dev XERO - PAPER
 *
 * [NoteDB] Note Room Database
 *
 * [noteDAO] Note Data Access Object
 * [DATABASE_NAME] Database Name
 * */
@Database(
	entities = [Note::class],
	version = 1
)
abstract class NoteDB {
	abstract val noteDAO: NoteDAO

	companion object {
		const val DATABASE_NAME = "notes_db"
	}
}
