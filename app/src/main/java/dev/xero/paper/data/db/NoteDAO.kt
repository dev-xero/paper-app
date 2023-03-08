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