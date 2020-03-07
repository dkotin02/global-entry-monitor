package com.example.globalentrymonitor.viewmodels

import androidx.lifecycle.*
import com.example.globalentrymonitor.models.InterviewLocation
import com.example.globalentrymonitor.services.DataFetcher
import kotlinx.coroutines.Dispatchers

class OpenTimesViewModel : ViewModel() {
    private val dataSource = DataFetcher() // todo: inject meeee

    val location = MutableLiveData<InterviewLocation>()

    var times = location.switchMap { loc ->
        liveData(Dispatchers.IO) {
            val openTimes = dataSource.getTimes(loc!!.id.toString())
            emit(openTimes)
        }
    }
}