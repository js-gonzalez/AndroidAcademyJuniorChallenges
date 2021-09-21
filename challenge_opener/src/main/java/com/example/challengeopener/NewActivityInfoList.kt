package com.example.challengeopener

class NewActivityInfoList {
    val list: List<NewActivityInfo> by lazy {
        List(7) { // Number of initial elements
            NewActivityInfo(
                "A new challenge example",
                "This is a challenge that will be developed soon",
                R.drawable.ic_launcher_foreground
            )
        }
    }
}
