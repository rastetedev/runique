package com.raulastete.auth.data

import com.raulastete.auth.domain.AuthRepository
import com.raulastete.core.data.networking.post
import com.raulastete.core.domain.util.DataError
import com.raulastete.core.domain.util.EmptyDataResult
import com.raulastete.core.domain.util.Result
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

class FakeAuthRepository(
    private val httpClient: HttpClient
) : AuthRepository {

    override suspend fun register(
        email: String,
        password: String
    ): EmptyDataResult<DataError.Network> {

        /*return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email = email,
                password = password
            )
        )*/
        delay(5000)
        return Result.Success(Unit)
    }

}