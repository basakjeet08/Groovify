package com.dev.androidmonkey.designsystem.molecular.pager

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import com.dev.androidmonkey.designsystem.GroovifyTheme
import com.dev.androidmonkey.designsystem.atomic.modifier.appCarouselTransition
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * The [AppHorizontalPager] composable function is a custom component in Jetpack Compose, a declarative UI
 * framework for Android. This component provides a horizontally scrollable banner or carousel
 * with animation and dot indicators. It takes a list of items (bannerList) and displays them
 * one by one, allowing users to swipe horizontally to view different items.
 *
 * @param itemList: A list of items (List<T>) that you want to display in the banner. Replace
 * <T> with the type of items you are using in the list.
 * @param modifier: (Optional) A Compose Modifier that allows you to customize the appearance and
 * behavior of the AppBanner component.
 * @param animationDelay This is the Delay between each animation
 * @param contentPadding a padding around the whole content. This will add padding for the
 * content after it has been clipped, which is not possible via [modifier] param. You can use it
 * to add a padding before the first page or after the last one. Use [pageSpacing] to add spacing
 * between the pages.
 * @param pageSpacing The amount of space to be used to separate the pages in this Pager
 * @param userScrollEnabled whether the scrolling via the user gestures or accessibility actions
 * is allowed. You can still scroll programmatically using [PagerState.scroll] even when it is
 * disabled.
 * @param verticalAlignment How pages are aligned vertically in this Pager.
 * @param content: A lambda function (@Composable BoxScope.(page: Int) -> Unit) that defines the
 * content to be displayed for each page in the banner. It takes the current page index as
 * an argument, allowing you to customize the content for each item in the list.
 * */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun <T> AppHorizontalPager(
    itemList: List<T>,
    modifier: Modifier = Modifier,
    animationDelay: Long = 2500L,
    contentPadding: PaddingValues = PaddingValues(horizontal = GroovifyTheme.spacing.level4),
    pageSpacing: Dp = GroovifyTheme.spacing.level2,
    userScrollEnabled: Boolean = false,
    verticalAlignment: Alignment.Vertical = Alignment.Top,
    content: @Composable BoxScope.(page: Int) -> Unit,
) {

    // This is the Pager State which keeps the state of the Pager
    val pagerState = rememberPagerState { itemList.size }

    // Coroutine Scope State
    val scope = rememberCoroutineScope()

    LaunchedEffect(pagerState.currentPage) {
        scope.launch {
            delay(animationDelay)

            // Calculating the next Page to be shown and transiting to it
            val newPosition = (pagerState.currentPage + 1) % pagerState.pageCount
            pagerState.animateScrollToPage(newPosition)
        }
    }

    // Showing the Horizontal Pager
    HorizontalPager(
        state = pagerState,
        verticalAlignment = verticalAlignment,
        contentPadding = contentPadding,
        pageSpacing = pageSpacing,
        userScrollEnabled = userScrollEnabled
    ) { page ->
        Box(modifier = modifier.appCarouselTransition(page, pagerState)) {
            content(page)
        }
    }
}