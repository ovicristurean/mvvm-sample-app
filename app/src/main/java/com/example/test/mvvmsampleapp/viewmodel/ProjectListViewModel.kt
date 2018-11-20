package com.example.test.mvvmsampleapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.example.test.mvvmsampleapp.service.model.Project
import com.example.test.mvvmsampleapp.service.repository.ProjectRepository

class ProjectListViewModel(application: Application) : AndroidViewModel(application) {
    private var projectListObservable: LiveData<List<Project>> = ProjectRepository.getInstance().getProjectList("Google")

    fun getProjectListObservable(): LiveData<List<Project>> {
        return projectListObservable
    }
}