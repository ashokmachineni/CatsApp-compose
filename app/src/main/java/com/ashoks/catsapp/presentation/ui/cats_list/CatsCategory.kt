package com.ashoks.catsapp.presentation.ui.cats_list

enum class CatCategory(val value: String){

    ABYSSINIAN("Abyssinian"),
    AEGEAN ("Aegean"),
    AMERICANBOBTAIL("American Bobtail"),
    AMERICANCURL("American Curl"),
    AMERICANSHORTHAIR("American Shorthair"),
    PERSIAN("Persian"),
    RAGDOLL("Ragdoll"),
    PIZZA("Pizza"),
    DONUT("Donut"),
}

fun getAllCatsCategories(): List<CatCategory>{
    return listOf(CatCategory.ABYSSINIAN,
        CatCategory.AEGEAN, CatCategory.AMERICANBOBTAIL,
        CatCategory.AMERICANCURL, CatCategory.AMERICANSHORTHAIR, CatCategory.PERSIAN,
        CatCategory.RAGDOLL
    )
}

fun getCatCategory(value: String): CatCategory? {
    val map = CatCategory.values().associateBy(CatCategory::value)
    return map[value]
}