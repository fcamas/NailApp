package com.example.onschedule.Adapter

import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onschedule.MainActivity
import com.example.onschedule.Model.NailModel
import com.example.onschedule.R

class NailAdapter( private val mActivity: MainActivity){

    private var mList: List<NailModel> = listOf()

    fun deletItem(position: Int) {
        val item = mList[position]
        
    }

    fun editItem(position: Int) {
        val item = mList[position]
        val bundle = Bundle().apply {
            putInt("id", item.id)
            putString("task", item.task)
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }
    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mCheckBox: CheckBox = itemView.findViewById(R.id.cell_checkbox)
        val mFullName: TextView = itemView.findViewById(R.id.cell_fullname)
        val mEmail: TextView = itemView.findViewById(R.id.cell_email)
        val mPhone: TextView = itemView.findViewById(R.id.cell_phone)
        val mTime: TextView = itemView.findViewById(R.id.cell_time)
        val mService: TextView = itemView.findViewById(R.id.cell_service)
    }

}