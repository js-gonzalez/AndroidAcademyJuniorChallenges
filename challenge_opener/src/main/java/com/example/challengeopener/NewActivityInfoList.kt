package com.example.challengeopener

class NewActivityInfoList {
    val list: List<NewActivityInfo> by lazy {
        mutableListOf(
            NewActivityInfo(
                R.string.ui_design_copy_title,
                R.string.ui_design_copy_description,
                R.drawable.ic_compare
            )
        )
    }
}
