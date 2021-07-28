package com.ashoks.catsapp

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.test.core.app.launchActivity
import com.ashoks.catsapp.domain.model.Cats
import com.ashoks.catsapp.presentation.MainActivity
import com.ashoks.catsapp.presentation.ui.cats_list.CatsListFragment
import com.ashoks.catsapp.presentation.ui.cats_list.CatsListViewModel_AssistedFactory
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@HiltAndroidTest
class MainTest {
    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @ExperimentalMaterialApi
    @ExperimentalComposeUiApi
    @Inject
    lateinit var fragmentFactory: CatsListFragment
    @Before
    fun init(){
        hiltRule.inject()
    }

    @Test
    fun TestCaseOne(){
        hiltRule.inject()
    }

    @ExperimentalCoroutinesApi
    @ExperimentalMaterialApi
    @ExperimentalComposeUiApi
    @Test
/*    fun mainFragmentTest(){
        val scenario = launchFragmentInHiltContainer<Cats>(
            factory = fragmentFactory
        )
    }*/
    fun mainActivityTest(){
        val scenario = launchActivity<MainActivity>()
    }



}