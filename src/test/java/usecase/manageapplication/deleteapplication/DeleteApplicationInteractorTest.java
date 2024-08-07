package usecase.manageapplication.deleteapplication;

import dataaccess.IApplicationRepository;
import org.junit.jupiter.api.Test;
import usecase.manageapplications.deleteapplication.DeleteApplicationInputData;
import usecase.manageapplications.deleteapplication.DeleteApplicationInteractor;
import usecase.manageapplications.deleteapplication.DeleteApplicationPresenter;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DeleteApplicationInteractorTest {

    @Test
    void deleteApplicationWithValidIdsCallsRepository() {
        int senderUserId = 1;
        int projectId = 1;

        IApplicationRepository mockRepository = mock(IApplicationRepository.class);
        DeleteApplicationPresenter mockPresenter = mock(DeleteApplicationPresenter.class);
        DeleteApplicationInteractor interactor = new DeleteApplicationInteractor(mockPresenter, mockRepository);

        DeleteApplicationInputData inputData = new DeleteApplicationInputData(senderUserId, projectId);
        interactor.deleteApplication(inputData);

        verify(mockRepository).deleteApplication(senderUserId, projectId);
    }

    @Test
    void deleteApplicationWithValidIdsCallsPresenter() {
        int senderUserId = 1;
        int projectId = 1;

        IApplicationRepository mockRepository = mock(IApplicationRepository.class);
        DeleteApplicationPresenter mockPresenter = mock(DeleteApplicationPresenter.class);
        DeleteApplicationInteractor interactor = new DeleteApplicationInteractor(mockPresenter, mockRepository);

        DeleteApplicationInputData inputData = new DeleteApplicationInputData(senderUserId, projectId);
        interactor.deleteApplication(inputData);

        verify(mockPresenter).prepareSuccessView(argThat(outputData ->
                outputData.getSenderUserId() == senderUserId && outputData.getProjectId() == projectId));
    }

}
