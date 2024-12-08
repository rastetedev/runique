package com.raulastete.run.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module
import com.raulastete.run.presentation.run_overview.RunOverviewViewModel

val runModule = module {
    viewModelOf(::RunOverviewViewModel)
}