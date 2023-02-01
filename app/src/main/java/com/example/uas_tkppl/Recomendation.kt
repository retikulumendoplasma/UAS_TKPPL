package com.example.uas_tkppl

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.example.tugas_tkkpl_e_call.helper.constant
import com.example.tugas_tkkpl_e_call.helper.preferencesHelper
import kotlinx.android.synthetic.main.activity_recomendation.*

class Recomendation : AppCompatActivity() {
    lateinit var sharedPref: preferencesHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recomendation)

        val resikoJikaKurus  = intent.getStringExtra("jikakurus")
        val resikoJikaNormal = intent.getStringExtra("jikanormal")
        val resikoJikaGemuk  = intent.getStringExtra("jikagemuk")

        //resiko
        val resikoKurus = "ketika berat badan Anda cukup rendah dari berat ideal, Anda juga memiliki risiko penyakit tertentu antaralain: \n– Malnutrisi. \n– Anemia. \n– Pertumbuhan dan perkembangan terhambat"
        val resikoNormal = "Orang dengan nilai indeks massa tubuh normal tetap mungkin berisiko mengalami penyakit tertentu. Namun risikonya lebih rendah ketimbang orang dengan nilai IMT yang tidak normal.\n" +
                "Orang dengan IMT normal juga bisa memiliki persen lemak yang tinggi, maka itu harus dihitung lemak tubuh dan kondisi metabolismenya."
        val resikoGemuk = "kelebihan berat badan dapat meningkatkan risiko diabetes. \n-hipertensi \n-gangguan jantung \n-stroke \n-osteoartritis \n- perlemakan hati (fatty liver) \n- penyakit ginjal"

        //saran
        val saranKurus = "Bila Anda ingin meningkatkan berat badan, Anda perlu mengetahui terlebih dulu berapa banyak kalori yang dibutuhkan tubuh per harinya. Agar tubuh mendapatkan sumber energi yang maksimal untuk beraktivitas.\n\n" +
                "Menambah berat badan harus menambah massa otot bukan menambah massa lemak. Proporsi makanan harus diperhatikan tidak hanya kalori saja perlu zat gizi makro (karbohidrat, protein, lemak) dan mikro (vitamin dan mineral).\n\n" +
                "Anda juga bisa melakukan olahraga rutin agar otot terbentuk dengan optimal. Anda bisa menambahkan asupan kalori Anda sebanyak 300-500 kkal per hari. Misalnya, jika kebutuhan total kalori harian Anda adalah 1700 kkal. Artinya, Anda perlu mengonsumsi makanan dengan total 1700+500 = 2200 kkal per hari."
        val saranNormal= "Jika Anda ingin menjaga berat badan, penting untuk mengetahui berapa banyak kalori yang Anda butuhkan per harinya, agar tubuh mampu melakukan fungsinya dalam beraktivitas sehari-hari. Anda perlu mengonsumsi makanan dan minuman dengan jumlah kalori harian yang sesuai dengan kebutuhan tubuh.\n\n" +
                "Misalnya, jika kebutuhan kalori harian 1950 kkal, pastikan Anda mengonsumsi makanan dan minuman yang sesuai dengan nilai kalori tersebut. Jangan lupa juga untuk menggunakan prinsip gizi seimbang. Dengan begitu, semua jenis gizi yang dibutuhkan tubuh akan terpenuhi dengan baik."
        val saranGemuk = "Jika ingin menurunkan berat badan, ketahui dulu berapa banyak kalori yang Anda butuhkan per hari untuk menjalankan fungsi dasar tubuh dan aktivitas sehari-hari. Penting juga untuk mengetahui bagaimana kondisi kesehatan Anda saat ini, karena hal ini akan memengaruhi perhitungan kalori harian.\n\n" +
                "Selanjutnya, lihat label informasi nilai gizi pada produk, catat berapa kalori yang akan dikonsumsi. Sesuaikan dengan jumlah kalori yang sudah dikurangi sebelumnya dari total kebutuhan kalori harian. konsumsi makanan dan minuman dengan kandungan kalori yang lebih sedikit dari kebutuhan harian.\n\n" +
                "Misalnya, jika kebutuhan asupan kalori Anda 2100 kkal per hari, usahakan untuk mengurangi jumlahnya sekitar 300-500 kkal. Biasanya Anda akan dianjurkan untuk mengurangi kalori harian sebanyak 5-15% dari kebutuhan sebelumnya."


        if (resikoJikaKurus == "kurus"){
            tv_hasil_resiko.setText(resikoKurus)
            tv_hasil_saran.setText(saranKurus)
        }
        else if (resikoJikaNormal == "normal"){
            tv_hasil_resiko.setText(resikoNormal)
            tv_hasil_saran.setText(saranNormal)
        }
        else if (resikoJikaGemuk == "gemuk"){
            tv_hasil_resiko.setText(resikoGemuk)
            tv_hasil_saran.setText(saranGemuk)
        }


        sharedPref = preferencesHelper(this)

        if (sharedPref.getBoolean(constant.PREF_ISON) == true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }


    }
}