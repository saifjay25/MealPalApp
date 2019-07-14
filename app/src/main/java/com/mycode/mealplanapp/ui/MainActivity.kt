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
    var h
    override fun onCreate(savedInstanceState: Bundle?) {
       
    }
}
