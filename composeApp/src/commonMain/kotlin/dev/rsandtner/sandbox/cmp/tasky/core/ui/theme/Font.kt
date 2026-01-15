package dev.rsandtner.sandbox.cmp.tasky.core.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.Font
import tasky.composeapp.generated.resources.Res
import tasky.composeapp.generated.resources.inter_bold
import tasky.composeapp.generated.resources.inter_medium
import tasky.composeapp.generated.resources.inter_regular
import tasky.composeapp.generated.resources.inter_semibold

val Inter
    @Composable get() = FontFamily(
        Font(
            resource = Res.font.inter_regular,
            weight = FontWeight.Normal
        ),
        Font(
            resource = Res.font.inter_bold,
            weight = FontWeight.Bold
        ),
        Font(
            resource = Res.font.inter_semibold,
            weight = FontWeight.SemiBold
        ),
        Font(
            resource = Res.font.inter_medium,
            weight = FontWeight.Medium
        ),
    )

val Typography.headlineXSmall: TextStyle
    @Composable get() = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp
    )

val Typography.labelXSmall: TextStyle
    @Composable get() = TextStyle(
        fontFamily = Inter,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = 12.sp
    )

val Typography
    @Composable get() = Typography(
        headlineLarge = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Bold,
            fontSize = 28.sp,
            lineHeight = 30.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 24.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),

        bodyMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        bodySmall = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),

        labelMedium = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        labelSmall = TextStyle(
            fontFamily = Inter,
            fontWeight = FontWeight.SemiBold,
            fontSize = 14.sp,
            lineHeight = 20.sp
        ),
    )
