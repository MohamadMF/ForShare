package com.myply.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddOtherDeposit = findViewById<TextView>(R.id.btn_add_other_deposit)
        val rvCustomers = findViewById<RecyclerView>(R.id.rv_customers)
        val fabDone = findViewById<FloatingActionButton>(R.id.fab_done)

        val adapter = MyRecyclerAdapter(this, arrayListOf(CustomerModel()))
        rvCustomers.adapter = adapter
        rvCustomers.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter.mClickListener = object : MyRecyclerAdapter.ItemClickListener {
            override fun onItemRemoveClicked(position: Int) {
                adapter.removeAt(position)
            }
        }
        btnAddOtherDeposit.setOnClickListener {
            /*add empty model without information */
            adapter.add(CustomerModel())
        }
        /*fabDone.setOnClickListener {
            /*collect all data*/
            var customers = adapter.data
        }*/
    }
}