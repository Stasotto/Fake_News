package com.example.fakenews.presentation.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.fakenews.R
import com.example.fakenews.data.DataSource
import com.example.fakenews.databinding.FragmentNewsPlaceBinding
import com.example.fakenews.presentation.recycler.Adapter
import com.example.fakenews.presentation.viewmodel.DataViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsPlace : Fragment(R.layout.fragment_news_place) {

    companion object {
        @JvmStatic
        fun newInstance() = NewsPlace()
    }

    private val dataSource: DataSource = DataSource()
    private val recyclerViewModel: DataViewModel by viewModel()
    private val adapterRes: Adapter by lazy { Adapter() }
    private val binding by viewBinding(FragmentNewsPlaceBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
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

            button.setOnClickListener{
                dataSource.dataList.forEach{
                    recyclerViewModel.insertNews(it)
                }
            }
            button2.setOnClickListener{
                recyclerViewModel.loadNews()
            }
        }
        recyclerViewModel.dataRecycler.observe(viewLifecycleOwner, {
            adapterRes.addNews(it)
        })
    }

    private fun initChooseFilter() {
        val filter = ChooseFilter.newInstance()
        filter.show(childFragmentManager, ChooseFilter.TAG)

        filter.setItemClickListener { typeFilter, configFilter ->
            binding.filter.text = typeFilter
            recyclerViewModel.filterNews(typeFilter, configFilter)
        }
    }
}