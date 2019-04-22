package com.example.myapplication

enum class CustomPageEnum(val layoutRes: Int, val pageName: String) {
    A(R.layout.activity_a, "Page A"),
    B(R.layout.activity_b, "Page B")
}