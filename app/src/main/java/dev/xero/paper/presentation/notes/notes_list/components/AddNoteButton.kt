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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dev.xero.paper.R
import dev.xero.paper.presentation.ui.theme.OnSurface
import dev.xero.paper.presentation.ui.theme.SurfaceDark

@Composable
fun AddNoteButton(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean
) {
	Row(
		modifier = modifier.padding(horizontal = 24.dp),
		horizontalArrangement = Arrangement.spacedBy(8.dp),
		verticalAlignment = Alignment.CenterVertically
	) {
		Icon(
			painter = painterResource(id = R.drawable.app_icon_light),
			contentDescription = "add note",
			tint = if (isDarkTheme) SurfaceDark else OnSurface,
			modifier = Modifier.size(18.dp)
		)

		Text(
			text = "Add Note",
			style = MaterialTheme.typography.subtitle2,
			color = if (isDarkTheme) SurfaceDark else OnSurface,
			fontWeight = FontWeight.Bold,
		)
	}
}
