package com.dev.androidmonkey.designsystem

import android.os.Build
import androidx.annotation.ChecksSdkIntAtLeast
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.platform.LocalContext
import com.dev.androidmonkey.designsystem.atomic.AppAlphaValues
import com.dev.androidmonkey.designsystem.atomic.AppAspectRatio
import com.dev.androidmonkey.designsystem.atomic.AppTypography
import com.dev.androidmonkey.designsystem.atomic.AppCustomTypography
import com.dev.androidmonkey.designsystem.atomic.AppBoxSize
import com.dev.androidmonkey.designsystem.atomic.AppButtonSize
import com.dev.androidmonkey.designsystem.atomic.AppCardHeight
import com.dev.androidmonkey.designsystem.atomic.AppCustomSize
import com.dev.androidmonkey.designsystem.atomic.DarkAppColors
import com.dev.androidmonkey.designsystem.atomic.AppElevation
import com.dev.androidmonkey.designsystem.atomic.AppIconSize
import com.dev.androidmonkey.designsystem.atomic.AppImageSize
import com.dev.androidmonkey.designsystem.atomic.LightAppColors
import com.dev.androidmonkey.designsystem.atomic.LocalAppAspectRatio
import com.dev.androidmonkey.designsystem.atomic.LocalAppBoxSize
import com.dev.androidmonkey.designsystem.atomic.LocalAppButtonSize
import com.dev.androidmonkey.designsystem.atomic.LocalAppCardHeight
import com.dev.androidmonkey.designsystem.atomic.LocalAppColors
import com.dev.androidmonkey.designsystem.atomic.LocalAppCustomSize
import com.dev.androidmonkey.designsystem.atomic.LocalAppElevation
import com.dev.androidmonkey.designsystem.atomic.LocalAppIconSize
import com.dev.androidmonkey.designsystem.atomic.LocalAppImageSize
import com.dev.androidmonkey.designsystem.atomic.LocalAppShape
import com.dev.androidmonkey.designsystem.atomic.LocalAppSpacing
import com.dev.androidmonkey.designsystem.atomic.LocalAppTintTheme
import com.dev.androidmonkey.designsystem.atomic.LocalAppTypography
import com.dev.androidmonkey.designsystem.atomic.AppShape
import com.dev.androidmonkey.designsystem.atomic.AppSpacing
import com.dev.androidmonkey.designsystem.atomic.AppTintTheme
import com.dev.androidmonkey.designsystem.atomic.LocalAppAlphaValues
import com.dev.androidmonkey.designsystem.atomic.LocalCustomAppTypography

/**
 * This is the default theme of the App which would be used as a Wrapper Theme over the
 * [MaterialTheme] theme
 */
@Composable
fun GroovifyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    disableDynamicTheming: Boolean = true,
    content: @Composable () -> Unit
) {
    // Color scheme
    val colorScheme = when {

        !disableDynamicTheming && supportsDynamicTheming() -> {
            val context = LocalContext.current
            if (darkTheme)
                dynamicDarkColorScheme(context)
            else
                dynamicLightColorScheme(context)
        }

        else -> if (darkTheme) DarkAppColors else LightAppColors
    }

    val appTintTheme = when {
        !disableDynamicTheming && supportsDynamicTheming() -> AppTintTheme(colorScheme.primary)
        else -> AppTintTheme()
    }
    CompositionLocalProvider(
        LocalAppAspectRatio provides AppAspectRatio(),
        LocalAppColors provides colorScheme,
        LocalAppTypography provides AppTypography,
        LocalCustomAppTypography provides AppCustomTypography(),
        LocalAppElevation provides AppElevation(),
        LocalAppIconSize provides AppIconSize(),
        LocalAppShape provides AppShape(),
        LocalAppSpacing provides AppSpacing(),
        LocalAppTintTheme provides appTintTheme,
        LocalAppBoxSize provides AppBoxSize(),
        LocalAppAlphaValues provides AppAlphaValues()
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = AppTypography,
            content = content
        )
    }
}

/**
 * The Wrapper Theme objects can be accessed using this object class from anywhere in the App
 */
object GroovifyTheme {

    /**
     * Aspect Ratio of the App
     */
    val aspectRatio: AppAspectRatio
        @Composable
        @ReadOnlyComposable
        get() = LocalAppAspectRatio.current

    /**
     * Colors of the app which are used by default
     */
    val colors: ColorScheme
        @Composable
        @ReadOnlyComposable
        get() = LocalAppColors.current

    /**
     * Custom Typography of the App
     */
    val customTypography: AppCustomTypography
        @Composable
        @ReadOnlyComposable
        get() = LocalCustomAppTypography.current

    /**
     * Default elevations of the app
     */
    val elevation: AppElevation
        @Composable
        @ReadOnlyComposable
        get() = LocalAppElevation.current

    /**
     * Default icon sizes of the App
     */
    val iconSize: AppIconSize
        @Composable
        @ReadOnlyComposable
        get() = LocalAppIconSize.current

    /**
     * Default Shapes of the App
     */
    val shape: AppShape
        @Composable
        @ReadOnlyComposable
        get() = LocalAppShape.current

    /**
     * Default Spacing for the App
     */
    val spacing: AppSpacing
        @Composable
        @ReadOnlyComposable
        get() = LocalAppSpacing.current

    /**
     * Default Tint Theme for the app
     */
    val tintTheme: AppTintTheme
        @Composable
        @ReadOnlyComposable
        get() = LocalAppTintTheme.current

    /**
     * Default Box Sizes for the App
     */
    val boxSize: AppBoxSize
        @Composable
        @ReadOnlyComposable
        get() = LocalAppBoxSize.current

    /**
     * Default Button sizes for the App
     */
    val buttonSize: AppButtonSize
        @Composable
        @ReadOnlyComposable
        get() = LocalAppButtonSize.current

    /**
     * Card Heights for the whole App
     */
    val cardHeight: AppCardHeight
        @Composable
        @ReadOnlyComposable
        get() = LocalAppCardHeight.current

    /**
     * Default Image Sizes for the whole App
     */
    val imageSize: AppImageSize
        @Composable
        @ReadOnlyComposable
        get() = LocalAppImageSize.current

    /**
     * Default Custom Sizes for the Whole App
     */
    val customSize: AppCustomSize
        @Composable
        @ReadOnlyComposable
        get() = LocalAppCustomSize.current

    /**
     * Default Custom App Alpha Values
     */
    val alphaValues: AppAlphaValues
        @Composable
        @ReadOnlyComposable
        get() = LocalAppAlphaValues.current
}

@ChecksSdkIntAtLeast(api = Build.VERSION_CODES.S)
fun supportsDynamicTheming() = Build.VERSION.SDK_INT >= Build.VERSION_CODES.S