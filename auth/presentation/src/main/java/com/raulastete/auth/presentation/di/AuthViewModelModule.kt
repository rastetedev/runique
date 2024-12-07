package com.raulastete.auth.presentation.di

import com.raulastete.auth.presentation.register.RegisterViewModel
import com.raulastete.auth.presentation.login.LoginViewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.dsl.module

val authViewModelModule = module {
    viewModelOf(::RegisterViewModel)
    viewModelOf(::LoginViewModel)
}