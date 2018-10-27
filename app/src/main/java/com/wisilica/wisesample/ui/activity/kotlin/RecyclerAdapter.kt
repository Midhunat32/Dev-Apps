package com.wisilica.wisesample.ui.activity.kotlin

import android.content.Context
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.system.Os.bind
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.wisilica.wisesample.R
import com.wisilica.wisesample.ui.activity.OperationData
import kotlinx.android.synthetic.main.rv_scan_device_list_item.view.*

class RecyclerAdapter(var data: ArrayList<OperationData>, val context: Context) : RecyclerView.Adapter<ViewHolder>(){
    var listner: setRecyclerListener? = null
    var dataItem: OperationData? = null

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.rv_scan_device_list_item, viewGroup, false))
    }

    fun setItemListener(listener: setRecyclerListener) {
        this.listner = listener
    }
    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, postion: Int) {
        dataItem = data.get(postion)
        viewHolder.tvDeviceName?.text = data.get(postion).top
        viewHolder.tv_uuid?.text = data.get(postion).type
        viewHolder.cvDevice.setOnClickListener {
            listner?.onItemClick(viewHolder,data.get(postion).top,postion)
        }
    }


    fun getDataLater(data: ArrayList<OperationData>) {
        this.data = data;
        notifyDataSetChanged()
    }



}


class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val tvDeviceName = view.tv_deviceName
    val tv_uuid = view.tv_uuid
    val cvDevice = view.cvDevice

    }

