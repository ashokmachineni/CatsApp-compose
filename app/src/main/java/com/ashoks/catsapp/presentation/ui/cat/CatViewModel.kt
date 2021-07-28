package com.ashoks.catsapp.presentation.ui.cat

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ashoks.catsapp.domain.model.Cats
import com.ashoks.catsapp.repository.CatsRepository
import com.ashoks.catsapp.util.TAG
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Named

const val STATE_KEY_RECIPE = "recipe.state.recipe.key"

@ExperimentalCoroutinesApi
class CatViewModel
@ViewModelInject
constructor(
    private val catsRepository: CatsRepository,
    private @Named("auth_token") val token: String,
    @Assisted private val state: SavedStateHandle,
): ViewModel() {

    val recipe: MutableState<Cats?> = mutableStateOf(null)

    val loading = mutableStateOf(false)

    init {
        // restore if process dies
        state.get<String>(STATE_KEY_RECIPE)?.let { catsId ->
            onTriggerEvent(CatEvent.GetCatEvent(catsId))
        }
    }

    fun onTriggerEvent(event: CatEvent) {
        viewModelScope.launch {
            try {
                when (event) {
                    is CatEvent.GetCatEvent -> {
                        if (recipe.value == null) {
                            getCats(event.id)
                        }
                    }
                }
            } catch (e: Exception) {
                Log.e(TAG, "launchJob: Exception: ${e}, ${e.cause}")
                e.printStackTrace()
            }
        }
    }

    private suspend fun getCats(id: String) {
        loading.value = true

        // simulate a delay to show loading
        delay(1000)

        val cats = catsRepository.get(token = token, id)
        this.recipe.value = cats

        state.set(STATE_KEY_RECIPE, cats.id)

        loading.value = false
    }
}
