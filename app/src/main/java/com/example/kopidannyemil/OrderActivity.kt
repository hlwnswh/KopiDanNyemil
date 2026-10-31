package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val tv = findViewById<TextView>(R.id.tvIsiOrder)
        if (UserData.pesanan.isEmpty()) {
            tv.text = "Belum ada pesanan.\nPilih menu di Home lalu klik Pesan."
        } else {
            tv.text = "Pesanan terakhir:\n" + UserData.pesanan + "\n\nStatus: sedang diproses"
        }

        findViewById<TextView>(R.id.navHome).setOnClickListener {
            val i = Intent(this, HomeActivity::class.java)
            i.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(i)
        }
        findViewById<TextView>(R.id.navProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
            finish()
        }
    }
}