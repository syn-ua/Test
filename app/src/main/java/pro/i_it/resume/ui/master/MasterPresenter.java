package pro.i_it.resume.ui.master;

import android.util.Log;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import pro.i_it.resume.dependency.MainManager;
import pro.i_it.resume.dependency.interfaces.IMainManager;
import pro.i_it.resume.remote.github.model.RepositorySearchNetModel;
import pro.i_it.resume.ui.master.interfaces.IMasterPresenter;
import pro.i_it.resume.ui.master.interfaces.IMasterView;
import pro.i_it.resume.ui.master.model.RepositoryViewModel;

/**
 * Created by syn on 13.07.17.
 */

public class MasterPresenter implements IMasterPresenter {
    private static final String TAG = MasterPresenter.class.getSimpleName();
    private IMainManager mainManager;
    private Long page;
    private ArrayList<RepositoryViewModel> repositoryViewModels;
    private IMasterView view;
    private Disposable disposable;
    private String searchText;
    private boolean isLoading;

    public MasterPresenter() {
        repositoryViewModels = new ArrayList<>();
    }

    @Override
    public void init(IMasterView view) {
        isLoading = false;
        this.view = view;
        mainManager = MainManager.getDefaultInstance(view.getActivity());

    }

    @Override
    public void updateUiState(boolean isFullUpdate) {
        if (disposable != null) {
            disposable.dispose();
        }
        view.setSearchText(searchText);
        view.setMore(this::loadNexPage);
        disposable = view.getSearchObservable().subscribe(this::searchUpdate);
        view.updateRepository(repositoryViewModels, isFullUpdate);
    }

    private void loadNexPage() {
        page++;
        loadPage(searchText, false);
    }

    private void searchUpdate(String name) {

        repositoryViewModels.clear();
        view.updateRepository(repositoryViewModels,true);
        searchText = name;
        page = 0L;
        loadPage(name, true);
    }

    private void loadPage(String name, boolean isFullUpdate) {
        if (isLoading == true) {
            return;
        }
        isLoading = true;
        mainManager.getRemoteManager().getGitHubApi()
                .getReposByUserName(name, page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((userNetModel, throwable) -> {
                    isLoading = false;
                    view.showError(throwable);
                    if (userNetModel != null) {
                        for (RepositorySearchNetModel repositorySearchNetModel : userNetModel) {
                            repositoryViewModels.add(RepositoryViewModel.wrapView(repositorySearchNetModel));
                        }
                        updateUiState(isFullUpdate);
                        Log.d(TAG, "init: " + userNetModel.toString());
                    }
                });
    }
}
