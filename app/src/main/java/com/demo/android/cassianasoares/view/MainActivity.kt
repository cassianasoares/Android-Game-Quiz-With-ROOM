package com.demo.android.cassianasoares.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.Toast
import com.demo.android.cassianasoares.R
import com.demo.android.cassianasoares.data.Repository
import com.demo.android.cassianasoares.viewModel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val viewModel by lazy { MainViewModel(Repository()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_options_main.setOnClickListener {

            val popupMenu: PopupMenu = PopupMenu(applicationContext, btn_options_main)
            popupMenu.menuInflater.inflate(R.menu.menu_main_activity, popupMenu.menu)

            popupMenu.setOnMenuItemClickListener { item ->
                when(item!!.itemId){
                    R.id.prepopulate -> prepopulateQuestions()
                    R.id.clear -> clearQuestions()
                    else -> Toast.makeText(applicationContext, "error", Toast.LENGTH_SHORT).show()
                }
                false
            }
            popupMenu.show()
        }
    }

    private fun prepopulateQuestions() = viewModel.prepopulateQuestions()

    private fun clearQuestions() = viewModel.clearQuestions()

/*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main_activity, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.prepopulate -> prepopulateQuestions()
            R.id.clear -> clearQuestions()
            else -> Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }*/

    fun startPlay(view: View) {
        startActivity(Intent(this, QuestionActivity::class.java))
    }

}
