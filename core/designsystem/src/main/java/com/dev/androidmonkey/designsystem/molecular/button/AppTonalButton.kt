package com.dev.androidmonkey.designsystem.molecular.button

import android.content.res.Configuration
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ButtonElevation
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
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
            Column {
                AppTonalButton(
                    textToShow = "Enabled Button",
                    leadingIcon = Icons.Default.Person
                ) {}

                AppTonalButton(
                    textToShow = "Disabled Button",
                    enabled = false,
                    leadingIcon = Icons.Default.Person
                ) {}
            }
        }
    }
}


/**
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between
 * default [Button]s (filled) and [OutlinedButton]s. They can be used in contexts where
 * lower-priority button requires slightly more emphasis than an outline would give, such as "Next"
 * in an onboarding flow. Tonal buttons use the secondary color mapping.
 *
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param shape defines the shape of this button's container, border (when [border] is not null),
 * and shadow (when using [elevation])
 * @param colors [ButtonColors] that will be used to resolve the colors for this button in different
 * states. See [ButtonDefaults.filledTonalButtonColors].
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Additionally, when the container
 * color is [ColorScheme.surface], this controls the amount of primary color applied as an overlay.
 * @param border the border to draw around the container of this button
 * @param contentPadding the spacing values to apply internally between the container and the
 * content
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param onClick called when this button is clicked
 * @param content This contains the composable function which would come inside the Button
 */
@Composable
fun AppTonalButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = GroovifyTheme.shape.level1,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = GroovifyTheme.colors.secondary,
        contentColor = GroovifyTheme.colors.onSecondary,
        disabledContainerColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level1),
        disabledContentColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
    ),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(
        defaultElevation = GroovifyTheme.elevation.level0,
        pressedElevation = GroovifyTheme.elevation.level0,
        focusedElevation = GroovifyTheme.elevation.level0,
        hoveredElevation = GroovifyTheme.elevation.level1
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(
        start = GroovifyTheme.spacing.level3,
        top = GroovifyTheme.spacing.level1,
        end = GroovifyTheme.spacing.level3,
        bottom = GroovifyTheme.spacing.level1
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    content: @Composable (RowScope.() -> Unit)
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        elevation = elevation,
        shape = shape,
        border = border,
        interactionSource = interactionSource,
        content = content
    )
}


/**
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between
 * default [Button]s (filled) and [OutlinedButton]s. They can be used in contexts where
 * lower-priority button requires slightly more emphasis than an outline would give, such as "Next"
 * in an onboarding flow. Tonal buttons use the secondary color mapping.
 *
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param textToShow This is the text to be shown in the Button
 * @param shape defines the shape of this button's container, border (when [border] is not null),
 * and shadow (when using [elevation])
 * @param colors [ButtonColors] that will be used to resolve the colors for this button in different
 * states. See [ButtonDefaults.filledTonalButtonColors].
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Additionally, when the container
 * color is [ColorScheme.surface], this controls the amount of primary color applied as an overlay.
 * @param border the border to draw around the container of this button
 * @param contentPadding the spacing values to apply internally between the container and the
 * content
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param onClick called when this button is clicked
 */
@Composable
fun AppTonalButton(
    textToShow: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    shape: Shape = GroovifyTheme.shape.level1,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = GroovifyTheme.colors.secondary,
        contentColor = GroovifyTheme.colors.onSecondary,
        disabledContainerColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level1),
        disabledContentColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
    ),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(
        defaultElevation = GroovifyTheme.elevation.level0,
        pressedElevation = GroovifyTheme.elevation.level0,
        focusedElevation = GroovifyTheme.elevation.level0,
        hoveredElevation = GroovifyTheme.elevation.level1
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(
        start = GroovifyTheme.spacing.level3,
        top = GroovifyTheme.spacing.level1,
        end = GroovifyTheme.spacing.level3,
        bottom = GroovifyTheme.spacing.level1
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {
    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        elevation = elevation,
        shape = shape,
        border = border,
        interactionSource = interactionSource
    ) {
        CaptionTexts.Level1(
            text = textToShow,
            color = if (enabled)
                GroovifyTheme.colors.onSecondary
            else
                GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
        )
    }
}


/**
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between
 * default [Button]s (filled) and [OutlinedButton]s. They can be used in contexts where
 * lower-priority button requires slightly more emphasis than an outline would give, such as "Next"
 * in an onboarding flow. Tonal buttons use the secondary color mapping.
 *
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param textToShow This is the text to be shown in the Button
 * @param leadingIcon This is the leading Icon of the Button which is optional
 * @param leadingIconDes This is the description of the Icon which is provided and it is also optional
 * @param iconTint This is the tint color of the Icon given
 * @param shape defines the shape of this button's container, border (when [border] is not null),
 * and shadow (when using [elevation])
 * @param colors [ButtonColors] that will be used to resolve the colors for this button in different
 * states. See [ButtonDefaults.filledTonalButtonColors].
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Additionally, when the container
 * color is [ColorScheme.surface], this controls the amount of primary color applied as an overlay.
 * @param border the border to draw around the container of this button
 * @param contentPadding the spacing values to apply internally between the container and the
 * content
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param onClick called when this button is clicked
 */
@Composable
fun AppTonalButton(
    textToShow: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
    leadingIconDes: String? = null,
    iconTint: Color = GroovifyTheme.colors.onSecondary,
    shape: Shape = GroovifyTheme.shape.level1,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = GroovifyTheme.colors.secondary,
        contentColor = GroovifyTheme.colors.onSecondary,
        disabledContainerColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level1),
        disabledContentColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
    ),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(
        defaultElevation = GroovifyTheme.elevation.level0,
        pressedElevation = GroovifyTheme.elevation.level0,
        focusedElevation = GroovifyTheme.elevation.level0,
        hoveredElevation = GroovifyTheme.elevation.level1
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(
        start = GroovifyTheme.spacing.level3,
        top = GroovifyTheme.spacing.level1,
        end = GroovifyTheme.spacing.level3,
        bottom = GroovifyTheme.spacing.level1
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {

    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        elevation = elevation,
        shape = shape,
        border = border,
        interactionSource = interactionSource
    ) {

        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = leadingIconDes,
                modifier = Modifier.padding(end = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }

        CaptionTexts.Level1(
            text = textToShow,
            color = if (enabled)
                GroovifyTheme.colors.onSecondary
            else
                GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
        )
    }
}


/**
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between
 * default [Button]s (filled) and [OutlinedButton]s. They can be used in contexts where
 * lower-priority button requires slightly more emphasis than an outline would give, such as "Next"
 * in an onboarding flow. Tonal buttons use the secondary color mapping.
 *
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param textToShow This is the text to be shown in the Button
 * @param leadingIcon This is the leading Icon of the Button which is optional
 * @param leadingIconDes This is the description of the Icon which is provided and it is also optional
 * @param iconTint This is the tint color of the Icon given
 * @param shape defines the shape of this button's container, border (when [border] is not null),
 * and shadow (when using [elevation])
 * @param colors [ButtonColors] that will be used to resolve the colors for this button in different
 * states. See [ButtonDefaults.filledTonalButtonColors].
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Additionally, when the container
 * color is [ColorScheme.surface], this controls the amount of primary color applied as an overlay.
 * @param border the border to draw around the container of this button
 * @param contentPadding the spacing values to apply internally between the container and the
 * content
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param onClick called when this button is clicked
 */
@Composable
fun AppTonalButton(
    textToShow: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: Painter? = null,
    leadingIconDes: String? = null,
    iconTint: Color = GroovifyTheme.colors.onSecondary,
    shape: Shape = GroovifyTheme.shape.level1,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = GroovifyTheme.colors.secondary,
        contentColor = GroovifyTheme.colors.onSecondary,
        disabledContainerColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level1),
        disabledContentColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
    ),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(
        defaultElevation = GroovifyTheme.elevation.level0,
        pressedElevation = GroovifyTheme.elevation.level0,
        focusedElevation = GroovifyTheme.elevation.level0,
        hoveredElevation = GroovifyTheme.elevation.level1
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(
        start = GroovifyTheme.spacing.level3,
        top = GroovifyTheme.spacing.level1,
        end = GroovifyTheme.spacing.level3,
        bottom = GroovifyTheme.spacing.level1
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {

    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        elevation = elevation,
        shape = shape,
        border = border,
        interactionSource = interactionSource
    ) {

        if (leadingIcon != null) {
            Icon(
                painter = leadingIcon,
                contentDescription = leadingIconDes,
                modifier = Modifier.padding(end = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }

        CaptionTexts.Level1(
            text = textToShow,
            color = if (enabled)
                GroovifyTheme.colors.onSecondary
            else
                GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
        )
    }
}


/**
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between
 * default [Button]s (filled) and [OutlinedButton]s. They can be used in contexts where
 * lower-priority button requires slightly more emphasis than an outline would give, such as "Next"
 * in an onboarding flow. Tonal buttons use the secondary color mapping.
 *
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param textToShow This is the text to be shown in the Button
 * @param trailingIcon This is the trailing Icon of the Button which is optional
 * @param trailingIconDes This is the description of the Icon which is provided and it is also optional
 * @param iconTint This is the tint color of the Icon given
 * @param shape defines the shape of this button's container, border (when [border] is not null),
 * and shadow (when using [elevation])
 * @param colors [ButtonColors] that will be used to resolve the colors for this button in different
 * states. See [ButtonDefaults.filledTonalButtonColors].
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Additionally, when the container
 * color is [ColorScheme.surface], this controls the amount of primary color applied as an overlay.
 * @param border the border to draw around the container of this button
 * @param contentPadding the spacing values to apply internally between the container and the
 * content
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param onClick called when this button is clicked
 */
@Composable
fun AppTonalButton(
    textToShow: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    trailingIconDes: String? = null,
    trailingIcon: Painter? = null,
    iconTint: Color = GroovifyTheme.colors.onSecondary,
    shape: Shape = GroovifyTheme.shape.level1,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = GroovifyTheme.colors.secondary,
        contentColor = GroovifyTheme.colors.onSecondary,
        disabledContainerColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level1),
        disabledContentColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
    ),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(
        defaultElevation = GroovifyTheme.elevation.level0,
        pressedElevation = GroovifyTheme.elevation.level0,
        focusedElevation = GroovifyTheme.elevation.level0,
        hoveredElevation = GroovifyTheme.elevation.level1
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(
        start = GroovifyTheme.spacing.level3,
        top = GroovifyTheme.spacing.level1,
        end = GroovifyTheme.spacing.level3,
        bottom = GroovifyTheme.spacing.level1
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {

    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        elevation = elevation,
        shape = shape,
        border = border,
        interactionSource = interactionSource
    ) {

        CaptionTexts.Level1(
            text = textToShow,
            color = if (enabled)
                GroovifyTheme.colors.onSecondary
            else
                GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
        )

        if (trailingIcon != null) {
            Icon(
                painter = trailingIcon,
                contentDescription = trailingIconDes,
                modifier = Modifier.padding(start = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }
    }
}


/**
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between
 * default [Button]s (filled) and [OutlinedButton]s. They can be used in contexts where
 * lower-priority button requires slightly more emphasis than an outline would give, such as "Next"
 * in an onboarding flow. Tonal buttons use the secondary color mapping.
 *
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param textToShow This is the text to be shown in the Button
 * @param trailingIcon This is the trailing Icon of the Button which is optional
 * @param trailingIconDes This is the description of the Icon which is provided and it is also optional
 * @param iconTint This is the tint color of the Icon given
 * @param shape defines the shape of this button's container, border (when [border] is not null),
 * and shadow (when using [elevation])
 * @param colors [ButtonColors] that will be used to resolve the colors for this button in different
 * states. See [ButtonDefaults.filledTonalButtonColors].
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Additionally, when the container
 * color is [ColorScheme.surface], this controls the amount of primary color applied as an overlay.
 * @param border the border to draw around the container of this button
 * @param contentPadding the spacing values to apply internally between the container and the
 * content
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param onClick called when this button is clicked
 */
@Composable
fun AppTonalButton(
    textToShow: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    trailingIconDes: String? = null,
    trailingIcon: ImageVector? = null,
    iconTint: Color = GroovifyTheme.colors.onSecondary,
    shape: Shape = GroovifyTheme.shape.level1,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = GroovifyTheme.colors.secondary,
        contentColor = GroovifyTheme.colors.onSecondary,
        disabledContainerColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level1),
        disabledContentColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
    ),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(
        defaultElevation = GroovifyTheme.elevation.level0,
        pressedElevation = GroovifyTheme.elevation.level0,
        focusedElevation = GroovifyTheme.elevation.level0,
        hoveredElevation = GroovifyTheme.elevation.level1
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(
        start = GroovifyTheme.spacing.level3,
        top = GroovifyTheme.spacing.level1,
        end = GroovifyTheme.spacing.level3,
        bottom = GroovifyTheme.spacing.level1
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {

    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        elevation = elevation,
        shape = shape,
        border = border,
        interactionSource = interactionSource
    ) {

        CaptionTexts.Level1(
            text = textToShow,
            color = if (enabled)
                GroovifyTheme.colors.onSecondary
            else
                GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
        )

        if (trailingIcon != null) {
            Icon(
                imageVector = trailingIcon,
                contentDescription = trailingIconDes,
                modifier = Modifier.padding(start = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }
    }
}


/**
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between
 * default [Button]s (filled) and [OutlinedButton]s. They can be used in contexts where
 * lower-priority button requires slightly more emphasis than an outline would give, such as "Next"
 * in an onboarding flow. Tonal buttons use the secondary color mapping.
 *
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param textToShow This is the text to be shown in the Button
 * @param leadingIcon This is the leading Icon of the Button which is optional
 * @param leadingIconDes This is the description of the Icon which is provided and it is also optional
 * @param trailingIcon This is the trailing Icon of the Button which is optional
 * @param trailingIconDes This is the description of the Icon which is provided and it is also optional
 * @param iconTint This is the tint color of the Icon given
 * @param shape defines the shape of this button's container, border (when [border] is not null),
 * and shadow (when using [elevation])
 * @param colors [ButtonColors] that will be used to resolve the colors for this button in different
 * states. See [ButtonDefaults.filledTonalButtonColors].
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Additionally, when the container
 * color is [ColorScheme.surface], this controls the amount of primary color applied as an overlay.
 * @param border the border to draw around the container of this button
 * @param contentPadding the spacing values to apply internally between the container and the
 * content
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param onClick called when this button is clicked
 */
@Composable
fun AppTonalButton(
    textToShow: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
    leadingIconDes: String? = null,
    trailingIcon: ImageVector? = null,
    trailingIconDes: String? = null,
    iconTint: Color = GroovifyTheme.colors.onSecondary,
    shape: Shape = GroovifyTheme.shape.level1,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = GroovifyTheme.colors.secondary,
        contentColor = GroovifyTheme.colors.onSecondary,
        disabledContainerColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level1),
        disabledContentColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
    ),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(
        defaultElevation = GroovifyTheme.elevation.level0,
        pressedElevation = GroovifyTheme.elevation.level0,
        focusedElevation = GroovifyTheme.elevation.level0,
        hoveredElevation = GroovifyTheme.elevation.level1
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(
        start = GroovifyTheme.spacing.level3,
        top = GroovifyTheme.spacing.level1,
        end = GroovifyTheme.spacing.level3,
        bottom = GroovifyTheme.spacing.level1
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {

    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        elevation = elevation,
        shape = shape,
        border = border,
        interactionSource = interactionSource
    ) {

        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = leadingIconDes,
                modifier = Modifier.padding(end = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }

        CaptionTexts.Level1(
            text = textToShow,
            color = if (enabled)
                GroovifyTheme.colors.onSecondary
            else
                GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
        )

        if (trailingIcon != null) {
            Icon(
                imageVector = trailingIcon,
                contentDescription = trailingIconDes,
                modifier = Modifier.padding(start = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }
    }
}


/**
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between
 * default [Button]s (filled) and [OutlinedButton]s. They can be used in contexts where
 * lower-priority button requires slightly more emphasis than an outline would give, such as "Next"
 * in an onboarding flow. Tonal buttons use the secondary color mapping.
 *
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param textToShow This is the text to be shown in the Button
 * @param leadingIcon This is the leading Icon of the Button which is optional
 * @param leadingIconDes This is the description of the Icon which is provided and it is also optional
 * @param trailingIcon This is the trailing Icon of the Button which is optional
 * @param trailingIconDes This is the description of the Icon which is provided and it is also optional
 * @param iconTint This is the tint color of the Icon given
 * @param shape defines the shape of this button's container, border (when [border] is not null),
 * and shadow (when using [elevation])
 * @param colors [ButtonColors] that will be used to resolve the colors for this button in different
 * states. See [ButtonDefaults.filledTonalButtonColors].
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Additionally, when the container
 * color is [ColorScheme.surface], this controls the amount of primary color applied as an overlay.
 * @param border the border to draw around the container of this button
 * @param contentPadding the spacing values to apply internally between the container and the
 * content
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param onClick called when this button is clicked
 */
@Composable
fun AppTonalButton(
    textToShow: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: Painter? = null,
    leadingIconDes: String? = null,
    trailingIcon: Painter? = null,
    trailingIconDes: String? = null,
    iconTint: Color = GroovifyTheme.colors.onSecondary,
    shape: Shape = GroovifyTheme.shape.level1,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = GroovifyTheme.colors.secondary,
        contentColor = GroovifyTheme.colors.onSecondary,
        disabledContainerColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level1),
        disabledContentColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
    ),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(
        defaultElevation = GroovifyTheme.elevation.level0,
        pressedElevation = GroovifyTheme.elevation.level0,
        focusedElevation = GroovifyTheme.elevation.level0,
        hoveredElevation = GroovifyTheme.elevation.level1
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(
        start = GroovifyTheme.spacing.level3,
        top = GroovifyTheme.spacing.level1,
        end = GroovifyTheme.spacing.level3,
        bottom = GroovifyTheme.spacing.level1
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {

    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        elevation = elevation,
        shape = shape,
        border = border,
        interactionSource = interactionSource
    ) {

        if (leadingIcon != null) {
            Icon(
                painter = leadingIcon,
                contentDescription = leadingIconDes,
                modifier = Modifier.padding(end = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }

        CaptionTexts.Level1(
            text = textToShow,
            color = if (enabled)
                GroovifyTheme.colors.onSecondary
            else
                GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
        )

        if (trailingIcon != null) {
            Icon(
                painter = trailingIcon,
                contentDescription = trailingIconDes,
                modifier = Modifier.padding(start = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }
    }
}


/**
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between
 * default [Button]s (filled) and [OutlinedButton]s. They can be used in contexts where
 * lower-priority button requires slightly more emphasis than an outline would give, such as "Next"
 * in an onboarding flow. Tonal buttons use the secondary color mapping.
 *
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param textToShow This is the text to be shown in the Button
 * @param leadingIcon This is the leading Icon of the Button which is optional
 * @param leadingIconDes This is the description of the Icon which is provided and it is also optional
 * @param trailingIcon This is the trailing Icon of the Button which is optional
 * @param trailingIconDes This is the description of the Icon which is provided and it is also optional
 * @param iconTint This is the tint color of the Icon given
 * @param shape defines the shape of this button's container, border (when [border] is not null),
 * and shadow (when using [elevation])
 * @param colors [ButtonColors] that will be used to resolve the colors for this button in different
 * states. See [ButtonDefaults.filledTonalButtonColors].
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Additionally, when the container
 * color is [ColorScheme.surface], this controls the amount of primary color applied as an overlay.
 * @param border the border to draw around the container of this button
 * @param contentPadding the spacing values to apply internally between the container and the
 * content
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param onClick called when this button is clicked
 */
@Composable
fun AppTonalButton(
    textToShow: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: Painter? = null,
    leadingIconDes: String? = null,
    trailingIcon: ImageVector? = null,
    trailingIconDes: String? = null,
    iconTint: Color = GroovifyTheme.colors.onSecondary,
    shape: Shape = GroovifyTheme.shape.level1,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = GroovifyTheme.colors.secondary,
        contentColor = GroovifyTheme.colors.onSecondary,
        disabledContainerColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level1),
        disabledContentColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
    ),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(
        defaultElevation = GroovifyTheme.elevation.level0,
        pressedElevation = GroovifyTheme.elevation.level0,
        focusedElevation = GroovifyTheme.elevation.level0,
        hoveredElevation = GroovifyTheme.elevation.level1
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(
        start = GroovifyTheme.spacing.level3,
        top = GroovifyTheme.spacing.level1,
        end = GroovifyTheme.spacing.level3,
        bottom = GroovifyTheme.spacing.level1
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {

    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        elevation = elevation,
        shape = shape,
        border = border,
        interactionSource = interactionSource
    ) {

        if (leadingIcon != null) {
            Icon(
                painter = leadingIcon,
                contentDescription = leadingIconDes,
                modifier = Modifier.padding(end = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }

        CaptionTexts.Level1(
            text = textToShow,
            color = if (enabled)
                GroovifyTheme.colors.onSecondary
            else
                GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
        )

        if (trailingIcon != null) {
            Icon(
                imageVector = trailingIcon,
                contentDescription = trailingIconDes,
                modifier = Modifier.padding(start = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }
    }
}


/**
 * ![Filled tonal button image](https://developer.android.com/images/reference/androidx/compose/material3/filled-tonal-button.png)
 *
 * Filled tonal buttons are medium-emphasis buttons that is an alternative middle ground between
 * default [Button]s (filled) and [OutlinedButton]s. They can be used in contexts where
 * lower-priority button requires slightly more emphasis than an outline would give, such as "Next"
 * in an onboarding flow. Tonal buttons use the secondary color mapping.
 *
 * @param modifier the [Modifier] to be applied to this button
 * @param enabled controls the enabled state of this button. When `false`, this component will not
 * respond to user input, and it will appear visually disabled and disabled to accessibility
 * services.
 * @param textToShow This is the text to be shown in the Button
 * @param leadingIcon This is the leading Icon of the Button which is optional
 * @param leadingIconDes This is the description of the Icon which is provided and it is also optional
 * @param trailingIcon This is the trailing Icon of the Button which is optional
 * @param trailingIconDes This is the description of the Icon which is provided and it is also optional
 * @param iconTint This is the tint color of the Icon given
 * @param shape defines the shape of this button's container, border (when [border] is not null),
 * and shadow (when using [elevation])
 * @param colors [ButtonColors] that will be used to resolve the colors for this button in different
 * states. See [ButtonDefaults.filledTonalButtonColors].
 * @param elevation [ButtonElevation] used to resolve the elevation for this button in different
 * states. This controls the size of the shadow below the button. Additionally, when the container
 * color is [ColorScheme.surface], this controls the amount of primary color applied as an overlay.
 * @param border the border to draw around the container of this button
 * @param contentPadding the spacing values to apply internally between the container and the
 * content
 * @param interactionSource the [MutableInteractionSource] representing the stream of [Interaction]s
 * for this button. You can create and pass in your own `remember`ed instance to observe
 * [Interaction]s and customize the appearance / behavior of this button in different states.
 * @param onClick called when this button is clicked
 */
@Composable
fun AppTonalButton(
    textToShow: String,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    leadingIcon: ImageVector? = null,
    leadingIconDes: String? = null,
    trailingIcon: Painter? = null,
    trailingIconDes: String? = null,
    iconTint: Color = GroovifyTheme.colors.onSecondary,
    shape: Shape = GroovifyTheme.shape.level1,
    colors: ButtonColors = ButtonDefaults.filledTonalButtonColors(
        containerColor = GroovifyTheme.colors.secondary,
        contentColor = GroovifyTheme.colors.onSecondary,
        disabledContainerColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level1),
        disabledContentColor = GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
    ),
    elevation: ButtonElevation? = ButtonDefaults.filledTonalButtonElevation(
        defaultElevation = GroovifyTheme.elevation.level0,
        pressedElevation = GroovifyTheme.elevation.level0,
        focusedElevation = GroovifyTheme.elevation.level0,
        hoveredElevation = GroovifyTheme.elevation.level1
    ),
    border: BorderStroke? = null,
    contentPadding: PaddingValues = PaddingValues(
        start = GroovifyTheme.spacing.level3,
        top = GroovifyTheme.spacing.level1,
        end = GroovifyTheme.spacing.level3,
        bottom = GroovifyTheme.spacing.level1
    ),
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
    onClick: () -> Unit
) {

    FilledTonalButton(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = colors,
        contentPadding = contentPadding,
        elevation = elevation,
        shape = shape,
        border = border,
        interactionSource = interactionSource
    ) {

        if (leadingIcon != null) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = leadingIconDes,
                modifier = Modifier.padding(end = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }

        CaptionTexts.Level1(
            text = textToShow,
            color = if (enabled)
                GroovifyTheme.colors.onSecondary
            else
                GroovifyTheme.colors.onSurface.copy(GroovifyTheme.alphaValues.level2)
        )

        if (trailingIcon != null) {
            Icon(
                painter = trailingIcon,
                contentDescription = trailingIconDes,
                modifier = Modifier.padding(start = GroovifyTheme.spacing.level0),
                tint = if (enabled)
                    iconTint
                else
                    GroovifyTheme.colors.onSurface.copy(alpha = GroovifyTheme.alphaValues.level2)
            )
        }
    }
}