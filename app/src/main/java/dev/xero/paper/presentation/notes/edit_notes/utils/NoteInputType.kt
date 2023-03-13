package dev.xero.paper.presentation.notes.edit_notes.utils

enum class InputType {
	Title,
	Content
}

sealed class NoteInputType(val inputType: InputType) {
	class Title(inputType: InputType): NoteInputType(InputType.Title)
	class Content(inputType: InputType): NoteInputType(InputType.Content)
}
