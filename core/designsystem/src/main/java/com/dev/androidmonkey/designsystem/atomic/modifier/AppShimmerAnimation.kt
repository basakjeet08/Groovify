package com.dev.androidmonkey.designsystem.atomic.modifier

import android.content.res.Configuration
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.dev.androidmonkey.designsystem.GroovifyTheme
import com.dev.androidmonkey.designsystem.molecular.background.AppScreen
import com.dev.androidmonkey.designsystem.molecular.cards.AppCard

// Preview Function
@Preview("Dashed Border Light")
@Preview(
    name = "Dashed Border Dark",
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true
)
@Composable
private fun DefaultPreview() {
    AppScreen {
        AppCard {
            Box(
                modifier = Modifier
                    .appShimmerAnimation(true)
                    .height(500.dp)
                    .fillMaxWidth()
            )
        }
    }
}

/**
 * This is the Modifier which can be added to the Composable functions to add a Shimmer Effect to
 * them
 *
 * @param isVisible If this is true then the Composable function will have a Shimmer Effect or it
 * wont have any Shimmer Effect and would do nothing
 */
fun Modifier.appShimmerAnimation(isVisible: Boolean) = if (isVisible) composed {

    // Size of the Composable
    var size by remember { mutableStateOf(IntSize.Zero) }

    // Transition Key points
    val transition = rememberInfiniteTransition(label = "")

    // This is the Animation logic which creates animation points for the shimmer effect
    val startOffsetX by transition.animateFloat(
        label = "",
        initialValue = -2 * size.width.toFloat(),
        targetValue = 2 * size.width.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(
                1000
            )
        )
    )

    // This is the Background which would be the actual shimmer Effect
    background(

        // Linear Gradient with its Colors
        brush = Brush.linearGradient(
            colors = listOf(
                GroovifyTheme.colors.onSurfaceVariant.copy(alpha = GroovifyTheme.alphaValues.level3),
                GroovifyTheme.colors.onSurfaceVariant,
                GroovifyTheme.colors.onSurfaceVariant.copy(alpha = GroovifyTheme.alphaValues.level3)
            ),
            start = Offset(x = startOffsetX, y = 0f),
            end = Offset(
                x = startOffsetX + size.width.toFloat(),
                y = size.height.toFloat()
            )
        ),
    ).onGloballyPositioned { size = it.size }

} else this