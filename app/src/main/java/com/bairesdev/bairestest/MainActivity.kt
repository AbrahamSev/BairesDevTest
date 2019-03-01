package com.bairesdev.bairestest

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import com.bairesdev.bairestest.fragments.FragmentGithub
import com.bairesdev.bairestest.fragments.FragmentToast
import com.bairesdev.bairestest.fragments.FragmentWebView

class MainActivity : AppCompatActivity() {

    private var menuid: Int? = null
    lateinit var toolbar: Toolbar
    lateinit var drawer: DrawerLayout

    private val TAG_WEB = "WEBTAG"
    private val TAG_TOAST = "TOASTTAG"
    private val TAG_LIST = "LISTTAG"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setFragment(FragmentWebView(), TAG_WEB)

        drawer = findViewById(R.id.drawer_layout)
        drawer.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerStateChanged(p0: Int) {}

            override fun onDrawerSlide(p0: View, p1: Float) {}

            override fun onDrawerClosed(p0: View) {
                when (menuid) {
                    R.id.navitem_webview -> {
                        setFragment(FragmentWebView(), TAG_WEB)
                    }
                    R.id.navitem_toast -> {
                        setFragment(FragmentToast(), TAG_TOAST)
                    }
                    R.id.navitem_github -> {
                        setFragment(FragmentGithub(), TAG_LIST)
                    }
                }
            }

            override fun onDrawerOpened(p0: View) {}
        })
        toolbar = findViewById(R.id.toolbar)
        toolbar.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)
        val toggle = object : ActionBarDrawerToggle(this, drawer, toolbar, R.string.open, R.string.close) {
            override fun onDrawerClosed(drawerView: View) {

            }
        }
        toggle.syncState()
        val navigationView : NavigationView = findViewById(R.id.navigation_view)
        navigationView.inflateMenu(R.menu.menu)
        navigationView.setNavigationItemSelectedListener { item: MenuItem ->
            menuid = item.itemId
            drawer.closeDrawer(GravityCompat.START, true)
            true
        }
    }

    private fun setFragment(fragment: Fragment, tag: String) {
        supportFragmentManager.beginTransaction().replace(R.id.main_frame, fragment, tag)
            .addToBackStack(tag).commit()
    }




}
