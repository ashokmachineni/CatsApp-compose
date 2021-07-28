package com.ashoks.catsapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ashoks.catsapp.domain.model.Cats
import com.ashoks.catsapp.presentation.ui.cats_list.PAGE_SIZE
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@Composable
fun CatsList(
    loading: Boolean,
    cats: List<Cats>,
    onChangeScrollPosition: (Int) -> Unit,
    page: Int,
    onTriggerNextPage: () -> Unit,
    onNavigateToCatDetailScreen: (String) -> Unit,
){
    Box(modifier = Modifier
        .background(color = MaterialTheme.colors.surface)
    ) {
        if (loading && cats.isEmpty()) {
            HorizontalDottedProgressBar()
//            LoadingRecipeListShimmer(imageHeight = 250.dp,)
        }
        else if(cats.isEmpty()){
            NothingHere()
        }
        else {
            LazyColumn{
                itemsIndexed(
                    items = cats
                ) { index, cats ->
                    onChangeScrollPosition(index)
                    if ((index + 1) >= (page * PAGE_SIZE) && !loading) {
                        onTriggerNextPage()
                    }
                    CatsCard(
                        cats = cats,
                        onClick = {
                            cats.id?.let { onNavigateToCatDetailScreen(it) }
                        }
                    )
                }
            }
        }
    }
}
