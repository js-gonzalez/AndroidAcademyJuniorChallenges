package com.example.challengeopener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar
import com.example.challengeopener.databinding.ActivityChallengeOpenerMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ChallengeOpenerMainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityChallengeOpenerMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val myToolbar: Toolbar = binding.includeToolbarChallengeOpener.mainToolbar
        setSupportActionBar(myToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.recyclerviewChallengeActivityOpener.adapter =
            ChallengesAdapter(applicationContext,NewActivityInfoList().getList())
        binding.includeToolbarChallengeOpener.toolbarChallengeOpenerTitle.setOnClickListener {
            binding.scrollviewChallengeActivityOpener.smoothScrollTo(0,0)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.clear()
        menuInflater.inflate(R.menu.menu_challenge_opener_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.menu_info -> {showInfoAlertDialog()}
            R.id.menu_exit -> {showExitAlertDialog()}
        }
        return true
    }

    private fun showInfoAlertDialog(){
        val builder = MaterialAlertDialogBuilder(this, R.style.AlertDialogStyleInfo)
        val dialog = builder.setTitle(getString(R.string.alertdg_info_title))
            .setMessage(getString(R.string.alertdg_info_txt))
            .setPositiveButton(getString(R.string.alertdg_info_understoodbtn_txt)) {dialog, _ ->
                dialog.dismiss()
            }.setCancelable(false).setIcon(getDrawable(R.drawable.ic_info)).create()

        dialog.show()
    }
    private fun showExitAlertDialog(){
        val builder = MaterialAlertDialogBuilder(this, R.style.AlertDialogStyleCancel)
        val dialog = builder.setTitle(getString(R.string.alertdg_exit_title))
            .setMessage(getString(R.string.alertdg_exit_txt))
            .setPositiveButton(getString(R.string.alertdg_exit_accept_txt)) {dialog, _ ->
                dialog.dismiss()
                finish()
            }
            .setNeutralButton(getString(R.string.alertdg_exit_cancel_txt)) {dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .setIcon(getDrawable(R.drawable.ic_info)).create()
        dialog.show()
    }
}