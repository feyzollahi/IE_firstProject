package Repo;

import Project.Project;

import java.util.HashMap;

public class ProjectsRepo {
    private static ProjectsRepo singleProjectsRepo = null;
    private ProjectsRepo(){
        this.projects = new HashMap<String, Project>();
    }
    public static ProjectsRepo getInstance(){
        if(singleProjectsRepo == null)
            singleProjectsRepo = new ProjectsRepo();
        return singleProjectsRepo;
    }
    private HashMap<String, Project> projects;
    public Project getProjectById(String id){
        return this.projects.get(id);
    }
    public void addProject(Project project){
        this.projects.put(project.getId(), project);
    }
}
