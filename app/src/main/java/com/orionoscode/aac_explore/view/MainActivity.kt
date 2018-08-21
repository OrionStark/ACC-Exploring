package com.orionoscode.aac_explore.view
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.orionoscode.aac_explore.R
import com.orionoscode.aac_explore.utils.ViewModelFactory
import com.orionoscode.aac_explore.viewmodel.TodoViewModel
import com.orionoscode.aac_explore.viewmodel.TodoViewModelFactory
import org.jetbrains.anko.doAsync

class MainActivity : AppCompatActivity() {

    private var todoViewModel: TodoViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoViewModel = ViewModelProviders.of(this, TodoViewModelFactory(this.application)).get(TodoViewModel::class.java)
        doAsync {
            todoViewModel?.createTestData?.invoke()
        }
    }
}
