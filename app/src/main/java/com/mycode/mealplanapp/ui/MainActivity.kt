package com.mycode.mealplanapp.ui
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager

import com.mycode.mealplanapp.R
import com.mycode.mealplanapp.adapter.RecyclerViewAdapter
import com.mycode.mealplanapp.entity.FeatureCollections
import com.mycode.mealplanapp.viewmodel.ViewModelProviderFactory
import dagger.android.support.DaggerAppCompatActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity(){
    var hello 
    var key
    sdvd
    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(R.layout.activity_main)
        recycleView.layoutManager = LinearLayoutManager(this)
        recycleView.setHasFixedSize(true)
        val viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel::class.java)
        viewModel.restaurantAPICall().observe(this, object: Observer<FeatureCollections>{
            override fun onChanged(t: FeatureCollections?) {
                if (t != null) {
                    adapter = RecyclerViewAdapter(this@MainActivity, t.getFeatures())
                    recycleView.adapter = adapter
                }
            }

        })
        override fun onCre(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recycleView.layoutManager = LinearLayoutManager(this)
        val viewModel = ViewModelProviders.of(this, providerFactory).get(MainViewModel::class.java)
        viewModel.restaurantAPICall().observe(this, object: Observer<FeatureCollections>{
            override fun onChanged(t: FeatureCollections?) {
                if (t != null) {
                    adapter = RecyclerViewAdapter(this@MainActivity, t.getFeatures())
                    recycleView.adapter = adapter
                }
            }

        })
        floating.setOnClickListener {
            composite.add(viewModel.deleteMeal().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe())
            floatingButtonPressed =true
            onChangeCounter =0
            Toast.makeText(applicationContext, "Meal reservation deleted", Toast.LENGTH_SHORT).show()
        }
    }
    var z
    var p   
    var y
}
