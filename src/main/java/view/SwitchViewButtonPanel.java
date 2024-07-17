package view;

import viewmodel.SwitchViewButtonPanelViewModel;
import viewmodel.ViewManagerModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class SwitchViewButtonPanel extends JPanel implements ActionListener, PropertyChangeListener {

    private final SwitchViewButtonPanelViewModel switchViewButtonPanelViewModel;
    private final ViewManagerModel viewManagerModel;

    private final JButton addProjectButton = new JButton("Add Project");
    private final JButton searchProjectButton = new JButton("Search Project");
    private final JButton getProjectsButton = new JButton("My Projects");
    //TODO Implement for getUserView
    private final JButton getUserProfileButton = new JButton("My Profile");


    private final JButton createUserButton = new JButton("Create User");
    private final JButton loginUserButton = new JButton("Login User");

    private final JButton logoutButton = new JButton("Logout");

    public SwitchViewButtonPanel(ViewManagerModel viewManagerModel, SwitchViewButtonPanelViewModel switchViewButtonPanelViewModel) {
        this.switchViewButtonPanelViewModel = switchViewButtonPanelViewModel;
        switchViewButtonPanelViewModel.addPropertyChangeListener(this);

        this.viewManagerModel = viewManagerModel;
        viewManagerModel.addPropertyChangeListener(this);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        addProjectButton.addActionListener(e -> {
            viewManagerModel.setActiveView("AddProjectView");
            viewManagerModel.firePropertyChanged();
        });

        searchProjectButton.addActionListener(e -> {
            viewManagerModel.setActiveView("SearchPanelView");
            viewManagerModel.firePropertyChanged();
        });

        getProjectsButton.addActionListener(e -> {
            viewManagerModel.setActiveView("GetProjectsView");
            viewManagerModel.firePropertyChanged();
        });

        getProjectsButton.addActionListener(e -> {
            viewManagerModel.setActiveView("GetMyProfile");
            viewManagerModel.firePropertyChanged();
        });

        createUserButton.addActionListener(e -> {
            viewManagerModel.setActiveView("CreateUserView");
            viewManagerModel.firePropertyChanged();
        });

        loginUserButton.addActionListener(e -> {
            viewManagerModel.setActiveView("LoginView");
            viewManagerModel.firePropertyChanged();
        });

        logoutButton.addActionListener(e -> {
            viewManagerModel.setActiveView("LoginView");
            viewManagerModel.setLogin(false);
            viewManagerModel.setUserId(0);
            viewManagerModel.setUserName("");
            viewManagerModel.firePropertyChanged();
        });

        this.add(createUserButton);
        this.add(loginUserButton);

        this.add(getUserProfileButton);
        this.add(addProjectButton);
        this.add(searchProjectButton);
        this.add(getProjectsButton);

        this.add(logoutButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("login")){
            boolean login = (boolean) evt.getNewValue();
            if (login){
                createUserButton.setVisible(false);
                loginUserButton.setVisible(false);
                addProjectButton.setVisible(true);
                searchProjectButton.setVisible(true);
                getProjectsButton.setVisible(true);
                getUserProfileButton.setVisible(true);
                logoutButton.setVisible(true);
            }
            else {
                createUserButton.setVisible(true);
                loginUserButton.setVisible(true);
                addProjectButton.setVisible(false);
                searchProjectButton.setVisible(false);
                getProjectsButton.setVisible(false);
                getUserProfileButton.setVisible(false);
                logoutButton.setVisible(false);
            }
        }
    }
}
