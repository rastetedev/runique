package com.raulastete.run.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.raulastete.run.presentation.run_overview.RunOverviewViewModel
import com.raulastete.run.presentation.active_run.ActiveRunViewModel
import org.koin.core.module.dsl.singleOf
import com.raulastete.run.domain.RunningTracker

val runPresentationModule = module {
    singleOf(::RunningTracker)
    viewModelOf(::RunOverviewViewModel)
    viewModelOf(::ActiveRunViewModel)
}