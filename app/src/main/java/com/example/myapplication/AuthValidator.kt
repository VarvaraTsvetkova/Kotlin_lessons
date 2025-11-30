package com.example.myapplication

object AuthValidator {

    fun validateEmail(email: String): String? {
        return if (email.isEmpty()) {
            "Email не может быть пустым"
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            "Введите корректный email"
        } else {
            null // Ошибок нет
        }
    }

    fun validatePassword(password: String): String? {
        return when {
            password.isEmpty() -> "Пароль не может быть пустым"
            password.length < 6 -> "Пароль должен содержать минимум 6 символов"
            !password.any { it.isDigit() } -> "Пароль должен содержать хотя бы одну цифру"
            !password.any { it.isLetter() } -> "Пароль должен содержать хотя бы одну букву"
            else -> null // Ошибок нет
        }
    }
}