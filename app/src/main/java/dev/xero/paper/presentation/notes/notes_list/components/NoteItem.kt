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
package dev.xero.paper.presentation.notes.notes_list.components

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.xero.paper.domain.model.NoteDBEntity
import dev.xero.paper.presentation.ui.theme.*

@Composable
fun NoteItem(
	note: NoteDBEntity,
	isDarkTheme: Boolean,
	modifier: Modifier = Modifier,
	onDoubleTap: () -> Unit
) {
	Card(
		shape = RoundedCornerShape(4.dp),
		elevation = 0.dp,
		backgroundColor = if (isDarkTheme) SurfaceDark else Secondary,
		modifier = modifier
			.pointerInput(Unit) {
				detectTapGestures (
					onDoubleTap = { onDoubleTap() }
				)
			}
	) {
		Column(
			modifier = Modifier
				.padding(16.dp)
		) {
			Text(
				text = note.title,
				style = MaterialTheme.typography.subtitle1,
				fontSize = 18.sp,
				color = if (isDarkTheme) Primary else Grey500,
				maxLines = 2,
				overflow = TextOverflow.Ellipsis,
				modifier = Modifier.padding(bottom = 8.dp),
				fontWeight = FontWeight.Black
			)
			Text(
				text = note.content,
				style = MaterialTheme.typography.body1,
				color = if (isDarkTheme) Grey100 else Grey300,
				maxLines = 6,
				fontSize = 14.sp,
				overflow = TextOverflow.Ellipsis
			)
		}
	}
}
