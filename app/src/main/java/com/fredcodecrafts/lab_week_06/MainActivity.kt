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
            CatModel(Gender.Male, CatBreed.AmericanCurl, "Mochi", "Loves sleeping all day", "https://cdn2.thecatapi.com/images/7dj.jpg"),
            CatModel(Gender.Female, CatBreed.BalineseJavanese, "Luna", "Playful and talkative", "https://cdn2.thecatapi.com/images/egv.jpg"),
            CatModel(Gender.Male, CatBreed.ExoticShorthair, "Simba", "Majestic and lazy", "https://cdn2.thecatapi.com/images/bar.jpg"),
            CatModel(Gender.Female, CatBreed.ExoticShorthair, "Nala", "Curious and brave", "https://cdn2.thecatapi.com/images/9z6.jpg"),
            CatModel(Gender.Male, CatBreed.AmericanCurl, "Milo", "Loves snacks", "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
            CatModel(Gender.Female, CatBreed.BalineseJavanese, "Chloe", "Loves climbing", "https://cdn2.thecatapi.com/images/b1d.jpg"),
            CatModel(Gender.Male, CatBreed.ExoticShorthair, "Oreo", "Always hungry", "https://cdn2.thecatapi.com/images/d3j.jpg"),
            CatModel(Gender.Female, CatBreed.AmericanCurl, "Cleo", "Elegant and calm", "https://cdn2.thecatapi.com/images/9k5.jpg"),
            CatModel(Gender.Male, CatBreed.ExoticShorthair, "Leo", "Energetic and loud", "https://cdn2.thecatapi.com/images/1hg.jpg"),
            CatModel(Gender.Female, CatBreed.BalineseJavanese, "Mimi", "Loves attention", "https://cdn2.thecatapi.com/images/2hv.jpg")
        )


        catAdapter.setData(cats)
    }
}
