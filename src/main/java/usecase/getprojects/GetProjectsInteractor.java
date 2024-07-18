package usecase.getprojects;

import dataaccess.DAOImplementationConfig;
import dataaccess.ILoginUserDetails;
import dataaccess.IProjectRepository;
import dataaccess.IUserProjectsRepository;
import dataaccess.database.ProjectRepository;
import dataaccess.database.UserProjectsRepository;
import entities.Project;

import java.util.HashSet;

public class GetProjectsInteractor implements GetProjectsInputBoundary {
    private final IUserProjectsRepository userProjectsRepository = DAOImplementationConfig.getUserProjectsRepository();
    private final IProjectRepository projectRepository = DAOImplementationConfig.getProjectRepository();
    private final GetProjectsPresenter getProjectsPresenter;
    private final ILoginUserDetails loginUserDetails = DAOImplementationConfig.getLoginUserDetails();

    public GetProjectsInteractor(GetProjectsPresenter getProjectsPresenter){
        this.getProjectsPresenter = getProjectsPresenter;
    }

    @Override
    public void getProjects(GetProjectsInputData inputData) {
        int loginUserId = loginUserDetails.getUserId();
        if (loginUserId == 0){
            getProjectsPresenter.prepareFailView("User not logged in");
            return;
        }

        HashSet<Integer> projectIds = userProjectsRepository.getProjectIdsForUser(loginUserId);
        String[][] projectData = new String[projectIds.size()][3];

        int count = 0;
        for (int projectId:  projectIds){
            Project project = projectRepository.getProjectById(projectId);

            projectData[count][0] = project.getProjectTitle();
            projectData[count][1] = project.getProjectDescription();
            count++;
        }

        getProjectsPresenter.prepareSuccessView(new GetProjectsOutputData(projectData));
    }
}