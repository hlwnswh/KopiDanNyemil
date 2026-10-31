package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        findViewById<TextView>(R.id.btnDaftar).setOnClickListener {
            val nama = findViewById<EditText>(R.id.etNama).text.toString()
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()

            if (nama.isEmpty() || username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Semua kolom harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                val prefs = getSharedPreferences("akun", MODE_PRIVATE)
                prefs.edit()
                    .putString("nama", nama)
                    .putString("username", username)
                    .putString("password", password)
                    .apply()

                UserData.nama = nama
                Toast.makeText(this, "Akun berhasil dibuat", Toast.LENGTH_SHORT).show()

                val i = Intent(this, HomeActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
            }
        }
    }
}