package com.albnaapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class SectionsOfDepts(
    @StringRes val sectionSrcID: Int,
    val subSectionSrcID: List<SubSectionsOfDepts>
)

data class SubSectionsOfDepts(
    //@DrawableRes val iconSourcesID: Int,
    @StringRes val subSectionSrcID: Int
)

data class ClientDepositData(
    var code: Int? = 0,
    var amount: Int? = 0,
    var depositType: String? = null,
    var aboutClient: String? = null
)

data class OrderDetails(
    var qty: Int? = 0,
    var price: Int? = 0,
    var item: List<String>? = null,
    var type: List<String>? = null,
    var color: List<String>? = null
)
