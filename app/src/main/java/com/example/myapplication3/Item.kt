package com.example.myapplication3

class Item (val firstname: String, val lastname: String) {
    override fun toString(): String {
        return this.firstname + " " + this.lastname
    }
}