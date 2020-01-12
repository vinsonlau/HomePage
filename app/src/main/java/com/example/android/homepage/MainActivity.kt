package com.example.android.homepage

import android.net.Uri
import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.android.homepage.ui.news_and_event.FragmentEvent
import com.example.android.homepage.ui.news_and_event.ManageEvent.EditEventRVFragment
import com.example.android.homepage.ui.news_and_event.ManageNews.EditNewsRVFragment
import com.example.android.homepage.ui.news_and_event.NewsAndEventFragment
import kotlinx.android.synthetic.main.fragment_news_and_event.*

class MainActivity : AppCompatActivity(), EditNewsRVFragment.OnFragmentInteractionListener, EditEventRVFragment.OnFragmentInteractionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_profile, R.id.navigation_location, R.id.navigation_information_centre,R.id.navigation_news_and_event
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_profile,
                R.id.navigation_location,
                R.id.navigation_information_centre,
                R.id.navigation_news_and_event,
                R.id.addNewsFragment,
                R.id.addEventFragment,
                R.id.editNewsRVFragment,
                R.id.editNewsFragment,
                R.id.editEventRVFragment,
                R.id.editEventFragment
            )
        )
        return NavigationUI.navigateUp(navController, appBarConfiguration)
    }

}
