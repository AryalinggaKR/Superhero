/**
 *  Nama    : Aryalingga Karamasatya Radhiendra
 *  NIM     : 10118368
 *  Kelas   : AKBUL1
 */
package com.example.superhero

import Superhero
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var superheroName: TextView
    private lateinit var superheroImage: ImageView
    private lateinit var superheroFullName: TextView
    private lateinit var superheroAlterEgos: TextView
    private lateinit var superheroPlaceOfBirth: TextView
    private lateinit var superheroFirstAppearance: TextView
    private lateinit var superheroPublisher: TextView
    private lateinit var superheroAlignment: TextView
    private lateinit var superheroGender: TextView
    private lateinit var superheroRace: TextView
    private lateinit var superheroHeight: TextView
    private lateinit var superheroWeight: TextView
    private lateinit var superheroIntelligence: TextView
    private lateinit var superheroStrength: TextView
    private lateinit var superheroSpeed: TextView
    private lateinit var superheroDurability: TextView
    private lateinit var superheroPower: TextView
    private lateinit var superheroCombat: TextView
    private lateinit var accessToken: String
    private lateinit var superheroId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        superheroName = findViewById(R.id.superhero_name)
        superheroImage = findViewById(R.id.superhero_image)
        superheroFullName = findViewById(R.id.superhero_fullname)
        superheroAlterEgos = findViewById(R.id.superhero_alterEgos)
        superheroPlaceOfBirth = findViewById(R.id.superhero_placeOfBirth)
        superheroFirstAppearance = findViewById(R.id.superhero_firstAppearance)
        superheroPublisher = findViewById(R.id.superhero_publisher)
        superheroAlignment = findViewById(R.id.superhero_alignment)
        superheroGender = findViewById(R.id.superhero_gender)
        superheroRace = findViewById(R.id.superhero_race)
        superheroHeight = findViewById(R.id.superhero_height)
        superheroWeight = findViewById(R.id.superhero_weight)
        superheroIntelligence = findViewById(R.id.superhero_intelligence)
        superheroStrength = findViewById(R.id.superhero_strength)
        superheroSpeed = findViewById(R.id.superhero_speed)
        superheroDurability = findViewById(R.id.superhero_durability)
        superheroPower = findViewById(R.id.superhero_power)
        superheroCombat = findViewById(R.id.superhero_combat)

        accessToken = "b863c3594af18f11440aadb7544143ac"
        superheroId = "687"

        getSuperheroData()
    }

    private fun getSuperheroData() {
        val call = RetrofitInstance.api.getSuperhero(accessToken, superheroId)
        call.enqueue(object : Callback<Superhero> {
            override fun onResponse(call: Call<Superhero>, response: Response<Superhero>) {
                if (response.isSuccessful) {
                    val superhero = response.body()
                    Log.d("API Response", superhero.toString())
                    superheroName.text = superhero?.name
                    Picasso.get().load(superhero?.image?.url).into(superheroImage)
                    superheroFullName.text = "Full Name: ${superhero?.biography?.fullName ?: "N/A"}"
                    superheroAlterEgos.text = "Alter Egos: ${superhero?.biography?.alterEgos ?: "N/A"}"
                    superheroPlaceOfBirth.text = "Place of Birth: ${superhero?.biography?.placeOfBirth ?: "N/A"}"
                    superheroFirstAppearance.text = "First Appearance: ${superhero?.biography?.firstAppearance ?: "N/A"}"
                    superheroPublisher.text = "Publisher: ${superhero?.biography?.publisher ?: "N/A"}"
                    superheroAlignment.text = "Alignment: ${superhero?.biography?.alignment ?: "N/A"}"
                    superheroGender.text = "Gender: ${superhero?.appearance?.gender ?: "N/A"}"
                    superheroRace.text = "Race: ${superhero?.appearance?.race ?: "N/A"}"
                    superheroHeight.text = "Height: ${superhero?.appearance?.height?.joinToString(", ") ?: "N/A"}"
                    superheroWeight.text = "Weight: ${superhero?.appearance?.weight?.joinToString(", ") ?: "N/A"}"
                    superheroIntelligence.text = "Intelligence: ${superhero?.powerstats?.intelligence ?: "N/A"}"
                    superheroStrength.text = "Strength: ${superhero?.powerstats?.strength ?: "N/A"}"
                    superheroSpeed.text = "Speed: ${superhero?.powerstats?.speed ?: "N/A"}"
                    superheroDurability.text = "Durability: ${superhero?.powerstats?.durability ?: "N/A"}"
                    superheroPower.text = "Power: ${superhero?.powerstats?.power ?: "N/A"}"
                    superheroCombat.text = "Combat: ${superhero?.powerstats?.combat ?: "N/A"}"
                } else {
                    Log.d("API Error", response.errorBody()?.string() ?: "Unknown error")
                }
            }

            override fun onFailure(call: Call<Superhero>, t: Throwable) {
                Toast.makeText(this@MainActivity, "Failed to load data", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
