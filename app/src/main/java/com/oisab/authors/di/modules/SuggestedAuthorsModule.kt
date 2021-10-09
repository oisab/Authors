package com.oisab.authors.di.modules

import androidx.lifecycle.ViewModel
import com.oisab.authors.screens.main.suggestions.SuggestedAuthorsViewModel
import com.oisab.authors.di.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class SuggestedAuthorsModule {

    @Binds
    @IntoMap
    @ViewModelKey(SuggestedAuthorsViewModel::class)
    internal abstract fun suggestedAuthorsViewModel(viewModel: SuggestedAuthorsViewModel): ViewModel
}