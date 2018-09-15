package com.android4dev.navigationview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentTransaction
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import com.android4dev.navigationview.fragment.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigationview_header.view.*


class NavigationViewActivity : AppCompatActivity() {

    var navigationPosition: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        setSupportActionBar(toolbar)
        setUpDrawerLayout()

        //Load Inbox fragment first
        navigationPosition = R.id.navItemInbox
        navigateToFragment(InboxFragment.newInstance())
        navigationView.setCheckedItem(navigationPosition)
        toolbar.title = getString(R.string.inbox)

        navigationView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navItemInbox -> {
                    toolbar.title = getString(R.string.inbox)
                    navigationPosition = R.id.navItemInbox
                    navigateToFragment(InboxFragment.newInstance())
                }
                R.id.navItemSent -> {
                    toolbar.title = getString(R.string.sent)
                    navigationPosition = R.id.navItemSent
                    navigateToFragment(SentFragment.newInstance())
                }
                R.id.navItemDraft -> {
                    toolbar.title = getString(R.string.draft)
                    navigationPosition = R.id.navItemDraft
                    navigateToFragment(DraftFragment.newInstance())
                }
                R.id.navItemTrash -> {
                    toolbar.title = getString(R.string.trash)
                    navigationPosition = R.id.navItemTrash
                    navigateToFragment(TrashFragment.newInstance())
                }
                R.id.navItemSettings -> {
                    toolbar.title = getString(R.string.settings)
                    navigationPosition = R.id.navItemSettings
                    navigateToFragment(SettingsFragment.newInstance())
                }
            }
            // set item as selected to persist highlight
            menuItem.isChecked = true
            // close drawer when item is tapped
            drawerLayout.closeDrawers()
            true
        }

        //Change navigation header information
        changeNavigationHeaderInfo()

        drawerLayout.addDrawerListener(object:DrawerLayout.DrawerListener{
            override fun onDrawerStateChanged(p0: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDrawerSlide(p0: View, p1: Float) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDrawerClosed(p0: View) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDrawerOpened(p0: View) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        })
    }

    private fun changeNavigationHeaderInfo() {
        val headerView = navigationView.getHeaderView(0)
        headerView.textEmail.text = "lokeshdesai@android4dev.com"
    }

    private fun setUpDrawerLayout() {
        val toggle = ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.drawerOpen, R.string.drawerClose)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
    }

    private fun navigateToFragment(fragmentToNavigate: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragmentToNavigate)
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
        fragmentTransaction.addToBackStack(null)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {

        if (drawerLayout.isDrawerOpen(Gravity.START)) {
            drawerLayout.closeDrawer(Gravity.START)
        }

        if (navigationPosition == R.id.navItemInbox) {
            finish()
        } else {
            //Navigate to Inbox Fragment
            navigationPosition = R.id.navItemInbox
            navigateToFragment(InboxFragment.newInstance())
            navigationView.setCheckedItem(navigationPosition)
            toolbar.title = getString(R.string.inbox)
        }
    }

}
