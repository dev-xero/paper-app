package dev.xero.paper.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notes")
data class Note(
	@PrimaryKey(autoGenerate = true) val id: Int? = null,
	@ColumnInfo(name = "title") val title: String,
	@ColumnInfo(name = "content") val content: String
)