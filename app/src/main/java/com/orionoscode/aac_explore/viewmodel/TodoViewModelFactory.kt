package com.orionoscode.aac_explore.viewmodel

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

class TodoViewModelFactory(private val mapplication: Application) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodoViewModel(mapplication) as T
    }
}