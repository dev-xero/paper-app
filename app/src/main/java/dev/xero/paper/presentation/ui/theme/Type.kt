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
package dev.xero.paper.presentation.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import dev.xero.paper.R

val AvenirLT = FontFamily(
	Font(
		resId = R.font.avenir_lt_book,
		weight = FontWeight.Normal
	),

	Font(
		resId = R.font.avenir_lt_medium,
		weight = FontWeight.Medium
	),

	Font(
		resId = R.font.avenir_lt_black,
		weight = FontWeight.Black
	)
)

val CoreSans = FontFamily(
	Font(
		resId = R.font.core_sans_regular,
		weight = FontWeight.Normal
	),

	Font(
		resId = R.font.core_sans_bold,
		weight = FontWeight.Bold
	)
)

val OutFit = FontFamily(
	Font(
		resId = R.font.outfit_regular,
		weight = FontWeight.Normal
	)
)

val Typography = Typography(
	caption = TextStyle(
		fontFamily = CoreSans,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp
	),

	h3 = TextStyle(
		fontFamily = CoreSans,
		fontWeight = FontWeight.Bold,
		fontSize = 22.sp
	),

	h4 = TextStyle(
		fontFamily = CoreSans,
		fontWeight = FontWeight.Normal,
		fontSize = 20.sp
	),

	subtitle1 = TextStyle(
		fontFamily = AvenirLT,
		fontWeight = FontWeight.Medium,
		fontSize = 16.sp
	),

	subtitle2 = TextStyle(
		fontFamily = CoreSans,
		fontWeight = FontWeight.Normal,
		fontSize = 14.sp
	),

	body1 = TextStyle(
		fontFamily = CoreSans,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp
	),

	body2 = TextStyle(
		fontFamily = OutFit,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp
	),
)