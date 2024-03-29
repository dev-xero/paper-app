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

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import dev.xero.paper.R
import dev.xero.paper.presentation.ui.theme.*

@Composable
fun HomeDisplay(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean
) {
	Column(
		modifier = Modifier
			.fillMaxWidth()
			.background(
				color = if (isDarkTheme) BgDark else OnSurface
			)
	) {
		Text(
			text = stringResource(id = R.string.home_text),
			modifier = modifier.padding(
				top = 12.dp
			),
			style = MaterialTheme.typography.h3,
			color = when(isDarkTheme) {
				true -> OnSurface
				else -> Black
			}
		)
		Text(
			text = stringResource(id = R.string.efficiently),
			style = MaterialTheme.typography.h4,
			modifier = Modifier.padding(
				start = 40.dp,
				top = 8.dp
			),
			color = when(isDarkTheme) {
				true -> Primary
				else -> Grey500
			}
		)
	}
}