package ir.ayantech.ayanhook.domain.usecase


import ir.ayantech.ayanhook.domain.model.User
import ir.ayantech.ayanhook.domain.repository.AuthRepository

class LoginUseCase(
    private val repository: AuthRepository
) {
    suspend operator fun invoke(username: String, password: String): User {
        require(username.isNotBlank() && password.isNotBlank()) { "username/password must not be blank" }
        return repository.login(username, password)
    }
}