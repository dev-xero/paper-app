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
package dev.xero.paper.presentation.notes.edit_notes.edit_note_components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import dev.xero.paper.R
import dev.xero.paper.presentation.ui.theme.Primary
import dev.xero.paper.presentation.ui.theme.Secondary
import dev.xero.paper.presentation.ui.theme.SurfaceDark

@Composable
fun BackButton(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean,
	onButtonClick: () -> Unit
) {
	IconButton(
		onClick = onButtonClick,
		modifier = modifier
			.background(
				color = when(isDarkTheme) {
					true -> SurfaceDark
					else -> Secondary
				},
				shape = CircleShape
			)
	) {
		Icon(
			painter = painterResource(id = R.drawable.back_icon_light),
			contentDescription = null,
			tint = Primary
		)
	}
}