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
		fontSize = 24.sp
	),

	subtitle1 = TextStyle(
		fontFamily = AvenirLT,
		fontWeight = FontWeight.Medium,
		fontSize = 16.sp
	),

	subtitle2 = TextStyle(
		fontFamily = CoreSans,
		fontWeight = FontWeight.Bold,
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