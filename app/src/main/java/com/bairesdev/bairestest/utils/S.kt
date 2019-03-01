package com.bairesdev.bairestest.utils

import android.content.Context
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.bairesdev.bairestest.objects.RepoRes
import org.json.JSONObject

class S(val context: Context) {

    interface ReposDelegate {
        fun success(repoResponse: RepoRes)
        fun failure()
    }

    fun getRepos(delegate: ReposDelegate) {
        val URL = "https://api.github.com/search/repositories?q=language=kotlin"
        val request = object : JsonObjectRequest(Request.Method.GET, URL, JSONObject(), Response.Listener<JSONObject> { json ->
            delegate.success(JSON().parse(json, RepoRes::class.java) as RepoRes)
        }, Response.ErrorListener { error ->
            delegate.failure()
        }) { }
        Volley.newRequestQueue(context).add(request)
    }

}