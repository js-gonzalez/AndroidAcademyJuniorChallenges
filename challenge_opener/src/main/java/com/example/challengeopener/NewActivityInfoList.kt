package com.example.challengeopener

class NewActivityInfoList {
    val list: List<NewActivityInfo> by lazy {
        mutableListOf<NewActivityInfo>(
            NewActivityInfo(
                "UI Design Copy",
                "XML and Compose design copy challenge for a HBOMax-Profile Select Screen",
                R.drawable.ic_compare
            )
        )
    }
}
