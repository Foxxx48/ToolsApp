package com.fox.toolsapp

data class Drill(
    val title: String,
    val info: String,
    val imageResourceId: Int
) {
    override fun toString(): String {
        return title
    }
}
