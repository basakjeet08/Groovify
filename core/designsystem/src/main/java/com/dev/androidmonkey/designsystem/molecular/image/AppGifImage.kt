package com.dev.androidmonkey.designsystem.molecular.image

import android.os.Build.VERSION.SDK_INT
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import coil.size.Size
import com.dev.androidmonkey.drawables.R


/**
 * The [AppGifImage] function is a composable function that creates and displays an icon.
 *
 * @param modifier the [Modifier] to be applied to this icon
 * @param url This is the URL of the Image from where it needs to be fetched
 * @param placeholder A [Painter] that is displayed while the image is loading.
 * @param contentDescription text used by accessibility services to describe what this icon
 * represents.
 * @param contentScale Optional scale parameter used to determine the aspect ratio scaling to be used.
 * @param colorFilter Optional colorFilter to apply for the [Painter] when it is rendered onscreen
 */
@Composable
fun AppGifImage(
    modifier: Modifier = Modifier,
    url: String,
    @DrawableRes placeholder: Int = R.drawable.error_404,
    contentDescription: String? = null,
    contentScale: ContentScale = ContentScale.FillBounds,
    colorFilter: ColorFilter? = null
) {
    val context = LocalContext.current

    val imageLoader = ImageLoader
        .Builder(context)
        .components {
            if (SDK_INT >= 28)
                add(ImageDecoderDecoder.Factory())
            else
                add(GifDecoder.Factory())
        }
        .build()

    Image(
        modifier = modifier.fillMaxWidth(),
        painter = rememberAsyncImagePainter(
            model = ImageRequest.Builder(context)
                .placeholder(AppCompatResources.getDrawable(context, placeholder))
                .data(data = url)
                .apply(block = { size(Size.ORIGINAL) })
                .build(),
            imageLoader = imageLoader
        ),
        contentDescription = contentDescription,
        contentScale = contentScale,
        colorFilter = colorFilter
    )
}