package com.example.test.mvvmsampleapp.viewmodel;

import java.util.List;
import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import com.example.test.mvvmsampleapp.service.model.Project;
import com.example.test.mvvmsampleapp.service.repository.ProjectRepository;

public class ProjectListViewModel extends AndroidViewModel {
    private final LiveData<List<Project>> projectListObservable;

    public ProjectListViewModel(Application application) {
        super(application);

        // If any transformation is needed, this can be simply done by Transformations class ...
        projectListObservable = ProjectRepository.Companion.getInstance().getProjectList("Google");
    }

    /**
     * Expose the LiveData Projects query so the UI can observe it.
     */
    public LiveData<List<Project>> getProjectListObservable() {
        return projectListObservable;
    }
}
