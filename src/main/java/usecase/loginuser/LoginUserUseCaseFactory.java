package usecase.loginuser;

import dataaccess.ILoginUserDetails;
import config.DataAccessConfig;
import dataaccess.IUserRepository;
import usecase.BCryptPasswordHasher;
import usecase.PasswordHasher;
import viewmodel.LoginPanelViewModel;

/**
 * Factory class for creating instances of the LoginUser use case.
 */
public class LoginUserUseCaseFactory {
    private static final IUserRepository userRepository = DataAccessConfig.getUserRepository();
    private static final PasswordHasher passwordHasher = new BCryptPasswordHasher();
    private static final ILoginUserDetails loginUserDetails = DataAccessConfig.getLoginUserDetails();

    // Private constructor to prevent instantiation
    private LoginUserUseCaseFactory() {
    }

    /**
     * Creates a new LoginUserController with the given LoginPanelViewModel.
     *
     * @param loginPanelViewModel the LoginPanelViewModel
     * @return a new LoginUserController
     */
    public static LoginUserController create(LoginPanelViewModel loginPanelViewModel) {
        LoginUserPresenter loginUserPresenter = new LoginUserPresenter(loginPanelViewModel);
        LoginAuthenticator loginAuthenticator = new LoginAuthenticatorService(userRepository, passwordHasher);
        LoginUserInteractor loginUserInteractor = new LoginUserInteractor(userRepository, loginUserPresenter,
                                                                          loginAuthenticator, loginUserDetails);
        return new LoginUserController(loginUserInteractor);
    }
}
