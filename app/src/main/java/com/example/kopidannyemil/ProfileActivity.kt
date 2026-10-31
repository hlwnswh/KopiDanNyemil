package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        val tvSapaan = findViewById<TextView>(R.id.tvSapaan)
        val etNama = findViewById<EditText>(R.id.etNama)

        tvSapaan.text = "Halo, " + UserData.nama
        etNama.setText(UserData.nama)

        findViewById<TextView>(R.id.btnSave).setOnClickListener {
            val namaBaru = etNama.text.toString()
            if (namaBaru.isEmpty()) {
                Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
            } else {
                UserData.nama = namaBaru
                tvSapaan.text = "Halo, " + UserData.nama
                Toast.makeText(this, "Profile disimpan", Toast.LENGTH_SHORT).show()
            }
        }

        findViewById<TextView>(R.id.navHome).setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(i)
        }
        findViewById<TextView>(R.id.navOrder).setOnClickListener {
            startActivity(Intent(this, AlamatActivity::class.java))
        }
    }
}