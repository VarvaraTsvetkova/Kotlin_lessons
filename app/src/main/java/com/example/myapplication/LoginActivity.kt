package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {


    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Настройка анимации
        binding.animationView.apply {
            setAnimation("Confetti.json")
            playAnimation()
            loop(true)
        }


        binding.submitButton.setOnClickListener {
            loginUser()
        }
    }

    private fun loginUser() {

        val email = binding.emailEditText.text.toString()
        val password = binding.passwordEditText.text.toString()


        val emailError = AuthValidator.validateEmail(email)
        val passwordError = AuthValidator.validatePassword(password)


        binding.emailEditText.error = emailError
        binding.passwordEditText.error = passwordError

        if (emailError == null && passwordError == null) {
            Toast.makeText(this, "Вход выполнен успешно!", Toast.LENGTH_SHORT).show()

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}