package com.example.ui_design_copy

class ProfileSelectInfoData {
    companion object {
        private val imgBorderColors = listOf(
            listOf(R.color.pink_loudicious, R.color.violet_gonzo),
            listOf(R.color.purple_ilicit, R.color.purple_normal),
            listOf(R.color.blue_jordy, R.color.blue_dark),
            listOf(R.color.magenta_lavender, R.color.pink_shocking),
        )
        private val imgSources = listOf(
            "https://depor.com/resizer/X-xln6YiQqyEk2ddaDqZuQw9Ynw=/1200x1200/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/Q7AHXEQYA5C7NMIDBAIN4H57O4.png",
            "http://assets.stickpng.com/images/5c80fb9272f5d9028c17ed5f.png",
            "https://cdn.gamer-network.net/2015/articles/1/8/4/3/8/4/6/-1468668222321.jpg/EG11/thumbnail/1920x1277/format/jpg/quality/80",
            "https://seriestation.com/wp-content/uploads/Metal-Gear-Solid-Movie-Oscar-Isaac-Solid-Snake.jpg",
            "https://bysperfeccionoral.com/wp-content/uploads/2020/01/136-1366211_group-of-10-guys-login-user-icon-png.jpg",
            "https://bysperfeccionoral.com/wp-content/uploads/2020/01/136-1366211_group-of-10-guys-login-user-icon-png.jpg",
            "https://yt3.ggpht.com/ytc/AKedOLRHtlYUfKRGpaVbGFvz8w2M8r91QToE7kk_n2Hgnw=s900-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AKedOLTMbVWq7iyGKn0_tjLfO_PXGpX-Lodz2lyZpSeN-A=s900-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AKedOLRCs6kX8F6yKOrma8j2P-MIyezthSLWxcvpPAvCVQ=s900-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AKedOLSQacj0rCD-LjtaWdvzH50pCdvBGLhLq8UtI_Y2DA=s900-c-k-c0x00ffffff-no-rj",
            "https://yt3.ggpht.com/ytc/AKedOLT8ES1awh9RNYzb4Hs6CHJcbbyJHsTxtIMsm4bexQ=s900-c-k-c0x00ffffff-no-rj"
        )
        private val userNames = listOf(
            "Eren",
            "Finn & Jake",
            "Snake Eater",
            "Solid Snake",
            "Malvin",
            "A kid",
            "Real Engineering",
            "Suibhne",
            "El Robot de Platon",
            "Android Developers",
            "Cosmic Skeptic"
        )
        private val kidProfiles =
            listOf(false, true, false, false, true, true, false, false, true, true, false)
    }

    operator fun invoke() =
        kidProfiles.mapIndexed { i, b ->
            ProfileSelectInfo(
                imgSources[i], imgBorderColors[i % imgBorderColors.size], userNames[i], b
            )
        }.shuffled()
}
