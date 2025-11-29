package ir.ayantech.ayanhook.data.remote.impl

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import ir.ayantech.ayanhook.data.dto.LoginRequestDto
import ir.ayantech.ayanhook.data.dto.LoginResponseDto
import ir.ayantech.ayanhook.data.remote.AuthApi

class KtorAuthApi(private val client: HttpClient, private val baseUrl: String) : AuthApi {
    override suspend fun login(request: LoginRequestDto): LoginResponseDto {
        val response: HttpResponse = client.post("$baseUrl/login") {
            contentType(ContentType.Application.Json)
            setBody(request)
        }
        return response.body()
    }
}