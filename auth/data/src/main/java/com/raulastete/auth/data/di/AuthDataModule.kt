package com.raulastete.auth.data.di

import com.raulastete.auth.data.EmailPatternValidator
import com.raulastete.auth.domain.PatternValidator
import com.raulastete.auth.domain.UserDataValidator
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val authDataModule = module {
    single<PatternValidator> {
        EmailPatternValidator
    }

    singleOf(::UserDataValidator)
}