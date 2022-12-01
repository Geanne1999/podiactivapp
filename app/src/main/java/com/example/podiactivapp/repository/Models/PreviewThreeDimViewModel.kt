package com.example.podiactivapp.repository.Models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PreviewThreeDimViewModel: ViewModel() {

    private val repository: ThreeDimRepository
    private val _allPreviews = MutableLiveData<List<PreviewThreeDimModel>>()
    val allPreviews: LiveData<List<PreviewThreeDimModel>> = _allPreviews

    init {
        repository = ThreeDimRepository().getInstance()
        repository.load3dPhotos(_allPreviews)
    }
}