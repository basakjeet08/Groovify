package com.dev.androidmonkey.designsystem.molecular.texts

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.dev.androidmonkey.designsystem.GroovifyTheme
import com.dev.androidmonkey.designsystem.atomic.AppCustomTypography


/**
 * [CaptionTexts] is a utility class in a Compose-based Android application that provides a set of
 * Composable functions for displaying text with different predefined styles. These Composable
 * functions can be used to display text of mainly type Body Texts.
 *
 * Check [AppCustomTypography] for getting the current typography values
 *
 * @see [BodyTexts]
 * @see [CaptionTexts]
 * @see [HeadingTexts]
 * @see [LargeTexts]
 * @see [TitleTexts]
 */
object CaptionTexts {


    /** List of all available methods inside [CaptionTexts] -> [Level1] , [Level2] , [Level3] and
     * [Level4]
     *
     * @param modifier the [Modifier] to be applied to this layout node
     * @param text the text to be displayed
     * @param color [Color] to apply to the text.
     * @param textAlign the alignment of the text within the lines of the paragraph.
     * @param maxLines This denotes the maximum lines this text composable can have
     * @param overflow This is the way the text will be shown when it overflows
     */
    @Composable
    fun Level1(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = GroovifyTheme.colors.onSurface,
        textAlign: TextAlign? = null,
        maxLines: Int = Int.MAX_VALUE,
        overflow: TextOverflow = TextOverflow.Ellipsis
    ) {
        Text(
            text = text,
            style = GroovifyTheme.customTypography.caption.level1,
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            overflow = overflow
        )
    }

    @Composable
    fun Level2(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = GroovifyTheme.colors.onSurface,
        textAlign: TextAlign? = null,
        maxLines: Int = Int.MAX_VALUE,
        overflow: TextOverflow = TextOverflow.Ellipsis
    ) {
        Text(
            text = text,
            style = GroovifyTheme.customTypography.caption.level2,
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            overflow = overflow
        )
    }

    @Composable
    fun Level3(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = GroovifyTheme.colors.onSurface,
        textAlign: TextAlign? = null,
        maxLines: Int = Int.MAX_VALUE,
        overflow: TextOverflow = TextOverflow.Ellipsis
    ) {
        Text(
            text = text,
            style = GroovifyTheme.customTypography.caption.level3,
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            overflow = overflow
        )
    }

    @Composable
    fun Level4(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = GroovifyTheme.colors.onSurface,
        textAlign: TextAlign? = null,
        maxLines: Int = Int.MAX_VALUE,
        overflow: TextOverflow = TextOverflow.Ellipsis
    ) {
        Text(
            text = text,
            style = GroovifyTheme.customTypography.caption.level4,
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            overflow = overflow
        )
    }

    @Composable
    fun Level5(
        text: String,
        modifier: Modifier = Modifier,
        color: Color = GroovifyTheme.colors.onSurface,
        textAlign: TextAlign? = null,
        maxLines: Int = Int.MAX_VALUE,
        overflow: TextOverflow = TextOverflow.Ellipsis
    ) {
        Text(
            text = text,
            style = GroovifyTheme.customTypography.caption.level5,
            modifier = modifier,
            color = color,
            textAlign = textAlign,
            maxLines = maxLines,
            overflow = overflow
        )
    }
}

// Preview Function
@Preview("Caption Texts Light")
@Preview(
    name = "Caption Texts Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    GroovifyTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                CaptionTexts.Level1(text = "Level 1 Texts")
                CaptionTexts.Level2(text = "Level 2 Texts")
                CaptionTexts.Level3(text = "Level 3 Texts")
                CaptionTexts.Level4(text = "Level 4 Texts")
                CaptionTexts.Level5(text = "Level 5 Texts")
            }
        }
    }
}
