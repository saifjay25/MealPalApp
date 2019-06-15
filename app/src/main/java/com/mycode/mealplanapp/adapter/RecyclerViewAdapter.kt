package com.mycode.mealplanapp.adapter

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import com.mycode.mealplanapp.R
import com.mycode.mealplanapp.entity.Features
import com.mycode.mealplanapp.ui.MainViewModel
import com.squareup.picasso.Picasso
import com.mycode.mealplanapp.viewmodel.ViewModelProviderFactory
import javax.inject.Inject
import androidx.lifecycle.ViewModelProviders
import com.mycode.mealplanapp.entity.Meal
import com.mycode.mealplanapp.ui.MainActivity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RecyclerViewAdapter (con: Context, result: List<Features>) : RecyclerView.Adapter<RecyclerViewAdapter.viewHolder>() {

    private var cons:Context = con
    private lateinit var alertDialog : AlertDialog.Builder
    private val mDisposable = CompositeDisposable()
    private lateinit var v: View
    private var list : List<Features> = result
    var providerFactory: ViewModelProviderFactory? = null
        @Inject set
    var viewModel = ViewModelProviders.of(cons as MainActivity, providerFactory).get(MainViewModel::class.java)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        v = LayoutInflater.from(cons).inflate(R.layout.rowlayout, parent, false)
        return viewHolder(v)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val feature : Features = list[position]
        holder.setIsRecyclable(false)
        holder.restaurant.text = "Restaurant: "+feature.getRestaurant().getRestaurantName()
        holder.mealName.text =  "Meal: "+feature.getMeal().getMealName()
        Picasso.get().load(feature.getMeal().getMealImage()).into(holder.image)
        holder.order.setOnClickListener {
            MainActivity.floatingButtonPressed = false
            MainActivity.onChangeCounter = 0
           viewModel.getMeal().observe(cons as MainActivity, object : Observer<Meal>{
               override fun onChanged(t: Meal?) {
                   if(!MainActivity.floatingButtonPressed && MainActivity.onChangeCounter==0) {
                       if (t == null) {
                           MainActivity.onChangeCounter++
                           mDisposable.add(
                               viewModel.insertMeal(feature.getMeal())
                                   .subscribeOn(Schedulers.io())
                                   .observeOn(AndroidSchedulers.mainThread())
                                   .subscribe()
                           )
                           alertDialog = AlertDialog.Builder(v.rootView.context)
                           alertDialog.setMessage(feature.getMeal().getMealName()+ " is reserved")
                           alertDialog.setTitle("Success")
                           alertDialog.show()
                       } else {
                           alertDialog = AlertDialog.Builder(v.rootView.context)
                           alertDialog.setMessage(t.getMealName()+" is already reserved")
                           alertDialog.setTitle("Error")
                           alertDialog.show()
                       }
                   }
               }
           })
        }
    }

    inner class viewHolder(item: View) : RecyclerView.ViewHolder(item){
        var mealName: TextView
        var restaurant: TextView
        var image : ImageView
        var order : Button
        init {
            mealName= item.findViewById(R.id.mealName)
            restaurant = item.findViewById(R.id.restaurant)
            image = item.findViewById(R.id.image)
            order = item.findViewById(R.id.order)
        }
    }
}