package com.example.jkfb_webrecyclerview

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), WebsiteAdapter.OnItemClickListener {

    private val websites = listOf(
        Website("YouTube", "https://www.youtube.com"),
        Website("Google Maps", "https://www.google.com/maps"),
        Website("Wikimapia", "https://www.wikimapia.org"),
        Website("OpenStreetMap", "https://www.openstreetmap.org"),
        Website("Facebook", "https://www.facebook.com"),
        Website("TikTok", "https://www.tiktok.com"),
        Website("Instagram", "https://www.instagram.com"),
        Website("Twitter", "https://www.twitter.com")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = WebsiteAdapter(websites, this)
    }

    override fun onItemClick(website: Website) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(website.url))
        startActivity(intent)
    }
}
