import dataaccess.DAOImplementationConfig;
import usecase.createproject.CreateProjectController;
import usecase.createproject.CreateProjectUseCaseFactory;
import usecase.createuser.CreateUserController;
import usecase.loginuser.LoginUserController;
import usecase.loginuser.LoginUserUseCaseFactory;
import usecase.searchforproject.SearchProjectUseCaseFactory;
import usecase.createuser.CreateUserUseCaseFactory;
import view.*;
import viewmodel.*;

import javax.swing.*;
import java.awt.*;

class Main {
    public static void main(String[] args) {

        JFrame application = new JFrame("A Screen");
        application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        application.setSize(1200, 1200);

        CardLayout cardLayout = new CardLayout();
        JPanel views = new JPanel(cardLayout);
        application.add(views);

        DAOImplementationConfig.initializeDatabase();

        ViewManagerModel viewManagerModel = new ViewManagerModel();
        viewManagerModel.setLogin(false);
        viewManagerModel.setUserId(0);
        ViewManager viewManager = new ViewManager(views, cardLayout, viewManagerModel);

        CreateUserPanelViewModel createUserPanelViewModel = new CreateUserPanelViewModel();
        CreateUserController createUserController = CreateUserUseCaseFactory.create(createUserPanelViewModel);
        CreateUserPanel createUserPanel = new CreateUserPanel(createUserPanelViewModel, createUserController);

        LoginPanelViewModel loginPanelViewModel = new LoginPanelViewModel();
        LoginUserController loginUserController = LoginUserUseCaseFactory.create(loginPanelViewModel);
        LoginPanel loginPanel = new LoginPanel(viewManagerModel, loginPanelViewModel, loginUserController);

        SearchPanelViewModel searchPanelViewModel = new SearchPanelViewModel();
        SearchPanel searchPanel = SearchProjectUseCaseFactory.createSearchProjectPanel(searchPanelViewModel);

        AddProjectPanelViewModel addProjectPanelModel = new AddProjectPanelViewModel();
        CreateProjectController createProjectController = CreateProjectUseCaseFactory.createController(addProjectPanelModel);
        AddProjectPanel addProjectPanel = new AddProjectPanel(addProjectPanelModel, createProjectController);

        MyProjectsPanelViewModel myProjectsViewModel = new MyProjectsPanelViewModel();
        MyProjectsPanel myProjectsPanel = new MyProjectsPanel(myProjectsViewModel);

        views.add(createUserPanel, createUserPanelViewModel.getViewName());
        views.add(loginPanel, loginPanelViewModel.getViewName());
        views.add(searchPanel, searchPanelViewModel.getViewName());
        views.add(addProjectPanel, addProjectPanelModel.getViewName());
        views.add(myProjectsPanel, myProjectsViewModel.getViewName());

        SwitchViewButtonPanelViewModel switchViewButtonPanelViewModel = new SwitchViewButtonPanelViewModel();
        JPanel switchButtons = new SwitchViewButtonPanel(viewManagerModel, switchViewButtonPanelViewModel);

        viewManagerModel.setActiveView(createUserPanelViewModel.getViewName());
        viewManagerModel.firePropertyChanged();

        application.getContentPane().add(views, BorderLayout.CENTER);
        application.getContentPane().add(switchButtons, BorderLayout.SOUTH);

        application.pack();
        application.setVisible(true);

    }
}