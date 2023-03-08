package dev.xero.paper.core.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dev.xero.paper.data.db.NoteDB
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

	@Provides
	@Singleton
	fun providesNoteDatabase(app: Application): NoteDB {
		return Room.databaseBuilder(
			app,
			NoteDB::class.java,
			NoteDB.DATABASE_NAME
		).build()
	}
}