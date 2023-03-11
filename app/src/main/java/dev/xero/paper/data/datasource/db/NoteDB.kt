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
package dev.xero.paper.data.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import dev.xero.paper.domain.model.NoteDBEntity

@Database(
	entities = [NoteDBEntity::class],
	version = 1
)
abstract class NoteDB : RoomDatabase() {
	abstract val noteDAO: NoteDAO

	companion object {
		const val DATABASE_NAME = "notes_db"
	}
}