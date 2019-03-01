package com.bairesdev.bairestest.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.support.v4.app.Fragment
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bairesdev.bairestest.adapters.AdapterGithub
import com.bairesdev.bairestest.R
import com.bairesdev.bairestest.objects.RepoRes
import com.bairesdev.bairestest.utils.S

class FragmentGithub: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_github, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView = view.findViewById<RecyclerView>(R.id.github_reciclerview)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(context!!, LinearLayoutManager.VERTICAL, false)
        recyclerView.itemAnimator = DefaultItemAnimator()
        val adapter = AdapterGithub(
            ArrayList(),
            context!!,
            object : AdapterGithub.Delegate {
                override fun onProjectPicked(repo: RepoRes.Repo) {
                    Handler(Looper.getMainLooper()).post {
                        val intent = Intent(Intent.ACTION_VIEW)
                        intent.setData(Uri.parse(repo.html_url))
                        context!!.startActivity(intent)
                    }
                }
            })
        recyclerView.adapter = adapter
        S(context!!).getRepos(object : S.ReposDelegate {
            override fun success(repoResponse: RepoRes) {
                adapter.repos.addAll(repoResponse.items)
                adapter.notifyDataSetChanged()
            }

            override fun failure() {

            }
        })
    }

}