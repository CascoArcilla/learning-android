package com.cascoArcilla.courseadroid.takstodo

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cascoArcilla.courseadroid.R
import com.cascoArcilla.courseadroid.takstodo.ToDoCategory.*
import com.cascoArcilla.courseadroid.takstodo.categorylist.CategoryAdapter
import com.cascoArcilla.courseadroid.takstodo.taskslist.TasksAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class TasksToDoActivity : AppCompatActivity() {
    private val categories = listOf<ToDoCategory>(
        Personal,
        Business,
        Other
    )

    private val tasks = mutableListOf<ToDoTask>(
        ToDoTask("PruebaBusiness", Business),
        ToDoTask("PruebaPersonal", Personal),
        ToDoTask("PruebaOther", Other)
    )

    private lateinit var rvToDoCategory: RecyclerView
    private lateinit var rvToDoTasks: RecyclerView

    private lateinit var categoryAdapter: CategoryAdapter
    private lateinit var tasksAdapter: TasksAdapter

    private lateinit var fbtAddTask: FloatingActionButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tasks_to_do)
        initComponents()
        addListeners()
        initUI()
    }

    private fun initComponents() {
        rvToDoCategory = findViewById(R.id.rvToDoCategorys)
        rvToDoTasks = findViewById(R.id.rvToDoTasks)
        fbtAddTask = findViewById(R.id.fbtAddTask)
    }

    private fun addListeners() {
        fbtAddTask.setOnClickListener { displayDialog() }
    }

    private fun displayDialog() {
        val dialogCreateTask = Dialog(this)
        dialogCreateTask.setContentView(R.layout.dialog_add_task)

        val buttonAddTask: Button = dialogCreateTask.findViewById(R.id.btnDialogAddTask)
        val edithText: EditText = dialogCreateTask.findViewById(R.id.etDialogTaskText)
        val rgCategory: RadioGroup = dialogCreateTask.findViewById(R.id.rgDialogCategory)

        buttonAddTask.setOnClickListener {
            if (edithText.text.toString().isNotEmpty()) {
                val checkRadiobuttonId = rgCategory.checkedRadioButtonId
                val radioButtonCheck: RadioButton =
                    dialogCreateTask.findViewById(checkRadiobuttonId)
                val checkCategory: ToDoCategory = when (radioButtonCheck.text) {
                    getString(R.string.todo_dialog_radio_personal) -> Personal
                    getString(R.string.todo_dialog_radio_business) -> Business
                    else -> Other
                }

                tasks.add(ToDoTask(edithText.text.toString(), checkCategory))
                updateTasks()
                dialogCreateTask.hide()
            }

            dialogCreateTask.show()
        }
    }

    private fun initUI() {
        categoryAdapter = CategoryAdapter(categories)
        rvToDoCategory.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvToDoCategory.adapter = categoryAdapter

        tasksAdapter = TasksAdapter(tasks) { position -> onItemSelected(position) }
        rvToDoTasks.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rvToDoTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTasks()
    }

    private fun updateTasks() {
        tasksAdapter.notifyDataSetChanged()
    }
}