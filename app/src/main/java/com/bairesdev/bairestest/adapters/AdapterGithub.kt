package com.bairesdev.bairestest.adapters

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bairesdev.bairestest.R
import com.bairesdev.bairestest.objects.RepoRes

class AdapterGithub(var repos: ArrayList<RepoRes.Repo>, val context: Context, val delegate: Delegate): RecyclerView.Adapter<AdapterGithub.ViewHolder>() {

	interface Delegate {
		fun onProjectPicked(repo: RepoRes.Repo)
	}

	override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
		return ViewHolder(LayoutInflater.from(context).inflate(R.layout.card_repo, parent, false))
	}

	override fun getItemCount() = repos.size

	override fun onBindViewHolder(holder: ViewHolder, position: Int) {
		val r = repos[position]
		holder.reponame.text = r.name
		holder.repofullname.text = r.full_name
	}

	inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
		val reponame = itemView.findViewById<TextView>(R.id.card_repo_name)
		val repofullname = itemView.findViewById<TextView>(R.id.card_repo_fullname)
		init {
		    itemView.setOnClickListener {
				delegate.onProjectPicked(repos[adapterPosition])
			}
		}
	}

}