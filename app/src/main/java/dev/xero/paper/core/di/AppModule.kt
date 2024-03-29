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
package dev.xero.paper.core.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.xero.paper.data.datasource.db.NoteDB
import dev.xero.paper.data.repository.NoteRepositoryImpl
import dev.xero.paper.domain.repository.NoteRepository
import dev.xero.paper.domain.usecases.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Provides
	@Singleton
	fun providesNoteDatabase(app: Application): NoteDB {
		return Room.databaseBuilder(
			app.applicationContext,
			NoteDB::class.java,
			NoteDB.DATABASE_NAME
		).build()
	}

	@Provides
	@Singleton
	fun providesNoteRepository(db: NoteDB): NoteRepository {
		return NoteRepositoryImpl(dao = db.noteDAO)
	}

	@Provides
	@Singleton
	fun providesNoteUseCases(repository: NoteRepository): NoteUseCases {
		return NoteUseCases(
			getNotesUseCase = GetNotesUseCase(repository),
			getNoteUseCase = GetNoteUseCase(repository),
			addNoteUseCase = AddNoteUseCase(repository),
			updateNoteUseCase = UpdateNoteUseCase(repository),
			deleteNoteUseCase = DeleteNoteUseCase(repository)
		)
	}

}