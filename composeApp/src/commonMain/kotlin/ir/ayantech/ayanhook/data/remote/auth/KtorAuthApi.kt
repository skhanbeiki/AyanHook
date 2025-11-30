package ir.ayantech.ayanhook.data.remote.auth

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.http.ContentType
import io.ktor.http.contentType
import ir.ayantech.ayanhook.data.dto.auth.LoginRequestDto
import ir.ayantech.ayanhook.data.dto.auth.LoginResponseDto
import ir.ayantech.ayanhook.data.remote.auth.AuthApi

class KtorAuthApi(private val client: HttpClient, private val baseUrl: String) : AuthApi {
    override suspend fun login(request: LoginRequestDto): LoginResponseDto {
        val response: HttpResponse = client.post("$baseUrl/login") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }
        return response.body()
    }
}