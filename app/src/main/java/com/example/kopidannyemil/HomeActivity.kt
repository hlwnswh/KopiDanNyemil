package com.example.kopidannyemil

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

data class Menu(val nama: String, val deskripsi: String, val harga: String, val emoji: String)

class HomeActivity : AppCompatActivity() {

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.tvSapaan).text = "Halo, " + UserData.nama
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        findViewById<TextView>(R.id.navOrder).setOnClickListener {
            startActivity(Intent(this, AlamatActivity::class.java))
        }
        findViewById<TextView>(R.id.navProfile).setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }

        val daftarMenu = listOf(
            Menu("Kopi Susu Gula Aren", "Espresso, susu, gula aren", "Rp 22.000", "☕"),
            Menu("Americano", "Espresso dan air panas", "Rp 18.000", "🥤"),
            Menu("Cappuccino", "Espresso, foam susu lembut", "Rp 25.000", "☕"),
            Menu("Latte", "Espresso dan susu steam", "Rp 24.000", "🥛"),
            Menu("Matcha Latte", "Matcha Jepang, susu segar", "Rp 27.000", "🍵"),
            Menu("Cokelat Panas", "Cokelat pekat, susu hangat", "Rp 23.000", "🍫"),
            Menu("Teh Tarik", "Teh pekat, susu manis", "Rp 16.000", "🫖"),
            Menu("Es Teh Lemon", "Teh dingin, perasan lemon", "Rp 14.000", "🍋"),
            Menu("Jus Alpukat", "Alpukat segar, susu cokelat", "Rp 20.000", "🥑"),
            Menu("Smoothie Mangga", "Mangga, yoghurt, es batu", "Rp 22.000", "🥭"),
            Menu("Donat Cokelat", "Donat empuk, glaze cokelat", "Rp 12.000", "🍩"),
            Menu("Croissant Butter", "Pastry renyah, butter gurih", "Rp 20.000", "🥐"),
            Menu("Sourdough Loaf", "Roti fermentasi alami", "Rp 35.000", "🍞"),
            Menu("Roti Bakar Keju", "Roti bakar, keju leleh", "Rp 18.000", "🧀"),
            Menu("Kentang Goreng", "Kentang renyah, saus sambal", "Rp 17.000", "🍟"),
            Menu("Pisang Goreng", "Pisang manis, tepung krispi", "Rp 15.000", "🍌"),
            Menu("Brownies", "Cokelat padat, taburan kacang", "Rp 19.000", "🍰"),
            Menu("Cookies Cokelat", "Cookies renyah, choco chip", "Rp 10.000", "🍪"),
            Menu("Sandwich Telur", "Roti, telur, selada, mayo", "Rp 21.000", "🥪"),
            Menu("Nasi Goreng Kampung", "Nasi, telur, ayam suwir", "Rp 28.000", "🍳")
        )

        val listMenu = findViewById<LinearLayout>(R.id.listMenu)

        for (menu in daftarMenu) {
            val item = LayoutInflater.from(this).inflate(R.layout.item_menu, listMenu, false)

            item.findViewById<TextView>(R.id.tvEmoji).text = menu.emoji
            item.findViewById<TextView>(R.id.tvNama).text = menu.nama
            item.findViewById<TextView>(R.id.tvDeskripsi).text = "• " + menu.deskripsi
            item.findViewById<TextView>(R.id.tvHarga).text = menu.harga

            item.findViewById<TextView>(R.id.btnPesan).setOnClickListener {
                UserData.daftarPesanan.add(menu.nama)
                Toast.makeText(this, menu.nama + " ditambahkan ke pesanan", Toast.LENGTH_SHORT).show()
            }

            listMenu.addView(item)
        }
    }
}