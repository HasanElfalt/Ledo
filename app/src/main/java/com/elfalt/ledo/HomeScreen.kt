package com.elfalt.ledo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.fragment_leaderboard.*

class HomeScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)


        openFragment(HomeScrolled.newInstance())

        val bottomNavigation: BottomNavigationView = findViewById(R.id.btn_nav)
        bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)



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

                    return@OnNavigationItemSelectedListener true
                }
                R.id.graph -> {


                    val leaderboard =Leaderboard.newInstance()
                    openFragment(leaderboard)

                    return@OnNavigationItemSelectedListener true

                }
                R.id.profile -> {

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
