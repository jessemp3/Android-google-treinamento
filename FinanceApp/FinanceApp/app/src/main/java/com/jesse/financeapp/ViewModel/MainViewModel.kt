package com.jesse.financeapp.ViewModel

import androidx.lifecycle.ViewModel
import com.jesse.financeapp.Repository.MainRepository

class MainViewModel(val respository: MainRepository): ViewModel() {
    constructor():this(MainRepository())

    fun loadData()=respository.items
}