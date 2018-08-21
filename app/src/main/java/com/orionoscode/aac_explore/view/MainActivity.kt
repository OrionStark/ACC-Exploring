package com.orionoscode.aac_explore.view
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.orionoscode.aac_explore.R
import com.orionoscode.aac_explore.models.Todo
import com.orionoscode.aac_explore.viewmodel.TodoViewModel
import com.orionoscode.aac_explore.utils.viewmodelfactory.TodoViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var todoViewModel: TodoViewModel? = null
    var todo: Todo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        todoViewModel = ViewModelProviders.of(this, TodoViewModelFactory(this.application)).get(TodoViewModel::class.java)
        todo = todoViewModel?.getTasks()?.value?.get(0)

        testing.setOnClickListener {
            _ ->
            todoViewModel?.changeDescription(todo!!.id, "Test Again") // Testing changing the Value
        }

        todoViewModel?.getTasks()?.observe(this, Observer<List<Todo>> {
            tasks ->
            todo = tasks?.get(0)
            task.text = tasks?.get(0)?.description
        })
    }
}
