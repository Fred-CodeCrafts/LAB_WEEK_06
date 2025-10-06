package com.fredcodecrafts.lab_week_06

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fredcodecrafts.lab_week_06.model.CatBreed
import com.fredcodecrafts.lab_week_06.model.CatModel
import com.fredcodecrafts.lab_week_06.model.Gender
import androidx.appcompat.app.AlertDialog

import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var catAdapter: CatAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recycler_view)

        // Initialize Adapter with click listener
        catAdapter = CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) {
                Toast.makeText(this@MainActivity, "You clicked on ${cat.name}", Toast.LENGTH_SHORT).show()
            }
        })

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Attach swipe-to-delete
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        // Add 10 cats
        val cats = listOf(
            CatModel(Gender.Male, CatBreed.AmericanCurl, "Mochi", "Loves sleeping all day", "https://placekitten.com/200/201"),
            CatModel(Gender.Female, CatBreed.BalineseJavanese, "Luna", "Playful and talkative", "https://placekitten.com/200/202"),
            CatModel(Gender.Male, CatBreed.ExoticShorthair, "Simba", "Majestic and lazy", "https://placekitten.com/200/203"),
            CatModel(Gender.Female, CatBreed.ExoticShorthair, "Nala", "Curious and brave", "https://placekitten.com/200/204"),
            CatModel(Gender.Male, CatBreed.AmericanCurl, "Milo", "Loves snacks", "https://placekitten.com/200/205"),
            CatModel(Gender.Female, CatBreed.BalineseJavanese, "Chloe", "Loves climbing", "https://placekitten.com/200/206"),
            CatModel(Gender.Male, CatBreed.ExoticShorthair, "Oreo", "Always hungry", "https://placekitten.com/200/207"),
            CatModel(Gender.Female, CatBreed.AmericanCurl, "Cleo", "Elegant and calm", "https://placekitten.com/200/208"),
            CatModel(Gender.Male, CatBreed.ExoticShorthair, "Leo", "Energetic and loud", "https://placekitten.com/200/209"),
            CatModel(Gender.Female, CatBreed.BalineseJavanese, "Mimi", "Loves attention", "https://placekitten.com/200/210")
        )

        catAdapter.setData(cats)
    }
}
