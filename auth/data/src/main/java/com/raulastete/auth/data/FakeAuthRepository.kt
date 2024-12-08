package com.raulastete.auth.data

import com.raulastete.auth.domain.AuthRepository
import com.raulastete.core.data.networking.post
import com.raulastete.core.domain.AuthInfo
import com.raulastete.core.domain.SessionStorage
import com.raulastete.core.domain.util.DataError
import com.raulastete.core.domain.util.EmptyDataResult
import com.raulastete.core.domain.util.Result
import com.raulastete.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

class FakeAuthRepository(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
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

    override suspend fun login(
        email: String,
        password: String
    ): EmptyDataResult<DataError.Network> {
        /*val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email = email,
                password = password
            )
        )

        if (result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()*/
        delay(3000)
        sessionStorage.set(
            AuthInfo(
                accessToken = "fakeAccessToken",
                refreshToken = "fakeRefreshToken",
                userId = "fakeUserId"
            )
        )
        return Result.Success(Unit)
    }


}