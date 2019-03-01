package com.bairesdev.bairestest.objects

class RepoRes {

    var total_count: Int = 0
    var incomplete_results: Boolean = false
    var items: ArrayList<Repo> = ArrayList()

    inner class Repo {
        var id: Int = 0
        var node_id: String = ""
        var name: String = ""
        var full_name: String = ""
        var private: Boolean = false
        var fork: Boolean = false
        var owner: Owner = Owner()

        var html_url: String = ""
        var description: String = ""
        var url: String = ""
        var forks_url: String = ""
        var keys_url: String = ""
        var collaborators_url: String = ""
        var teams_url: String = ""
        var hooks_url: String = ""
        var issue_events_url: String = ""
        var events_url: String = ""
        var assignees_url: String = ""
        var branches_url: String = ""
        var tags_url: String = ""
        var blobs_url: String = ""
        var git_tags_url: String = ""
        var git_refs_url: String = ""
        var trees_url: String = ""
        var statuses_url: String = ""
        var languages_url: String = ""
        var stargazers_url: String = ""
        var contributors_url: String = ""
        var subscribers_url: String = ""
        var subscription_url: String = ""
        var commits_url: String = ""
        var git_commits_url: String = ""
        var comments_url: String = ""
        var issue_comment_url: String = ""
        var contents_url: String = ""
        var compare_url: String = ""
        var merges_url: String = ""
        var archive_url: String = ""
        var downloads_url: String = ""
        var issues_url: String = ""
        var pulls_url: String = ""
        var milestones_url: String = ""
        var notifications_url: String = ""
        var labels_url: String = ""
        var releases_url: String = ""
        var deployments_url: String = ""
        var created_at: String = ""
        var updated_at: String = ""
        var pushed_at: String = ""
        var git_url: String = ""
        var ssh_url: String = ""
        var clone_url: String = ""
        var svn_url: String = ""
        var homepage: String = ""
        var language: String = ""
        var default_branch: String = ""
        var has_issues: Boolean = false
        var has_projects: Boolean = false
        var has_downloads: Boolean = false
        var has_wiki: Boolean = false
        var has_pages: Boolean = false
        var archived: Boolean = false
        var forks: Int = 0
        var open_issues: Int = 0
        var watchers: Int = 0
        var network_count: Int = 0
        var subscribers_count: Int = 0
        var size: Int = 0
        var stargazers_count: Int = 0
        var watchers_count: Int = 0
        var open_issues_count: Int = 0
        var forks_count: Int = 0


            inner class Owner {
                var id: Int = 0
                var login: String = ""
                var node_id: String = ""
                var avatar_url: String = ""
                var gravatar_id: String = ""
                var url: String = ""
                var html_url: String = ""
                var followers_url: String = ""
                var following_url: String = ""
                var gists_url: String = ""
                var starred_url: String = ""
                var subscriptions_url: String = ""
                var organizations_url: String = ""
                var repos_url: String = ""
                var events_url: String = ""
                var received_events_url: String = ""
                var type: String = ""
                var site_admin: Boolean = false
            }
    }

}