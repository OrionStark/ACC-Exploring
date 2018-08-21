package com.orionoscode.aac_explore.view
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.orionoscode.aac_explore.R
import com.orionoscode.aac_explore.viewmodel.TodoViewModel

class MainActivity : AppCompatActivity() {

    private val todoViewModel: TodoViewModel by lazy({
        ViewModelProviders.of(this).get(TodoViewModel::class.java)
    })

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

}
