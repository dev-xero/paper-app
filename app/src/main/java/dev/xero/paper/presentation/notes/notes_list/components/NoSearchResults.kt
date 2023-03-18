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
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import dev.xero.paper.R


@Composable
fun NoSearchResult(
	modifier: Modifier = Modifier,
	isDarkTheme: Boolean,
	query: String
) {
	Box(
		contentAlignment = Alignment.Center
	) {
		LazyColumn(
			modifier = modifier
				.fillMaxSize()
				.padding(24.dp),
			verticalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterVertically),
			horizontalAlignment = Alignment.CenterHorizontally
		) {
			item {
				val resID = when(isDarkTheme) {
					true -> R.drawable.document_blush_dark
					else -> R.drawable.document_blush_light
				}

				Image(
					painter = painterResource(id = resID),
					contentDescription = "no results found"
				)

				Text(
					text = "No Results for\n \"$query\"",
					style = MaterialTheme.typography.h3,
					textAlign = TextAlign.Center
				)
			}
		}
	}
}