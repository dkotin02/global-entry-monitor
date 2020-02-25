package com.example.globalentrymonitor

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.globalentrymonitor.databinding.OpenTimesBinding
import com.example.globalentrymonitor.models.OpenTime

class OpenTimesAdapter(private var times: ArrayList<OpenTime>) :
    RecyclerView.Adapter<OpenTimesAdapter.OpenTimesViewHolder>() {

    class OpenTimesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun setData(newTimes: ArrayList<OpenTime>) {
        times = newTimes
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OpenTimesViewHolder {

        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.open_times, parent, false)

        DataBindingUtil.bind<OpenTimesBinding>(layout)
        return OpenTimesViewHolder(layout)
    }

    override fun getItemCount(): Int {
        return times.size
    }

    override fun onBindViewHolder(holder: OpenTimesViewHolder, position: Int) {
        val timeWindowView = holder.itemView.findViewById<TextView>(R.id.timeWindow)
        val durationView = holder.itemView.findViewById<TextView>(R.id.duration)

        timeWindowView.text = holder.itemView.context.getString(R.string.time_slot, times[position].startTimestamp, times[position].endTimestamp)
        durationView.text = holder.itemView.context.getString(R.string.duration, times[position].duration)
    }



}