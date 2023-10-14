package com.practice

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.model.Image
import com.practice.model.Info
import com.practice.model.News
import com.practice.model.NewsResponse
import com.practice.repository.ImageRepository
import com.practice.repository.InfoRepository
import com.practice.repository.NewsRepository
import io.reactivex.disposables.CompositeDisposable

class ViewModel(
    private val infoRepository: InfoRepository,
    private val imageRepository: ImageRepository,
    private val newsRepository: NewsRepository
) : ViewModel() {
    private val _countLiveData = MutableLiveData<String>()
    val countLiveData: LiveData<String> = _countLiveData

    private val _happyLiveData = MutableLiveData<String>()
    val happyLiveData: LiveData<String> = _happyLiveData

    private val _badLiveData = MutableLiveData<String>()
    val badLiveData: LiveData<String> = _badLiveData

    private val _imageLiveData = MutableLiveData<List<Image>>()
    val imageLiveData: LiveData<List<Image>> = _imageLiveData

    private val _newsLiveData = MutableLiveData<List<News>>()
    val newsLiveData: LiveData<List<News>> = _newsLiveData

    private var disposable: CompositeDisposable? = CompositeDisposable()

    fun loadInfo() {
        disposable?.add(infoRepository.getInfo()
            .subscribe { info ->
                _countLiveData.value = info.eatCount.toString()
                _happyLiveData.value = info.happyRatio.toString()
                _badLiveData.value = info.badRatio.toString()
            })
    }

    fun loadImage() {
        disposable?.add(imageRepository.getImage()
            .subscribe { info ->
                _imageLiveData.value = info.response
                Log.e("aa", info.response.toString())
            })
    }

    fun loadNews() {
        disposable?.add(newsRepository.getNews()
            .subscribe { info ->
                _newsLiveData.value = info.response
                Log.e("aa", info.response.toString())
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }

    class ViewModelFactory(
        private val infoRepository: InfoRepository,
        private val imageRepository: ImageRepository,
        private val newsRepository: NewsRepository
    ) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModel(infoRepository, imageRepository,newsRepository) as T
        }
    }


}