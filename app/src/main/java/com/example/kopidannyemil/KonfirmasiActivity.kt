package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class KonfirmasiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_konfirmasi)

        findViewById<TextView>(R.id.tvSapaan).text = "Halo, " + UserData.nama

        findViewById<TextView>(R.id.btnOke).setOnClickListener {
            UserData.daftarPesanan.clear()
            val i = Intent(this, HomeActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(i)
        }
    }
}