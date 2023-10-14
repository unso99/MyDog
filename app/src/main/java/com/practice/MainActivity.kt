package com.practice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.LifecycleOwner
import com.practice.databinding.ActivityMainBinding
import com.practice.repository.ImageRepositoryImpl
import com.practice.repository.InfoRepositoryImpl
import com.practice.repository.NewsRepositoryImpl

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: ViewModel by viewModels {
        ViewModel.ViewModelFactory(InfoRepositoryImpl(),ImageRepositoryImpl(),NewsRepositoryImpl())
    }

    private val imageAdapter by lazy { ImageAdapter() }
    private val newsAdapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
        binding.recyclerView.adapter = imageAdapter
        binding.newsRecyclerView.adapter = newsAdapter
        initView()
        observeViewModel()
    }

    private fun initView(){
        viewModel.loadInfo()
        viewModel.loadImage()
        viewModel.loadNews()
    }

    private fun observeViewModel(){
        viewModel.imageLiveData.observe(this){
            imageAdapter.submitList(it)
        }
        viewModel.newsLiveData.observe(this){
            newsAdapter.submitList(it)
        }
    }
}