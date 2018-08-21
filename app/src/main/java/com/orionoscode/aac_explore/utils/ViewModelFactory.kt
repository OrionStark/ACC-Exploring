package com.orionoscode.aac_explore.utils

import android.app.Application
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.orionoscode.aac_explore.viewmodel.TodoViewModel

class ViewModelFactory(private val application: Application) : ViewModelProvider.NewInstanceFactory() {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return TodoViewModel(application) as T
    }
}