package com.vik.memful.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.vik.memful.R
import com.vik.memful.util.CustomProgressDialog
import com.vik.memful.view.adapter.GalleryAdapter
import com.vik.memful.viewmodel.MainViewModel
import com.vik.memful.viewmodelfactory.MainViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var navController: NavController? = null
    private val mainViewModel: MainViewModel by lazy { getMainViewModel() }
    private var galleryAdapter: GalleryAdapter ? = null
    private val mProgressDialog by lazy { CustomProgressDialog(this, false) }

    @JvmName("getMainViewModel1")
    private fun getMainViewModel(): MainViewModel {
        val viewModelFactory = MainViewModelFactory(this)
        return ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navController = findNavController(R.id.nav_host_fragment)
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_pastdeliveries,
                R.id.navigation_notifications
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.itemIconTintList = null;
        
        mProgressDialog.show()
        setUpList()
        mainViewModel.getGalleryImages().observe(this, Observer {
            mProgressDialog.dismiss()
            galleryAdapter!!.setData(it.data)
        })
    }

    private fun setUpList() {
        gallery.layoutManager = StaggeredGridLayoutManager(2, RecyclerView.VERTICAL)
        galleryAdapter = GalleryAdapter()
        gallery.adapter = galleryAdapter
    }
}