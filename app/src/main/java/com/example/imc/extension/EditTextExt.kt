package com.example.imc.extension

import android.widget.EditText

fun EditText.value() = this.text.toString()

fun EditText.valueDouble() = this.text.toString().toDouble()

fun EditText.valueInt() = this.text.toString().toInt()