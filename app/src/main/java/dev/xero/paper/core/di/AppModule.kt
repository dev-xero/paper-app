package dev.xero.paper.core.di

import androidx.room.Room
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.xero.paper.data.db.NoteDB

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	fun providesNoteDatabase(): NoteDB {
		Room.databaseBuilder(

		)
	}
}