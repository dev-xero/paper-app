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
package dev.xero.paper.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.xero.paper.presentation.notes.edit_notes.EditNoteScreen
import dev.xero.paper.presentation.notes.edit_notes.EditNoteScreenViewModel
import dev.xero.paper.presentation.notes.notes_list.HomeScreen
import dev.xero.paper.presentation.notes.notes_list.HomeScreenViewModel

enum class Screens {
	Home,
	EditNote
}

@Composable
fun SetupNavGraph(
	navHostController: NavHostController
) {
	NavHost(
		navController = navHostController,
		startDestination = Screens.Home.name
	) {
		// ROUTE: Home
		composable(route = Screens.Home.name) {
			val viewModel = hiltViewModel<HomeScreenViewModel>()
			HomeScreen(
				viewModel = viewModel,
				onAddNoteButtonClicked = { navHostController.navigate(Screens.EditNote.name) }
			)
		}

		// ROUTE: Edit Note
		composable(route = Screens.EditNote.name) {
			val viewModel = hiltViewModel<EditNoteScreenViewModel>()
			EditNoteScreen(
				viewModel = viewModel,
				onBackButtonClicked = { navHostController.navigate(Screens.Home.name) },
				onSaveNoteButtonClicked = { navHostController.navigate(Screens.Home.name) }
			)
		}
	}
}
