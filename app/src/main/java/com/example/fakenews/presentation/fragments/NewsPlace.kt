package com.example.fakenews.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fakenews.R
import com.example.fakenews.databinding.FragmentNewsPlaceBinding
import com.example.fakenews.presentation.recycler.Adapter
import com.example.fakenews.presentation.recycler.News
import com.example.fakenews.presentation.viewmodel.DataModel

class NewsPlace : Fragment() {

    private val datModel: DataModel by lazy { DataModel() }
    private val adapterRes: Adapter by lazy { Adapter() }
    private lateinit var binding: FragmentNewsPlaceBinding
    private var listForFilter: List<News> = mutableListOf()
    private var config: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_news_place, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsPlaceBinding.bind(view)
        initRecycler()
    }

    private fun initRecycler() {

        binding.apply {
            recycler.apply {
                adapter = adapterRes
                layoutManager = LinearLayoutManager(requireContext())
            }
            filter.setOnClickListener {
                initChooseFilter()
            }
        }

        datModel.dataRecycler.observe(viewLifecycleOwner, { dataList ->
            adapterRes.addNews(dataList)
            listForFilter = dataList
        })
        filterNews()
    }

    private fun filterNews() {
        datModel.typeAndConfigurationFilter.observe(
            viewLifecycleOwner,
            { typeAndConfiguration ->
                config = typeAndConfiguration[1].trim().lowercase()
                when (typeAndConfiguration.first().trim().lowercase()) {
                    getString(R.string.No_filter).trim()
                        .lowercase() -> adapterRes.addNews(listForFilter)
                    getString(R.string.date).trim().lowercase() -> getDateFilteredList(
                        listForFilter
                    )
                    getString(R.string.name).trim().lowercase() -> getAuthorFilteredList(
                        listForFilter
                    )
                    getString(R.string.topic).trim().lowercase() -> getTopicFilteredList(
                        listForFilter
                    )
                }
            }
        )
    }

    private fun getDateFilteredList(dataListForFilter: List<News>) {
        val filteredList = dataListForFilter.filter { list ->
            list.date.trim().lowercase() == config
        }
        adapterRes.addNews(filteredList)
    }

    private fun getAuthorFilteredList(dataListForFilter: List<News>) {
        val filteredList = dataListForFilter.filter { list ->
            list.author.trim().lowercase() == config
        }
        adapterRes.addNews(filteredList)
    }

    private fun getTopicFilteredList(dataListForFilter: List<News>) {
        val filteredList = dataListForFilter.filter { list ->
            list.topic.trim().lowercase() == config
        }
        adapterRes.addNews(filteredList)
    }

    companion object {
        @JvmStatic
        fun newInstance() = NewsPlace()
    }

    private fun initChooseFilter() {
        val filter = ChooseFilter.newInstance()
        filter.show(childFragmentManager, ChooseFilter.TAG)

        filter.setItemClickListener { typeFilter, configFilter ->
            binding.filter.text = typeFilter
            datModel.typeAndConfigurationFilter.value = listOf(typeFilter, configFilter)
        }
    }
}