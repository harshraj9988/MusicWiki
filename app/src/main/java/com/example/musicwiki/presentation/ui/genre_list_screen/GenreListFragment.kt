package com.example.musicwiki.presentation.ui.genre_list_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentGenreListBinding
import com.example.musicwiki.network.model.Genre
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreListFragment : Fragment() {

    private lateinit var binding: FragmentGenreListBinding

    private val viewModel: GenreListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(layoutInflater, R.layout.fragment_genre_list, container, false)

        val adapter = GenreListAdapter()
        var isExpanded = false

        var fullList: List<Genre>? = null
        var initialList: List<Genre>? = null

        binding.genreListRecyclerView.layoutManager =
            GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
        binding.genreListRecyclerView.setHasFixedSize(false)
        binding.genreListRecyclerView.adapter = adapter

        viewModel.genreList.observe(viewLifecycleOwner) { list ->
            list?.let {
                fullList = list
                initialList = list.subList(0, list.size.coerceAtMost(10))
                if (isExpanded) adapter.submitList(fullList)
                else adapter.submitList(initialList)
                adapter.notifyItemRangeInserted(0, adapter.itemCount)
            }
        }

        viewModel.isExpanded.observe(viewLifecycleOwner) {
            isExpanded = it
            binding.expand.text = if(it) "shrink" else "expand"
            expandShrinkGenreList(fullList, adapter, isExpanded, initialList)
        }

        binding.expand.setOnClickListener {
            viewModel.changeExpandedState()
        }

        return binding.root
    }

    private fun expandShrinkGenreList(
        fullList: List<Genre>?,
        adapter: GenreListAdapter,
        isExpanded: Boolean,
        initialList: List<Genre>?
    ) {
        if (isExpanded) {
            fullList?.let { list ->
                submitList(adapter, list, isExpanded)
            }
        } else {
            initialList?.let { list ->
                submitList(adapter, list, isExpanded)
            }
        }
    }

    private fun submitList(adapter: GenreListAdapter, list: List<Genre>, isExpanded: Boolean) {
        adapter.submitList(list)
        if (adapter.itemCount > 0) {
            if(isExpanded){
                adapter.notifyItemRangeInserted(
                    adapter.itemCount, list.size - adapter.itemCount
                )
            } else {
                adapter.notifyItemRangeRemoved(
                    list.size, adapter.itemCount - list.size
                )
            }
        } else {
            adapter.notifyItemRangeInserted(
                0, list.size
            )
        }
    }
}
