package com.ashoks.catsapp.presentation.ui.cat


sealed class CatEvent{

    data class GetCatEvent(
        val id: String
    ): CatEvent()

}