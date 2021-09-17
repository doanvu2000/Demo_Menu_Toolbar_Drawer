package com.example.demo_menu_toolbar_drawer

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setSupportActionBar(toolbar)
        btnPopUp.setOnClickListener {
            textView.text = (textView.text.toString().toInt() + 1).toString()
            popupMenu()
        }
        toggle = ActionBarDrawerToggle(this, drawerlayout, toolbar, R.string.open, R.string.close)
        drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.drItem1 -> Toast.makeText(
                    applicationContext,
                    "Drawer header",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.item3 -> Toast.makeText(
                    applicationContext,
                    "Item3",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.item4 -> Toast.makeText(
                    applicationContext,
                    "Item4",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.item1 -> Toast.makeText(
                    applicationContext,
                    "Item1",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.item2 -> Toast.makeText(
                    applicationContext,
                    "Item2",
                    Toast.LENGTH_SHORT
                ).show()

            }
            true
        }
    }

    private fun popupMenu() {
        val popupMenu = PopupMenu(applicationContext, btnPopUp)
        popupMenu.inflate(R.menu.menu_demo2)
        popupMenu.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_item1 -> Toast.makeText(this, "item1 clicked", Toast.LENGTH_SHORT).show()
                R.id.menu_item2 -> Toast.makeText(this, "item2 clicked", Toast.LENGTH_SHORT).show()
                R.id.menu_item3 -> Toast.makeText(this, "item3 clicked", Toast.LENGTH_SHORT).show()
                R.id.menu_item4 -> Toast.makeText(this, "item4 clicked", Toast.LENGTH_SHORT).show()
            }
            true
        }
        popupMenu.show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_demo2, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_item1 -> {
                Toast.makeText(this, "Item 1 click", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_item2 -> {
                Toast.makeText(this, "Item 2 click", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_item3 -> {
                Toast.makeText(this, "Item 3 click", Toast.LENGTH_SHORT).show()
                true
            }
            R.id.menu_item4 -> {
                Toast.makeText(this, "Item 4 click", Toast.LENGTH_SHORT).show()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}