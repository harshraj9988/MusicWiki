package com.example.musicwiki.presentation.ui.genre_info_screen

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.viewModels
import com.example.musicwiki.R
import com.example.musicwiki.databinding.FragmentGenreInfoBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GenreInfoFragment : Fragment() {

    private lateinit var binding: FragmentGenreInfoBinding
    private lateinit var args: GenreInfoFragmentArgs
    private val viewModel: GenreInfoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(layoutInflater, R.layout.fragment_genre_info, container, false)

        args = GenreInfoFragmentArgs.fromBundle(requireArguments())

        if(args.genre!=null) {
            viewModel.getGenreInfo(args.genre)
        }else{
            Toast.makeText(context, "Error! Please try again", Toast.LENGTH_SHORT).show()
        }

        val pagerAdapter = PagerAdapter( this , viewModel)
        binding.viewPager.adapter = pagerAdapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text =  pagerAdapter.getPageTitle(position)
        }.attach()

        viewModel.genreInfo.observe(viewLifecycleOwner) {
            it?.let {
                binding.genre = it
                binding.invalidateAll()
            }
        }

        return binding.root
    }



}
