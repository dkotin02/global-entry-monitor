package com.example.globalentrymonitor

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.globalentrymonitor.databinding.ContentMainBinding
import com.example.globalentrymonitor.models.InterviewLocation
import com.example.globalentrymonitor.viewmodels.InterviewLocationsVm
import com.example.globalentrymonitor.viewmodels.OpenTimesViewModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*


class MainActivity : AppCompatActivity() {

    private val availableTimesVm by lazy {
        ViewModelProvider.AndroidViewModelFactory
            .getInstance(this.application)
            .create(OpenTimesViewModel::class.java)
    }

    private val locationsVm by lazy {
        ViewModelProvider.AndroidViewModelFactory
            .getInstance(this.application)
            .create(InterviewLocationsVm::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val binding: ContentMainBinding =
            DataBindingUtil.setContentView(this, R.layout.content_main)
        binding.locations = locationsVm
        binding.openTimes = availableTimesVm

        initData()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun initData() {
        Log.d( "APP", "Initializing data ...")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item)

        locationsVm.locations.observe(this, Observer { locations ->
            val cities = locations?.map { interviewLocation -> interviewLocation.name }?.sorted()
            Log.d("APP", "Found city $cities")

            adapter.addAll(cities!!)
        })

        locationDropdown.adapter = adapter

        locationsVm.selectedPosition.observe(this) {
            Log.d("APP", "Location selected: $it")
            val loc = locationsVm.locations.value?.get(it) ?: locationsVm.locations.value?.first()
            availableTimesVm.location.postValue((loc as InterviewLocation).locationCode)
        }

        availableTimesVm.times.observe(this, Observer { times ->
            times.forEach { t ->
                Log.d(
                    "APP",
                    "Found time ${t.startTimestamp} - ${t.endTimestamp}"
                )
            }
        })
    }
}
