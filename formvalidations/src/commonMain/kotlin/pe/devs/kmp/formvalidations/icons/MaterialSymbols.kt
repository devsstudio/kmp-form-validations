package pe.devs.kmp.formvalidations.icons

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

class MaterialSymbols {

    class Normal {
        companion object {

            @Composable
            fun rememberVisibility(): ImageVector {

                return remember {
                    ImageVector.Builder(
                        name = "visibility",
                        defaultWidth = 40.0.dp,
                        defaultHeight = 40.0.dp,
                        viewportWidth = 40.0f,
                        viewportHeight = 40.0f
                    ).apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1.0f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Miter,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero
                        ) {
                            moveTo(20f, 26.208f)
                            quadToRelative(2.958f, 0f, 5f, -2.041f)
                            quadToRelative(2.042f, -2.042f, 2.042f, -5f)
                            quadToRelative(0f, -2.959f, -2.042f, -5f)
                            quadToRelative(-2.042f, -2.042f, -5f, -2.042f)
                            reflectiveQuadToRelative(-5f, 2.042f)
                            quadToRelative(-2.042f, 2.041f, -2.042f, 5f)
                            quadToRelative(0f, 2.958f, 2.042f, 5f)
                            quadToRelative(2.042f, 2.041f, 5f, 2.041f)
                            close()
                            moveToRelative(0f, -2.5f)
                            quadToRelative(-1.917f, 0f, -3.229f, -1.312f)
                            quadToRelative(-1.313f, -1.313f, -1.313f, -3.229f)
                            quadToRelative(0f, -1.917f, 1.313f, -3.229f)
                            quadToRelative(1.312f, -1.313f, 3.229f, -1.313f)
                            reflectiveQuadToRelative(3.229f, 1.313f)
                            quadToRelative(1.313f, 1.312f, 1.313f, 3.229f)
                            quadToRelative(0f, 1.916f, -1.313f, 3.229f)
                            quadToRelative(-1.312f, 1.312f, -3.229f, 1.312f)
                            close()
                            moveToRelative(0f, 7.75f)
                            quadToRelative(-5.667f, 0f, -10.312f, -3.041f)
                            quadToRelative(-4.646f, -3.042f, -7.146f, -8.042f)
                            quadToRelative(-0.125f, -0.25f, -0.188f, -0.563f)
                            quadToRelative(-0.062f, -0.312f, -0.062f, -0.645f)
                            quadToRelative(0f, -0.334f, 0.062f, -0.646f)
                            quadToRelative(0.063f, -0.313f, 0.188f, -0.563f)
                            quadToRelative(2.5f, -5f, 7.146f, -8.041f)
                            quadTo(14.333f, 6.875f, 20f, 6.875f)
                            reflectiveQuadToRelative(10.312f, 3.042f)
                            quadToRelative(4.646f, 3.041f, 7.146f, 8.041f)
                            quadToRelative(0.125f, 0.25f, 0.209f, 0.563f)
                            quadToRelative(0.083f, 0.312f, 0.083f, 0.646f)
                            quadToRelative(0f, 0.333f, -0.083f, 0.645f)
                            quadToRelative(-0.084f, 0.313f, -0.209f, 0.563f)
                            quadToRelative(-2.5f, 5f, -7.146f, 8.042f)
                            quadTo(25.667f, 31.458f, 20f, 31.458f)
                            close()
                            moveToRelative(0f, -12.291f)
                            close()
                            moveToRelative(0f, 9.625f)
                            quadToRelative(4.875f, 0f, 8.979f, -2.604f)
                            quadToRelative(4.104f, -2.605f, 6.229f, -7.021f)
                            quadTo(33.083f, 14.75f, 29f, 12.146f)
                            reflectiveQuadToRelative(-9f, -2.604f)
                            quadToRelative(-4.875f, 0f, -8.979f, 2.604f)
                            quadToRelative(-4.104f, 2.604f, -6.271f, 7.021f)
                            quadToRelative(2.167f, 4.416f, 6.25f, 7.021f)
                            quadToRelative(4.083f, 2.604f, 9f, 2.604f)
                            close()
                        }
                    }.build()
                }
            }

            @Composable
            fun rememberVisibilityOff(): ImageVector {
                return remember {
                    ImageVector.Builder(
                        name = "visibility_off",
                        defaultWidth = 40.0.dp,
                        defaultHeight = 40.0.dp,
                        viewportWidth = 40.0f,
                        viewportHeight = 40.0f
                    ).apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1.0f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Miter,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero
                        ) {
                            moveTo(26.25f, 22.417f)
                            lineTo(24.333f, 20.5f)
                            quadToRelative(0.875f, -2.75f, -1.145f, -4.604f)
                            quadToRelative(-2.021f, -1.854f, -4.521f, -1.063f)
                            lineToRelative(-1.917f, -1.916f)
                            quadToRelative(0.708f, -0.417f, 1.542f, -0.605f)
                            quadToRelative(0.833f, -0.187f, 1.708f, -0.187f)
                            quadToRelative(2.958f, 0f, 5f, 2.042f)
                            quadToRelative(2.042f, 2.041f, 2.042f, 5f)
                            quadToRelative(0f, 0.875f, -0.209f, 1.729f)
                            quadToRelative(-0.208f, 0.854f, -0.583f, 1.521f)
                            close()
                            moveToRelative(5.25f, 5.25f)
                            lineToRelative(-1.792f, -1.792f)
                            quadToRelative(1.875f, -1.375f, 3.313f, -3.104f)
                            quadToRelative(1.437f, -1.729f, 2.187f, -3.604f)
                            quadToRelative(-2.041f, -4.459f, -6.083f, -7.042f)
                            reflectiveQuadToRelative(-8.833f, -2.583f)
                            quadToRelative(-1.542f, 0f, -3.209f, 0.271f)
                            quadToRelative(-1.666f, 0.27f, -2.708f, 0.729f)
                            lineToRelative(-2.042f, -2.084f)
                            quadToRelative(1.5f, -0.666f, 3.625f, -1.125f)
                            quadToRelative(2.125f, -0.458f, 4.167f, -0.458f)
                            quadToRelative(5.625f, 0f, 10.271f, 3.021f)
                            quadToRelative(4.646f, 3.021f, 7.104f, 8.062f)
                            quadToRelative(0.125f, 0.25f, 0.188f, 0.563f)
                            quadToRelative(0.062f, 0.312f, 0.062f, 0.646f)
                            quadToRelative(0f, 0.333f, -0.062f, 0.666f)
                            quadToRelative(-0.063f, 0.334f, -0.188f, 0.542f)
                            quadToRelative(-1.042f, 2.208f, -2.562f, 4.021f)
                            quadToRelative(-1.521f, 1.812f, -3.438f, 3.271f)
                            close()
                            moveToRelative(1.083f, 8.458f)
                            lineToRelative(-5.916f, -5.833f)
                            quadToRelative(-1.417f, 0.541f, -3.146f, 0.854f)
                            quadToRelative(-1.729f, 0.312f, -3.521f, 0.312f)
                            quadToRelative(-5.708f, 0f, -10.375f, -3.02f)
                            quadToRelative(-4.667f, -3.021f, -7.125f, -8.063f)
                            quadToRelative(-0.125f, -0.292f, -0.167f, -0.583f)
                            quadToRelative(-0.041f, -0.292f, -0.041f, -0.625f)
                            quadToRelative(0f, -0.334f, 0.062f, -0.667f)
                            quadToRelative(0.063f, -0.333f, 0.146f, -0.583f)
                            quadToRelative(0.917f, -1.792f, 2.188f, -3.479f)
                            quadToRelative(1.27f, -1.688f, 2.937f, -3.146f)
                            lineTo(3.583f, 7.167f)
                            quadToRelative(-0.416f, -0.375f, -0.416f, -0.917f)
                            reflectiveQuadToRelative(0.416f, -0.917f)
                            quadToRelative(0.375f, -0.375f, 0.917f, -0.375f)
                            reflectiveQuadToRelative(0.958f, 0.375f)
                            lineToRelative(29f, 29f)
                            quadToRelative(0.334f, 0.375f, 0.334f, 0.875f)
                            reflectiveQuadToRelative(-0.375f, 0.917f)
                            quadToRelative(-0.375f, 0.417f, -0.917f, 0.417f)
                            reflectiveQuadToRelative(-0.917f, -0.417f)
                            close()
                            moveToRelative(-23.125f, -23f)
                            quadToRelative(-1.416f, 1.083f, -2.729f, 2.771f)
                            quadToRelative(-1.312f, 1.687f, -1.979f, 3.271f)
                            quadToRelative(2.083f, 4.458f, 6.188f, 7.041f)
                            quadToRelative(4.104f, 2.584f, 9.27f, 2.584f)
                            quadToRelative(1.25f, 0f, 2.459f, -0.146f)
                            quadToRelative(1.208f, -0.146f, 1.875f, -0.438f)
                            lineToRelative(-2.334f, -2.333f)
                            quadToRelative(-0.458f, 0.167f, -1.062f, 0.25f)
                            quadToRelative(-0.604f, 0.083f, -1.146f, 0.083f)
                            quadToRelative(-2.917f, 0f, -4.979f, -2.041f)
                            quadToRelative(-2.063f, -2.042f, -2.063f, -5f)
                            quadToRelative(0f, -0.584f, 0.084f, -1.146f)
                            quadToRelative(0.083f, -0.563f, 0.25f, -1.063f)
                            close()
                            moveToRelative(12.625f, 5.333f)
                            close()
                            moveTo(17.042f, 21f)
                            close()
                        }
                    }.build()
                }
            }

            @Composable
            fun rememberPerson(): ImageVector {
                return remember {
                    ImageVector.Builder(
                        name = "person",
                        defaultWidth = 40.0.dp,
                        defaultHeight = 40.0.dp,
                        viewportWidth = 40.0f,
                        viewportHeight = 40.0f
                    ).apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1.0f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Miter,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero
                        ) {
                            moveTo(20f, 20f)
                            quadToRelative(-2.708f, 0f, -4.479f, -1.771f)
                            reflectiveQuadTo(13.75f, 13.75f)
                            quadToRelative(0f, -2.708f, 1.771f, -4.479f)
                            reflectiveQuadTo(20f, 7.5f)
                            quadToRelative(2.708f, 0f, 4.479f, 1.771f)
                            reflectiveQuadToRelative(1.771f, 4.479f)
                            quadToRelative(0f, 2.708f, -1.771f, 4.479f)
                            reflectiveQuadTo(20f, 20f)
                            close()
                            moveToRelative(10.458f, 12.958f)
                            horizontalLineTo(9.542f)
                            quadToRelative(-1.084f, 0f, -1.855f, -0.77f)
                            quadToRelative(-0.77f, -0.771f, -0.77f, -1.855f)
                            verticalLineToRelative(-1.375f)
                            quadToRelative(0f, -1.5f, 0.75f, -2.604f)
                            reflectiveQuadToRelative(1.958f, -1.687f)
                            quadToRelative(2.708f, -1.25f, 5.25f, -1.875f)
                            reflectiveQuadTo(20f, 22.167f)
                            quadToRelative(2.583f, 0f, 5.104f, 0.645f)
                            quadToRelative(2.521f, 0.646f, 5.229f, 1.855f)
                            quadToRelative(1.25f, 0.583f, 2f, 1.687f)
                            reflectiveQuadToRelative(0.75f, 2.604f)
                            verticalLineToRelative(1.375f)
                            quadToRelative(0f, 1.084f, -0.771f, 1.855f)
                            quadToRelative(-0.77f, 0.77f, -1.854f, 0.77f)
                            close()
                            moveTo(9.542f, 30.333f)
                            horizontalLineToRelative(20.916f)
                            verticalLineToRelative(-1.375f)
                            quadToRelative(0f, -0.583f, -0.354f, -1.125f)
                            quadToRelative(-0.354f, -0.541f, -0.854f, -0.791f)
                            quadToRelative(-2.542f, -1.209f, -4.729f, -1.709f)
                            quadToRelative(-2.188f, -0.5f, -4.521f, -0.5f)
                            quadToRelative(-2.333f, 0f, -4.542f, 0.5f)
                            quadToRelative(-2.208f, 0.5f, -4.708f, 1.709f)
                            quadToRelative(-0.542f, 0.25f, -0.875f, 0.791f)
                            quadToRelative(-0.333f, 0.542f, -0.333f, 1.125f)
                            close()
                            moveTo(20f, 17.375f)
                            quadToRelative(1.542f, 0f, 2.583f, -1.042f)
                            quadToRelative(1.042f, -1.041f, 1.042f, -2.583f)
                            quadToRelative(0f, -1.542f, -1.042f, -2.583f)
                            quadToRelative(-1.041f, -1.042f, -2.583f, -1.042f)
                            quadToRelative(-1.542f, 0f, -2.583f, 1.042f)
                            quadToRelative(-1.042f, 1.041f, -1.042f, 2.583f)
                            quadToRelative(0f, 1.542f, 1.042f, 2.583f)
                            quadToRelative(1.041f, 1.042f, 2.583f, 1.042f)
                            close()
                            moveToRelative(0f, -3.625f)
                            close()
                            moveToRelative(0f, 16.583f)
                            close()
                        }
                    }.build()
                }
            }

            @Composable
            fun rememberLock(): ImageVector {
                return remember {
                    ImageVector.Builder(
                        name = "lock",
                        defaultWidth = 40.0.dp,
                        defaultHeight = 40.0.dp,
                        viewportWidth = 40.0f,
                        viewportHeight = 40.0f
                    ).apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1.0f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Miter,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero
                        ) {
                            moveTo(9.542f, 36.375f)
                            quadToRelative(-1.084f, 0f, -1.855f, -0.771f)
                            quadToRelative(-0.77f, -0.771f, -0.77f, -1.854f)
                            verticalLineTo(16.292f)
                            quadToRelative(0f, -1.084f, 0.77f, -1.854f)
                            quadToRelative(0.771f, -0.771f, 1.855f, -0.771f)
                            horizontalLineToRelative(2.583f)
                            verticalLineTo(9.958f)
                            quadToRelative(0f, -3.291f, 2.292f, -5.583f)
                            quadTo(16.708f, 2.083f, 20f, 2.083f)
                            quadToRelative(3.292f, 0f, 5.583f, 2.292f)
                            quadToRelative(2.292f, 2.292f, 2.292f, 5.583f)
                            verticalLineToRelative(3.709f)
                            horizontalLineToRelative(2.583f)
                            quadToRelative(1.084f, 0f, 1.854f, 0.771f)
                            quadToRelative(0.771f, 0.77f, 0.771f, 1.854f)
                            verticalLineTo(33.75f)
                            quadToRelative(0f, 1.083f, -0.771f, 1.854f)
                            quadToRelative(-0.77f, 0.771f, -1.854f, 0.771f)
                            close()
                            moveToRelative(5.25f, -22.708f)
                            horizontalLineToRelative(10.416f)
                            verticalLineToRelative(-3.75f)
                            quadToRelative(0f, -2.167f, -1.5f, -3.688f)
                            quadToRelative(-1.5f, -1.521f, -3.708f, -1.521f)
                            quadToRelative(-2.167f, 0f, -3.688f, 1.521f)
                            quadToRelative(-1.52f, 1.521f, -1.52f, 3.729f)
                            close()
                            moveTo(9.542f, 33.75f)
                            horizontalLineToRelative(20.916f)
                            verticalLineTo(16.292f)
                            horizontalLineTo(9.542f)
                            verticalLineTo(33.75f)
                            close()
                            moveTo(20f, 28.208f)
                            quadToRelative(1.292f, 0f, 2.229f, -0.916f)
                            quadToRelative(0.938f, -0.917f, 0.938f, -2.209f)
                            quadToRelative(0f, -1.25f, -0.938f, -2.229f)
                            quadToRelative(-0.937f, -0.979f, -2.229f, -0.979f)
                            reflectiveQuadToRelative(-2.229f, 0.979f)
                            quadToRelative(-0.938f, 0.979f, -0.938f, 2.229f)
                            quadToRelative(0f, 1.292f, 0.938f, 2.209f)
                            quadToRelative(0.937f, 0.916f, 2.229f, 0.916f)
                            close()
                            moveToRelative(0f, -3.166f)
                            close()
                        }
                    }.build()
                }
            }

            @Composable
            fun rememberArrowDropDown(): ImageVector {
                return remember {
                    ImageVector.Builder(
                        name = "arrow_drop_down",
                        defaultWidth = 40.0.dp,
                        defaultHeight = 40.0.dp,
                        viewportWidth = 40.0f,
                        viewportHeight = 40.0f
                    ).apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1.0f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Miter,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero
                        ) {
                            moveTo(19.083f, 23.958f)
                            lineTo(14.125f, 19f)
                            quadToRelative(-0.625f, -0.625f, -0.271f, -1.417f)
                            quadToRelative(0.354f, -0.791f, 1.188f, -0.791f)
                            horizontalLineToRelative(9.916f)
                            quadToRelative(0.834f, 0f, 1.188f, 0.791f)
                            quadToRelative(0.354f, 0.792f, -0.271f, 1.417f)
                            lineToRelative(-4.958f, 4.958f)
                            quadToRelative(-0.209f, 0.209f, -0.438f, 0.313f)
                            quadToRelative(-0.229f, 0.104f, -0.479f, 0.104f)
                            quadToRelative(-0.25f, 0f, -0.479f, -0.104f)
                            quadToRelative(-0.229f, -0.104f, -0.438f, -0.313f)
                            close()
                        }
                    }.build()
                }
            }

            @Composable
            fun rememberArrowDropUp(): ImageVector {
                return remember {
                    ImageVector.Builder(
                        name = "arrow_drop_up",
                        defaultWidth = 40.0.dp,
                        defaultHeight = 40.0.dp,
                        viewportWidth = 40.0f,
                        viewportHeight = 40.0f
                    ).apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1.0f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Miter,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero
                        ) {
                            moveTo(15.042f, 23.208f)
                            quadToRelative(-0.875f, 0f, -1.209f, -0.791f)
                            quadToRelative(-0.333f, -0.792f, 0.292f, -1.417f)
                            lineToRelative(5f, -5f)
                            quadToRelative(0.208f, -0.208f, 0.417f, -0.292f)
                            quadToRelative(0.208f, -0.083f, 0.5f, -0.083f)
                            quadToRelative(0.25f, 0f, 0.479f, 0.083f)
                            quadToRelative(0.229f, 0.084f, 0.437f, 0.292f)
                            lineToRelative(4.959f, 5f)
                            quadToRelative(0.625f, 0.625f, 0.291f, 1.417f)
                            quadToRelative(-0.333f, 0.791f, -1.208f, 0.791f)
                            close()
                        }
                    }.build()
                }
            }

            @Composable
            fun rememberError(): ImageVector {
                return remember {
                    ImageVector.Builder(
                        name = "error",
                        defaultWidth = 40.0.dp,
                        defaultHeight = 40.0.dp,
                        viewportWidth = 40.0f,
                        viewportHeight = 40.0f
                    ).apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1.0f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Miter,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero
                        ) {
                            moveTo(20.125f, 21.875f)
                            quadToRelative(0.542f, 0f, 0.917f, -0.396f)
                            reflectiveQuadToRelative(0.375f, -0.937f)
                            verticalLineToRelative(-7.667f)
                            quadToRelative(0f, -0.5f, -0.396f, -0.875f)
                            reflectiveQuadToRelative(-0.938f, -0.375f)
                            quadToRelative(-0.541f, 0f, -0.916f, 0.375f)
                            reflectiveQuadToRelative(-0.375f, 0.917f)
                            verticalLineToRelative(7.666f)
                            quadToRelative(0f, 0.542f, 0.396f, 0.917f)
                            quadToRelative(0.395f, 0.375f, 0.937f, 0.375f)
                            close()
                            moveTo(20f, 28.208f)
                            quadToRelative(0.625f, 0f, 1.021f, -0.416f)
                            quadToRelative(0.396f, -0.417f, 0.396f, -1f)
                            quadToRelative(0f, -0.625f, -0.396f, -1.021f)
                            quadToRelative(-0.396f, -0.396f, -1.021f, -0.396f)
                            quadToRelative(-0.625f, 0f, -1.021f, 0.396f)
                            quadToRelative(-0.396f, 0.396f, -0.396f, 1.021f)
                            quadToRelative(0f, 0.583f, 0.396f, 1f)
                            quadToRelative(0.396f, 0.416f, 1.021f, 0.416f)
                            close()
                            moveToRelative(0f, 8.167f)
                            quadToRelative(-3.458f, 0f, -6.458f, -1.25f)
                            reflectiveQuadToRelative(-5.209f, -3.458f)
                            quadToRelative(-2.208f, -2.209f, -3.458f, -5.209f)
                            quadToRelative(-1.25f, -3f, -1.25f, -6.458f)
                            reflectiveQuadToRelative(1.25f, -6.437f)
                            quadToRelative(1.25f, -2.98f, 3.458f, -5.188f)
                            quadToRelative(2.209f, -2.208f, 5.209f, -3.479f)
                            quadToRelative(3f, -1.271f, 6.458f, -1.271f)
                            reflectiveQuadToRelative(6.438f, 1.271f)
                            quadToRelative(2.979f, 1.271f, 5.187f, 3.479f)
                            reflectiveQuadToRelative(3.479f, 5.188f)
                            quadToRelative(1.271f, 2.979f, 1.271f, 6.437f)
                            reflectiveQuadToRelative(-1.271f, 6.458f)
                            quadToRelative(-1.271f, 3f, -3.479f, 5.209f)
                            quadToRelative(-2.208f, 2.208f, -5.187f, 3.458f)
                            quadToRelative(-2.98f, 1.25f, -6.438f, 1.25f)
                            close()
                            moveTo(20f, 20f)
                            close()
                            moveToRelative(0f, 13.75f)
                            quadToRelative(5.667f, 0f, 9.708f, -4.042f)
                            quadTo(33.75f, 25.667f, 33.75f, 20f)
                            reflectiveQuadToRelative(-4.042f, -9.708f)
                            quadTo(25.667f, 6.25f, 20f, 6.25f)
                            reflectiveQuadToRelative(-9.708f, 4.042f)
                            quadTo(6.25f, 14.333f, 6.25f, 20f)
                            reflectiveQuadToRelative(4.042f, 9.708f)
                            quadTo(14.333f, 33.75f, 20f, 33.75f)
                            close()
                        }
                    }.build()
                }
            }
        }
    }

    class Filled {
        companion object {

            @Composable
            fun rememberPerson(): ImageVector {
                return remember {
                    ImageVector.Builder(
                        name = "person",
                        defaultWidth = 40.0.dp,
                        defaultHeight = 40.0.dp,
                        viewportWidth = 40.0f,
                        viewportHeight = 40.0f
                    ).apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1.0f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Miter,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero
                        ) {
                            moveTo(20f, 20f)
                            quadToRelative(-2.708f, 0f, -4.479f, -1.771f)
                            reflectiveQuadTo(13.75f, 13.75f)
                            quadToRelative(0f, -2.708f, 1.771f, -4.479f)
                            reflectiveQuadTo(20f, 7.5f)
                            quadToRelative(2.708f, 0f, 4.479f, 1.771f)
                            reflectiveQuadToRelative(1.771f, 4.479f)
                            quadToRelative(0f, 2.708f, -1.771f, 4.479f)
                            reflectiveQuadTo(20f, 20f)
                            close()
                            moveTo(9.542f, 32.958f)
                            quadToRelative(-1.084f, 0f, -1.855f, -0.77f)
                            quadToRelative(-0.77f, -0.771f, -0.77f, -1.855f)
                            verticalLineToRelative(-1.375f)
                            quadToRelative(0f, -1.5f, 0.75f, -2.604f)
                            reflectiveQuadToRelative(1.958f, -1.687f)
                            quadToRelative(2.708f, -1.25f, 5.25f, -1.875f)
                            reflectiveQuadTo(20f, 22.167f)
                            quadToRelative(2.583f, 0f, 5.104f, 0.645f)
                            quadToRelative(2.521f, 0.646f, 5.229f, 1.855f)
                            quadToRelative(1.25f, 0.583f, 2f, 1.687f)
                            reflectiveQuadToRelative(0.75f, 2.604f)
                            verticalLineToRelative(1.375f)
                            quadToRelative(0f, 1.084f, -0.771f, 1.855f)
                            quadToRelative(-0.77f, 0.77f, -1.854f, 0.77f)
                            close()
                        }
                    }.build()
                }
            }

            @Composable
            fun rememberMail(): ImageVector {
                return remember {
                    ImageVector.Builder(
                        name = "mail",
                        defaultWidth = 40.0.dp,
                        defaultHeight = 40.0.dp,
                        viewportWidth = 40.0f,
                        viewportHeight = 40.0f
                    ).apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1.0f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Miter,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero
                        ) {
                            moveTo(6.25f, 33.083f)
                            quadToRelative(-1.083f, 0f, -1.854f, -0.791f)
                            quadToRelative(-0.771f, -0.792f, -0.771f, -1.834f)
                            verticalLineTo(9.542f)
                            quadToRelative(0f, -1.042f, 0.771f, -1.834f)
                            quadToRelative(0.771f, -0.791f, 1.854f, -0.791f)
                            horizontalLineToRelative(27.5f)
                            quadToRelative(1.083f, 0f, 1.854f, 0.791f)
                            quadToRelative(0.771f, 0.792f, 0.771f, 1.834f)
                            verticalLineToRelative(20.916f)
                            quadToRelative(0f, 1.042f, -0.771f, 1.834f)
                            quadToRelative(-0.771f, 0.791f, -1.854f, 0.791f)
                            close()
                            moveTo(20f, 20.708f)
                            quadToRelative(0.208f, 0f, 0.354f, -0.062f)
                            quadToRelative(0.146f, -0.063f, 0.354f, -0.146f)
                            lineToRelative(12.584f, -8.125f)
                            quadToRelative(0.208f, -0.167f, 0.333f, -0.375f)
                            quadToRelative(0.125f, -0.208f, 0.125f, -0.5f)
                            quadToRelative(0f, -0.583f, -0.521f, -0.937f)
                            quadToRelative(-0.521f, -0.355f, -1.062f, 0.02f)
                            lineTo(20f, 18.292f)
                            lineTo(7.875f, 10.583f)
                            quadToRelative(-0.542f, -0.333f, -1.083f, -0.041f)
                            quadToRelative(-0.542f, 0.291f, -0.542f, 0.916f)
                            quadToRelative(0f, 0.292f, 0.146f, 0.521f)
                            quadToRelative(0.146f, 0.229f, 0.312f, 0.396f)
                            lineTo(19.333f, 20.5f)
                            quadToRelative(0.167f, 0.083f, 0.313f, 0.146f)
                            quadToRelative(0.146f, 0.062f, 0.354f, 0.062f)
                            close()
                        }
                    }.build()
                }
            }

            @Composable
            fun rememberSmartphone(): ImageVector {
                return remember {
                    ImageVector.Builder(
                        name = "smartphone",
                        defaultWidth = 40.0.dp,
                        defaultHeight = 40.0.dp,
                        viewportWidth = 40.0f,
                        viewportHeight = 40.0f
                    ).apply {
                        path(
                            fill = SolidColor(Color.Black),
                            fillAlpha = 1f,
                            stroke = null,
                            strokeAlpha = 1f,
                            strokeLineWidth = 1.0f,
                            strokeLineCap = StrokeCap.Butt,
                            strokeLineJoin = StrokeJoin.Miter,
                            strokeLineMiter = 1f,
                            pathFillType = PathFillType.NonZero
                        ) {
                            moveTo(11.208f, 31.333f)
                            horizontalLineToRelative(17.584f)
                            verticalLineTo(8.667f)
                            horizontalLineTo(11.208f)
                            close()
                            moveToRelative(0f, 6.709f)
                            quadToRelative(-1.083f, 0f, -1.875f, -0.771f)
                            quadToRelative(-0.791f, -0.771f, -0.791f, -1.854f)
                            verticalLineTo(4.583f)
                            quadToRelative(0f, -1.083f, 0.791f, -1.854f)
                            quadToRelative(0.792f, -0.771f, 1.875f, -0.771f)
                            horizontalLineToRelative(17.584f)
                            quadToRelative(1.083f, 0f, 1.875f, 0.771f)
                            quadToRelative(0.791f, 0.771f, 0.791f, 1.854f)
                            verticalLineToRelative(30.834f)
                            quadToRelative(0f, 1.083f, -0.791f, 1.854f)
                            quadToRelative(-0.792f, 0.771f, -1.875f, 0.771f)
                            close()
                        }
                    }.build()
                }
            }

        }
    }


}
