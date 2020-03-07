package com.example.globalentrymonitor.viewmodels

import android.util.Log
import androidx.databinding.ObservableInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.globalentrymonitor.services.DataFetcher
import kotlinx.coroutines.Dispatchers

// Source:
// https://ttp.cbp.dhs.gov/schedulerapi/locations/?temporary=false&inviteOnly=false&operational=true&serviceName=Global%20Entry
class InterviewLocationsVm : ViewModel() {
    private val dataSource = DataFetcher() // todo: inject meeee

    var locations = liveData(Dispatchers.IO) {
        val newLocations = dataSource.getLocations()
        Log.d("APP", "Done fetching data")
        emit(newLocations)
    }

    val selectedPosition = MutableLiveData<Int>()

    fun onLocationSelected(position: Int) {
        Log.d("APP", "Selected $position")
    }
}