package com.example.classlead.data

import com.example.classlead.R
import com.example.classlead.model.grouppackage

class datasource() {
    fun loadgrouppackages():List<grouppackage>{
        return listOf<grouppackage>(
            grouppackage(R.string.dopeone,R.drawable.batman),
            grouppackage(R.string.dopetwo,R.drawable.eren),
            grouppackage(R.string.dopethree,R.drawable.goku),
            grouppackage(R.string.dopefour,R.drawable.mma1),
            grouppackage(R.string.dopefive,R.drawable.m4lights),

        )
    }
}