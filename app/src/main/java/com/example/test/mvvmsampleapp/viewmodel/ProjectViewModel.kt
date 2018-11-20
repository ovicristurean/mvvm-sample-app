package com.example.test.mvvmsampleapp.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.databinding.ObservableField
import com.example.test.mvvmsampleapp.service.model.Project
import com.example.test.mvvmsampleapp.service.repository.ProjectRepository

class ProjectViewModel(application: Application, projectID: String) : AndroidViewModel(application) {
    private var projectObservable = ProjectRepository.getInstance().getProjectDetails("Google", projectID)

    var project = ObservableField<Project>()

    fun getObservableProject(): LiveData<Project> {
        return projectObservable
    }

    fun setProject(project: Project) {
        this.project.set(project)
    }

    /**
     * A creator is used to inject the project ID into the ViewModel
     */
    class Factory(private val application: Application, private val projectID: String) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {

            return ProjectViewModel(application, projectID) as T
        }
    }
}