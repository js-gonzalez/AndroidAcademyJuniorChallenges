package com.example.ui_design_copy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.ui_design_copy.ui.theme.AndroidAcademyJuniorChallengesTheme

class UiDesignCopyMainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidAcademyJuniorChallengesTheme {
                ProfileScreen()
            }
        }
    }
}
