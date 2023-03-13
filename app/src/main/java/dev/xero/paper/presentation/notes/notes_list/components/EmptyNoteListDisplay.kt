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

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.xero.paper.R
import dev.xero.paper.presentation.ui.theme.Grey100
import dev.xero.paper.presentation.ui.theme.Grey300

@Composable
fun EmptyNoteListDisplay(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean
) {
	Column(
		modifier = modifier.fillMaxSize(),
		verticalArrangement = Arrangement.spacedBy(24.dp, Alignment.CenterVertically),
		horizontalAlignment = Alignment.CenterHorizontally
	) {
		val documentIconRes = when(isDarkTheme) {
			true -> R.drawable.document_icon_dark
			else -> R.drawable.document_icon_light
		}

		Image(
			painter = painterResource(id = documentIconRes),
			contentDescription = "no notes found",
			modifier = Modifier.align(Alignment.CenterHorizontally)
		)
		
		Text(
			text = stringResource(id = R.string.note_tip),
			style = MaterialTheme.typography.subtitle2,
			color = when(isDarkTheme) {
				true -> Grey100
				else -> Grey300
			}
		)
	}
}
