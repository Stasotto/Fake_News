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
import com.example.fakenews.presentation.viewmodel.DataViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsPlace : Fragment() {

    private val recyclerViewModel: DataViewModel by viewModel()
    private val adapterRes: Adapter by lazy { Adapter() }
    private lateinit var binding: FragmentNewsPlaceBinding

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

        recyclerViewModel.dataRecycler.observe(viewLifecycleOwner, { dataList ->
            adapterRes.addNews(dataList)
        })
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
            recyclerViewModel.filterNews(typeFilter, configFilter)
        }
    }
}