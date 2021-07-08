package com.example.coor

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.appbar.CollapsingToolbarLayout


class ScrollingActivity : AppCompatActivity() {

    val TAG = "dlagoehd13"
    private lateinit var appBarLayout :AppBarLayout //R.id.app_bar
    lateinit var collapsingToolbarLayout : CollapsingToolbarLayout //(R.id.toolbar_layout)
    var isShow = true
    var scrollRange = -1

    @SuppressLint("ResourceType")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scrolling)
        setSupportActionBar(findViewById(R.id.toolbar))



        appBarLayout = findViewById(R.id.app_bar)
        collapsingToolbarLayout = findViewById(R.id.toolbar_layout)
        collapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.coll_toolbar_title)

        appBarLayout.addOnOffsetChangedListener(OnOffsetChangedListener { _, verticalOffset ->
            if (verticalOffset == 0) {
                // Fully expanded
                Log.d(TAG, "여기가 동작 1")
                collapsingToolbarLayout.title = "임해동입니다. 감사합니다."
                findViewById<ImageView>(R.id.back).setImageResource(R.drawable.arrow_back)
                findViewById<ImageView>(R.id.top_share).setImageResource(R.drawable.top_share)
                findViewById<ImageView>(R.id.top_hart).setImageResource(R.drawable.top_heart)
            } else {
                // Not
                Log.d(TAG, "여기가 동작 2")
                findViewById<ImageView>(R.id.back).setImageResource(R.drawable.common_back_icon)
                findViewById<ImageView>(R.id.top_share).setImageResource(R.drawable.common_back_icon)
                findViewById<ImageView>(R.id.top_hart).setImageResource(R.drawable.common_back_icon)

                collapsingToolbarLayout.title = "superDongE1" //carefull there should a space between double quote otherwise it wont work
            }
        })



    }

    override fun onResume() {
        super.onResume()

    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.menu_scrolling, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//
//        return when (item.itemId) {
//            R.id.action_back -> true
//            R.id.action_call -> true
//            R.id.action_heart -> true
//            R.id.action_share -> true
//            else -> super.onOptionsItemSelected(item)
//        }
//    }
}