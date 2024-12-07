package com.raulastete.core.data.networking.di

import com.raulastete.core.data.networking.HttpClientFactory
import com.raulastete.core.domain.SessionStorage
import com.raulastete.core.data.auth.EncryptedSessionStorage
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val coreDataModule = module {
    single {
        HttpClientFactory(
            sessionStorage = get()
        ).build()
    }
    singleOf(::EncryptedSessionStorage).bind<SessionStorage>()
}