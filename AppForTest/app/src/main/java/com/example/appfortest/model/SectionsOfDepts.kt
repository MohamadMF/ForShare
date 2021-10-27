package com.example.appfortest.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

//val toppings: List<String>
data class SectionsOfDepts(
    @StringRes val sectionSrcID: Int?,
    @StringRes val subSectionSrcID: List<Int>?
)

data class IconsOfDepts(@StringRes val stringSourcesID: Int,@DrawableRes val iconSourcesID: Int)
