package dev.xero.paper.data.db

import androidx.room.*
import dev.xero.paper.data.db.entities.Note

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