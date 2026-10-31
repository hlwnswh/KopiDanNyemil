package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AlamatActivity : AppCompatActivity() {

    private fun tampilkanPesanan() {
        val tv = findViewById<TextView>(R.id.tvDaftarPesanan)
        val btnKosongkan = findViewById<TextView>(R.id.btnKosongkan)

        if (UserData.daftarPesanan.isEmpty()) {
            tv.text = "Belum ada menu. Pilih menu di Home lalu klik Pesan."
            btnKosongkan.visibility = android.view.View.GONE
        } else {
            val hitung = UserData.daftarPesanan.groupingBy { it }.eachCount()
            tv.text = hitung.entries.joinToString("\n") { "• " + it.key + " x" + it.value }
            btnKosongkan.visibility = android.view.View.VISIBLE
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alamat)

        findViewById<TextView>(R.id.btnBack).setOnClickListener { finish() }

        tampilkanPesanan()

        findViewById<TextView>(R.id.btnKosongkan).setOnClickListener {
            UserData.daftarPesanan.clear()
            tampilkanPesanan()
        }

        findViewById<TextView>(R.id.btnOrderKirim).setOnClickListener {
            val nama = findViewById<EditText>(R.id.etNamaLengkap).text.toString()
            val alamat = findViewById<EditText>(R.id.etAlamat).text.toString()

            if (UserData.daftarPesanan.isEmpty()) {
                Toast.makeText(this, "Pilih menu dulu di Home", Toast.LENGTH_SHORT).show()
            } else if (nama.isEmpty() || alamat.isEmpty()) {
                Toast.makeText(this, "Nama lengkap dan alamat harus diisi", Toast.LENGTH_SHORT).show()
            } else {
                startActivity(Intent(this, KonfirmasiActivity::class.java))
            }
        }
    }
}