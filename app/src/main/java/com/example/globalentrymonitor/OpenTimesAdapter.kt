package com.example.globalentrymonitor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.globalentrymonitor.databinding.OpenTimesBinding
import com.example.globalentrymonitor.models.OpenTime
import com.example.globalentrymonitor.models.endTime
import com.example.globalentrymonitor.models.startTime
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class OpenTimesAdapter(private var times: ArrayList<OpenTime>, private var timeZone: String) :
    RecyclerView.Adapter<OpenTimesAdapter.OpenTimesViewHolder>() {

    class OpenTimesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    fun setData(newTimes: ArrayList<OpenTime>, newTimeZone: String) {
        times = newTimes
        timeZone = newTimeZone
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

        timeWindowView.text = holder.itemView.context.getString(R.string.time_slot, times[position].startTime(timeZone), times[position].endTime(timeZone))
        durationView.text = holder.itemView.context.getString(R.string.duration, times[position].duration)
    }

}