package com.raulastete.auth.domain

import com.raulastete.core.domain.util.DataError
import com.raulastete.core.domain.util.EmptyDataResult

interface AuthRepository {

    suspend fun register(email: String, password: String): EmptyDataResult<DataError.Network>
    suspend fun login(email: String, password: String): EmptyDataResult<DataError.Network>
}