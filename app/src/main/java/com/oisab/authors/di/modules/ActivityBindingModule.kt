package com.oisab.authors.di.modules

import com.oisab.authors.screens.main.suggestions.SuggestedAuthorsFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {

    @ContributesAndroidInjector
    abstract fun suggestedAuthorsFragment(): SuggestedAuthorsFragment
}