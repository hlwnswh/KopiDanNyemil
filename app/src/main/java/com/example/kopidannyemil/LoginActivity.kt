package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        findViewById<TextView>(R.id.btnMasuk).setOnClickListener {
            val username = findViewById<EditText>(R.id.etUsername).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()

            val prefs = getSharedPreferences("akun", MODE_PRIVATE)
            val userTersimpan = prefs.getString("username", null)
            val passTersimpan = prefs.getString("password", null)

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username dan password harus diisi", Toast.LENGTH_SHORT).show()
            } else if (userTersimpan == null) {
                Toast.makeText(this, "Belum ada akun, silakan Register dulu", Toast.LENGTH_SHORT).show()
            } else if (username == userTersimpan && password == passTersimpan) {
                UserData.nama = prefs.getString("nama", UserData.nama) ?: UserData.nama
                val i = Intent(this, HomeActivity::class.java)
                i.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(i)
            } else {
                Toast.makeText(this, "Username atau password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}