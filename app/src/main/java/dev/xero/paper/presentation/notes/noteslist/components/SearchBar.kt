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
package dev.xero.paper.presentation.notes.noteslist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.xero.paper.R
import dev.xero.paper.presentation.ui.theme.*

@Composable
fun SearchBar(
	modifier: Modifier = Modifier,
	searchContent: String,
	onSearchContentChange: (String) ->  Unit,
	deviceThemeDark: Boolean
) {
	val searchIcon = when(deviceThemeDark) {
		true -> R.drawable.search_icon_dark
		else -> R.drawable.search_icon_light
	}

	val colorMapping: Map<String, Color> = mapOf(
		"placeholder" to if (deviceThemeDark) Grey100 else Grey300,
		"background" to if (deviceThemeDark) SurfaceDark else Secondary
	)

	Row(modifier = modifier.fillMaxWidth()) {
		OutlinedTextField(
			value = searchContent,
			onValueChange = onSearchContentChange,
			singleLine = true,
			maxLines = 1,
			placeholder = { Text(text = "search your notes") },
			leadingIcon = {
				Image(
					painter = painterResource(id = searchIcon),
					contentDescription = null
				)
			},
			colors = TextFieldDefaults.outlinedTextFieldColors(
				placeholderColor = colorMapping["placeholder"]!!,
				unfocusedBorderColor = colorMapping["background"]!!,
				focusedBorderColor = colorMapping["background"]!!,
				backgroundColor = colorMapping["background"]!!,
				cursorColor = Primary
			),
			shape = RoundedCornerShape(2.dp),
			modifier = Modifier.fillMaxWidth()
		)
	}
}

@Preview
@Composable
fun SearchBarDefaultPreview() {
	Box(
		modifier = Modifier
			.fillMaxSize()
			.background(OnSurface),
	) {
		var searchContentFake = ""
		SearchBar(
			searchContent = searchContentFake,
			onSearchContentChange = { searchContentFake = it },
			deviceThemeDark = false
		)
	}
}
