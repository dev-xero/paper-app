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