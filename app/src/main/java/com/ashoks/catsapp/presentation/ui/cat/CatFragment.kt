package com.ashoks.catsapp.presentation.ui.cat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.ashoks.catsapp.presentation.BaseApplication
import com.ashoks.catsapp.presentation.components.CatView
import com.ashoks.catsapp.presentation.components.CircularIndeterminateProgressBar
import com.ashoks.catsapp.presentation.components.DefaultSnackbar
import com.ashoks.catsapp.presentation.components.LoadingCatShimmer
import com.ashoks.catsapp.presentation.components.util.SnackbarController
import com.ashoks.catsapp.presentation.theme.AppTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import javax.inject.Inject

const val IMAGE_HEIGHT = 260

@ExperimentalMaterialApi
@ExperimentalCoroutinesApi
@AndroidEntryPoint
class CatFragment : Fragment() {

    @Inject
    lateinit var application: BaseApplication

    private val snackbarController = SnackbarController(lifecycleScope)

    private val viewModel: CatViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.getString("catId")?.let { catId ->
            viewModel.onTriggerEvent(CatEvent.GetCatEvent(catId))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {

                val loading = viewModel.loading.value

                val recipe = viewModel.recipe.value

                val scaffoldState = rememberScaffoldState()

                AppTheme(
                    displayProgressBar = loading,
                    scaffoldState = scaffoldState,
                    darkTheme = application.isDark.value,
                ) {
                    Scaffold(
/*                        topBar = {
                            TopAppBar(
                                title = {
                                    Text("Cats Details")
                                },
                                navigationIcon = {
                                    IconButton(onClick = { requireActivity().onBackPressed() }) {
                                        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back Button")
                                    }
                                },

                                // content color is use to give
                                // color to our content in our toolbar.
                                contentColor = Color.White,

                                // below line is use to give
                                // elevation to our toolbar.``
                                elevation = 12.dp
                            )
                        },*/
                        scaffoldState = scaffoldState,
                        snackbarHost = {
                            scaffoldState.snackbarHostState
                        }
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize()
                        ) {
                            if (loading && recipe == null) LoadingCatShimmer(imageHeight = IMAGE_HEIGHT.dp)
                            else recipe?.let {
/*                                if(it.id == 1) { // force an error to demo snackbar
                                    snackbarController.getScope().launch {
                                        snackbarController.showSnackbar(
                                            scaffoldState = scaffoldState,
                                            message = "An error occurred with this recipe",
                                            actionLabel = "Ok"
                                        )
                                    }
                                }*/
                                //  else{
                                CatView(
                                    cats = it,
                                )
                                //   }
                            }
                            CircularIndeterminateProgressBar(
                                isDisplayed = loading,
                                verticalBias = 0.3f
                            )
                            DefaultSnackbar(
                                snackbarHostState = scaffoldState.snackbarHostState,
                                onDismiss = {
                                    scaffoldState.snackbarHostState.currentSnackbarData?.dismiss()
                                },
                                modifier = Modifier.align(Alignment.BottomCenter)
                            )
                        }
                    }
                }
            }
        }
    }
}








