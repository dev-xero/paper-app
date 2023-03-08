package dev.xero.paper.data.db

import androidx.room.Database
import dev.xero.paper.data.db.entities.Note

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
