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
