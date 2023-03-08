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
package dev.xero.paper.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
* [2023] Dev XERO - PAPER
*
* [Note] Table
*
* [id] - Note ID
* [title] - Note Title
* [content] - Note Content
*
* */
@Entity(tableName = "notes")
data class Note(
	@PrimaryKey(autoGenerate = true) val id: Int? = null,
	@ColumnInfo(name = "title") val title: String,
	@ColumnInfo(name = "content") val content: String
)