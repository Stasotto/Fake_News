package com.example.fakenews.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fakenews.data.DataSource
import com.example.fakenews.domain.NewsInteractor
import com.example.fakenews.presentation.recycler.News

class DataModel : ViewModel() {

    val typeAndConfigurationFilter: MutableLiveData<List<String>> by lazy { MutableLiveData<List<String>>() }

    private val interactor: NewsInteractor = DataSource()

    val dataRecycler: LiveData<List<News>> get() = _dataRecycler
    private val _dataRecycler = MutableLiveData(interactor.loadNews())

//    fun setFilter(filter:String) {
//        _dataRecycler.value = filter
//    }
}