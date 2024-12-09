package com.raulastete.run.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.raulastete.run.presentation.run_overview.RunOverviewViewModel
import com.raulastete.run.presentation.active_run.ActiveRunViewModel

val runViewModelModule = module {
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}