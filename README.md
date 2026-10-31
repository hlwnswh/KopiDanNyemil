# ☕ Kopi dan Nyemil

Aplikasi Android pemesanan makanan dan minuman untuk kedai kopi, dibuat dengan Kotlin dan Android Studio. Pengguna dapat mendaftar, masuk, memilih menu, mengisi alamat pengiriman, lalu menerima konfirmasi pesanan. Aplikasi ini dibuat sebagai tugas implementasi wireframe tanpa database.

> **Identitas**
> - Nama: Hilwa Hilwatun Niswah
> - NIM: _(isi NIM)_
> - Mata kuliah: _(isi mata kuliah)_
> - Dosen pengampu: _(isi nama dosen)_

---

## Deskripsi Aplikasi

**Kopi dan Nyemil** adalah aplikasi pemesanan sederhana dengan tema kedai kopi (warna krem dan cokelat). Alurnya mengikuti wireframe tugas: pengguna membuka aplikasi dari halaman Start, membuat akun atau login, memilih menu di Home, mengisi alamat pengiriman, dan mendapat halaman konfirmasi pesanan.

Data menu bersifat **statis (dummy data)** yang ditulis langsung di kode. Aplikasi tidak memakai database.

## Fitur

| Halaman | Fitur |
|---|---|
| **Start / Welcome** | Halaman pembuka sebagai pintu masuk aplikasi |
| **Sign Up** | Pilihan **Register** untuk akun baru atau **Login** untuk akun yang sudah ada |
| **Register** | Mengisi Nama, Username, dan Password. Data akun disimpan di perangkat |
| **Login** | Login dengan Username dan Password, dicocokkan dengan akun yang didaftarkan. Muncul pesan jika akun belum ada atau data salah |
| **Home** | Daftar **20 menu** makanan dan minuman lengkap dengan emoji, deskripsi, dan harga. Tombol **Pesan** menambahkan menu ke daftar pesanan |
| **Alamat Pengiriman (Order)** | Menampilkan semua menu yang dipesan (menu yang sama tampil sebagai `x2`, `x3`, dan seterusnya), form Nama Lengkap, Alamat, Patokan atau detail lengkap, dan tombol **Order dan Kirim**. Ada tombol untuk menghapus semua pesanan |
| **Konfirmasi Pesanan** | Sapaan nama pengguna, tanda **OK**, pesan terima kasih, dan tombol **Oke** untuk kembali ke Home |
| **Profile** | Melihat dan mengubah nama lewat tombol **Save**. Sapaan di Home ikut berubah |
| **Navigasi** | Bottom navigation (Home, Order, Profile) dan tombol **← Kembali** di halaman Sign Up, Register, Login, dan Alamat |

### Validasi
- Register: semua kolom wajib diisi.
- Login: username dan password harus cocok dengan akun yang terdaftar.
- Alamat: pesanan tidak boleh kosong, Nama Lengkap dan Alamat wajib diisi.
- Profile: nama tidak boleh kosong.

## Alur Aplikasi

```
Start → Sign Up → Register / Login → Home
Home → Pesan (tambah menu) → tab Order → Alamat Pengiriman → Konfirmasi → Home
Home ↔ Profile
```

## Teknologi yang Digunakan

- **Bahasa:** Kotlin
- **IDE:** Android Studio
- **Antarmuka:** XML layout (LinearLayout, ScrollView, TextView, EditText) dengan drawable shape kustom
- **Komponen Android:** `AppCompatActivity`, `Intent` untuk perpindahan halaman
- **Penyimpanan data:** objek `UserData` (data sesi di memori) dan `SharedPreferences` untuk menyimpan akun hasil Register. Bukan database
- **Build tool:** Gradle

## Struktur Proyek

```
app/src/main/
├── java/com/example/kopidannyemil/
│   ├── MainActivity.kt          # Start / Welcome
│   ├── SignUpActivity.kt        # Pilihan Register / Login
│   ├── RegisterActivity.kt
│   ├── LoginActivity.kt
│   ├── HomeActivity.kt          # Daftar 20 menu (dummy data)
│   ├── AlamatActivity.kt        # Daftar pesanan + form alamat
│   ├── KonfirmasiActivity.kt
│   ├── ProfileActivity.kt
│   └── UserData.kt              # Data pengguna dan daftar pesanan
└── res/
    ├── layout/                  # activity_*.xml dan item_menu.xml
    └── drawable/                # bg_button, bg_input, bg_back, bg_ok
```

## Cara Menjalankan

1. Clone repository ini:
   ```bash
   git clone https://github.com/hlwnswh/KopiDanNyemil.git
   ```
2. Buka folder proyek di **Android Studio**.
3. Tunggu proses **Gradle Sync** selesai.
4. Pilih emulator atau HP Android (aktifkan Debugging USB), lalu klik **Run** ▶.

## Screenshot

| Start | Sign Up | Register |
|---|---|---|
| ![Start](screenshots/01-start.png) | ![Sign Up](screenshots/02-signup.png) | ![Register](screenshots/03-register.png) |

| Login | Home | Alamat |
|---|---|---|
| ![Login](screenshots/04-login.png) | ![Home](screenshots/05-home.png) | ![Alamat](screenshots/06-alamat.png) |

| Konfirmasi | Profile |
|---|---|
| ![Konfirmasi](screenshots/07-konfirmasi.png) | ![Profile](screenshots/08-profile.png) |
