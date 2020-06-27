package com.elfalt.ledo.ui

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.elfalt.ledo.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class HomeScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)


        openFragment(Home.newInstance())

        val bottomNavigation: BottomNavigationView = findViewById(R.id.btn_nav)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val sharedPref = getSharedPreferences("settings", Context.MODE_PRIVATE)
        val mindMappingCourse = sharedPref.getBoolean("mind_mapping_course", false)
        val cardPersonalCourse = sharedPref.getBoolean("card_personal_course", false)

    }



    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {

                    val home = Home.newInstance()
                    openFragment(home)

                    return@OnNavigationItemSelectedListener true
                }
                R.id.search -> {

                    val search  = SearchFragment.newInstance()
                    openFragment(search)

                    return@OnNavigationItemSelectedListener true
                }
                R.id.graph -> {


                    val leaderboard =
                        Leaderboard.newInstance()
                    openFragment(leaderboard)

                    return@OnNavigationItemSelectedListener true

                }
                R.id.user -> {

                    val user: Users = Users.newInstance()
                    openFragment(user)

                    return@OnNavigationItemSelectedListener true
                }

            }
            false
        }

    private fun openFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout, fragment)
        transaction.addToBackStack(null)
        transaction.commit()

    }


}
