package com.dev.androidmonkey.designsystem.molecular.animations

import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.ProgressIndicatorDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import com.dev.androidmonkey.designsystem.GroovifyTheme


/**
 *  @param modifier (optional) - A set of modifiers to customize the layout and behavior
 *  of the [AppDivider].
 *  @param thickness This is the thickness of the Divider Line which would be created
 *  @param color This is the Color of the App Divider Line
 */
@Composable
fun AppDivider(
    modifier: Modifier = Modifier,
    thickness: Dp = GroovifyTheme.spacing.level0,
    color: Color = GroovifyTheme.colors.primary,
) {
    Divider(
        color = color, thickness = thickness, modifier = modifier.clip(GroovifyTheme.shape.level0)
    )
}


/**[AppCircularProgressIndicator] is a custom composable function in Jetpack Compose, which provides a circular
 * progress indicator for the app.
 * @param modifier (optional) - A set of modifiers to customize the layout and behavior of the AppProgressArc.
 * @param strokeWidth (optional) - The width of the circular progress indicator stroke.
 * */
@Composable
fun AppCircularProgressIndicator(
    modifier: Modifier = Modifier,
    strokeWidth: Dp = ProgressIndicatorDefaults.CircularStrokeWidth,
) {
    CircularProgressIndicator(
        modifier = modifier, color = GroovifyTheme.colors.primary, strokeWidth = strokeWidth
    )
}