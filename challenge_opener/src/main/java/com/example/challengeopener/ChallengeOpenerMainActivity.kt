package com.example.challengeopener

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.viewbinding.library.activity.viewBinding
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import com.example.challengeopener.databinding.ActivityChallengeOpenerMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class ChallengeOpenerMainActivity : AppCompatActivity() {
    private val binding: ActivityChallengeOpenerMainBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myToolbar: Toolbar = binding.includeToolbarChallengeOpener.mainToolbar
        setSupportActionBar(myToolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        binding.recyclerviewChallengeActivityOpener.adapter =
            ChallengesAdapter(NewActivityInfoList().list)
        binding.includeToolbarChallengeOpener.toolbarChallengeOpenerTitle.setOnClickListener {
            binding.scrollviewChallengeActivityOpener.smoothScrollTo(0, 0)
        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        menu?.clear()
        menuInflater.inflate(R.menu.menu_challenge_opener_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_info -> {
                showInfoAlertDialog()
            }
            R.id.menu_exit -> {
                showExitAlertDialog()
            }
        }
        return true
    }

    private fun showInfoAlertDialog() =
        MaterialAlertDialogBuilder(this, R.style.AlertDialogStyleInfo)
            .setTitle(getString(R.string.alertDialog_info_title))
            .setMessage(getString(R.string.alertDialog_info_txt))
            .setPositiveButton(getString(R.string.alertDialog_info_understoodBtn_txt)) { dialog, _ -> dialog.dismiss() }
            .setCancelable(false)
            .setIcon(AppCompatResources.getDrawable(applicationContext, R.drawable.ic_info))
            .create()
            .show()

    private fun showExitAlertDialog() =
        MaterialAlertDialogBuilder(this, R.style.AlertDialogStyleCancel)
            .setTitle(getString(R.string.alertDialog_exit_title))
            .setMessage(getString(R.string.alertDialog_exit_txt))
            .setPositiveButton(getString(R.string.alertDialog_exit_accept_txt)) { dialog, _ ->
                dialog.dismiss()
                finish()
            }
            .setNeutralButton(getString(R.string.alertDialog_exit_cancel_txt)) { dialog, _ ->
                dialog.dismiss()
            }
            .setCancelable(false)
            .setIcon(AppCompatResources.getDrawable(applicationContext, R.drawable.ic_info))
            .create()
            .show()
}
