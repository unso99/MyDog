package com.practice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.practice.model.Image
import com.practice.model.Info
import com.practice.model.NewsResponse
import com.practice.repository.InfoRepository
import io.reactivex.disposables.CompositeDisposable

class ViewModel(private val infoRepository: InfoRepository) : ViewModel() {
    private val _countLiveData = MutableLiveData<String>()
    val countLiveData: LiveData<String> = _countLiveData

    private val _happyLiveData = MutableLiveData<String>()
    val happyLiveData: LiveData<String> = _happyLiveData

    private val _badLiveData = MutableLiveData<String>()
    val badLiveData: LiveData<String> = _badLiveData

    private var disposable: CompositeDisposable? = CompositeDisposable()

    fun loadInfo() {
        disposable?.add(infoRepository.getInfo()
            .subscribe { info ->
                _countLiveData.value = info.eatCount.toString()
                _happyLiveData.value = info.happyRatio.toString()
                _badLiveData.value = info.badRatio.toString()
            })
    }

    override fun onCleared() {
        super.onCleared()
        disposable?.dispose()
        disposable = null
    }

    class ViewModelFactory(private val infoRepository: InfoRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return ViewModel(infoRepository) as T
        }
    }


}