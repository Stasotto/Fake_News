package com.example.fakenews.presentation.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fakenews.data.toNews
import com.example.fakenews.data.toNewsDomain
import com.example.fakenews.domain.NewsInteractor
import com.example.fakenews.presentation.recycler.News
import kotlinx.coroutines.launch

class DataViewModel(private val interactor: NewsInteractor) : ViewModel() {

    companion object {
        private const val DATE = "По дате"
        private const val AUTHOR = "По автору"
        private const val TOPIC = "По теме"
    }

    private var defaultNewsFromDB  = listOf<News>()


    val dataRecycler: LiveData<List<News>> get() = _dataRecycler
    private val _dataRecycler = MutableLiveData<List<News>>()

    fun loadNews() {
        viewModelScope.launch {
            _dataRecycler.value = interactor.getNews().map { newsDomain ->
                newsDomain.toNews()
            }
            defaultNewsFromDB = interactor.getNews().map { newsDomain ->
                newsDomain.toNews()
            }
        }
    }

    fun insertNews(news: News) {
        viewModelScope.launch {

            interactor.insertNews(news.toNewsDomain())
        }
    }

    fun filterNews(typeFilter: String, configFilter: String) {
        defaultNewsFromDB.filterByField(typeFilter,configFilter)
    }

    private fun List<News>?.filterByField(typeFilter: String, configFilter: String) {
        _dataRecycler.value = when (typeFilter.trimAndLow()) {
            DATE.trimAndLow() -> this?.filter { list ->
                list.date.checkStringForFilter(configFilter)
            }

            AUTHOR.trimAndLow() -> this?.filter { list ->
                list.author.checkStringForFilter(configFilter)
            }

            TOPIC.trimAndLow() -> this?.filter { list ->
                list.topic.checkStringForFilter(configFilter)
            }

            else -> this
        }
    }

    private fun String.trimAndLow() = trim().lowercase()

    private fun String.checkStringForFilter(filter: String) = trimAndLow() == filter.trimAndLow()
}