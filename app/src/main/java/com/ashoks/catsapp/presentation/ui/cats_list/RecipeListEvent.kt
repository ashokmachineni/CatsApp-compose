package com.ashoks.catsapp.presentation.ui.cats_list


sealed class RecipeListEvent {

    object NewSearchEvent : RecipeListEvent()

    object NextPageEvent : RecipeListEvent()

    // restore after process death
    object RestoreStateEvent: RecipeListEvent()

    object NewSearchForInput: RecipeListEvent()
}