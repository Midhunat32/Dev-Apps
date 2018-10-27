package com.wisilica.wisesample.ui.activity.kotlin

import android.app.Activity
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.wisilica.wisesample.R
import com.wisilica.wisesample.R.id.*
import com.wisilica.wisesample.ui.activity.OperationData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener,setRecyclerListener {

    val data: ArrayList<OperationData> = ArrayList();
    lateinit var  adapter: RecyclerAdapter
    var cout:Int = 0
    var i:Int=1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addData()
        recyclerview.layoutManager = LinearLayoutManager(this)
        adapter = RecyclerAdapter(data,this)
        adapter.setItemListener(this)
        recyclerview.adapter = adapter
        button2.setOnClickListener(this)

    }

    fun addData() {
        for (i in i..(i+9)) {
            var data2 = OperationData("" + i, "Data " + i)
            data.add(data2)
            cout = i+1
        }
        tvCount.text="Count "+(cout-1)
        i = (cout);

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.button2->{
                addData()
                adapter.getDataLater(data)
            }
        }
    }

    override fun onItemClick(view: ViewHolder, `object`: Any, position: Int) {
        val data = `object` as String
        Toast.makeText(this, data+" --", Toast.LENGTH_SHORT).show()
    }


}
