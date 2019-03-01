package com.bairesdev.bairestest.utils

import com.google.gson.Gson
import org.json.JSONObject

class JSON {

    val gson: Gson = Gson()

    fun parse(json: JSONObject, _class: Class<*>): Any? {
        try {
            return gson.fromJson(json.toString(), _class)
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

}