package com.example.fakenews.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fakenews.domain.NewsInteractor
import com.example.fakenews.presentation.recycler.News

class DataViewModel(private val interactor: NewsInteractor) : ViewModel() {
    companion object {
        private const val NO_FILTER = "Без фильтра"
        private const val DATE = "По дате"
        private const val AUTHOR = "По автору"
        private const val TOPIC = "По теме"

    }


    val dataRecycler: LiveData<List<News>> get() = _dataRecycler
    private val _dataRecycler = MutableLiveData(interactor.loadNews())

    fun filterNews(typeFilter: String, configFilter: String) {
        val config = configFilter.trim().lowercase()
        println(typeFilter)
        when (typeFilter.trim().lowercase()) {

           // Resources.getSystem().getString(R.string.айдишник) но выдавало ошибку
            //Resources$NotFoundException

            NO_FILTER.trim().lowercase() -> _dataRecycler.value = interactor.loadNews()

            DATE.trim().lowercase() ->
                setDateFilteredList(
                    _dataRecycler.value,
                    config
                )
            AUTHOR.trim().lowercase() ->
                setAuthorFilteredList(
                    _dataRecycler.value,
                    config
                )
            TOPIC.trim().lowercase() ->
                setTopicFilteredList(
                    _dataRecycler.value,
                    config
                )
        }
    }
    // как можно это улучшить?
    private fun setDateFilteredList(dataListForFilter: List<News>?, configFilter: String) {
        println(configFilter)
        println("her")
        val filteredList = dataListForFilter?.filter { list ->
            list.date.trim().lowercase() == configFilter
        }
        _dataRecycler.value = filteredList
    }

    private fun setAuthorFilteredList(dataListForFilter: List<News>?, configFilter: String) {
        println(configFilter)
        println("her")
        val filteredList = dataListForFilter?.filter { list ->
            list.author.trim().lowercase() == configFilter
        }
        _dataRecycler.value = filteredList
    }

    private fun setTopicFilteredList(dataListForFilter: List<News>?, configFilter: String) {
        println(configFilter)
        println("her")
        val filteredList = dataListForFilter?.filter { list ->
            list.topic.trim().lowercase() == configFilter
        }
        _dataRecycler.value = filteredList
    }
}