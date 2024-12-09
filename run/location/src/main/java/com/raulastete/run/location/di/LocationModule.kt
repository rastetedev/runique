package com.raulastete.run.location.di

import com.raulastete.run.domain.LocationObserver
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import com.raulastete.run.location.AndroidLocationObserver
import org.koin.dsl.bind

val locationModule = module {
    singleOf(::AndroidLocationObserver).bind<LocationObserver>()
}