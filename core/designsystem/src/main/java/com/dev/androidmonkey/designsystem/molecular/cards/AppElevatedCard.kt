package com.dev.androidmonkey.designsystem.molecular.cards

import android.content.res.Configuration
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import com.dev.androidmonkey.designsystem.GroovifyTheme
import com.dev.androidmonkey.designsystem.molecular.texts.CaptionTexts


// Preview Function
@Preview("Light Button")
@Preview(
    name = "Dark Button",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview1() {
    GroovifyTheme {
        Surface {
            AppElevatedCard {
                CaptionTexts.Level1(text = "Card Testing")
            }
        }
    }
}


/**
 * [AppElevatedCard] is default clickable Elevated card for the app.This Card handles click events,
 * calling its [onClick] lambda.
 *
 * @param modifier the [Modifier] to be applied to this card
 * @param enabled This determines if the Card is enabled or not
 * @param colors [CardColors] that will be used to resolve the color(s) used for this card.
 * @param shape This function is used to provide a custom shape to the Card
 * @param elevation [CardElevation] used to resolve the elevation for this card.
 * @param onClick called when this card is clicked
 * @param content components inside the card
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppElevatedCard(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    colors: CardColors = CardDefaults.elevatedCardColors(),
    shape: Shape = GroovifyTheme.shape.level1,
    elevation: CardElevation = CardDefaults.elevatedCardElevation(
        defaultElevation = GroovifyTheme.elevation.level1,
        pressedElevation = GroovifyTheme.elevation.level1,
        focusedElevation = GroovifyTheme.elevation.level1,
        hoveredElevation = GroovifyTheme.elevation.level2,
        draggedElevation = GroovifyTheme.elevation.level4,
        disabledElevation = GroovifyTheme.elevation.level1
    ),
    onClick: (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit
) {

    if (onClick != null)
        ElevatedCard(
            modifier = modifier,
            enabled = enabled,
            colors = colors,
            shape = shape,
            elevation = elevation,
            onClick = onClick,
            content = content
        )
    else
        ElevatedCard(
            modifier = modifier,
            shape = shape,
            colors = colors,
            elevation = elevation,
            content = content
        )
}