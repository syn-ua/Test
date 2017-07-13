package pro.i_it.resume.ui.master;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Observable;
import io.reactivex.subjects.PublishSubject;
import pro.i_it.resume.R;
import pro.i_it.resume.dependency.MainManager;
import pro.i_it.resume.dependency.interfaces.IMainManager;
import pro.i_it.resume.ui.base.interfaces.IBaseView;
import pro.i_it.resume.ui.master.interfaces.IMasterPresenter;
import pro.i_it.resume.ui.master.interfaces.IMasterView;
import pro.i_it.resume.ui.master.interfaces.IMore;
import pro.i_it.resume.ui.master.model.RepositoryViewModel;

/**
 * Created by syn on 13.07.17.
 */

public class MasterFragment extends Fragment implements IMasterView {
    private static final String TAG = MasterFragment.class.getSimpleName();
    private IMasterPresenter presenter;
    private IMainManager mainManager;
    private RepositoryAdapter adapter;
    private PublishSubject<String> searchPublish;
    private Long presenterId;


    @BindView(R.id.view_master_recycle)
    protected RecyclerView recyclerView;
    @BindView(R.id.view_master_search)
    protected SearchView searchView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.view_master, container, false);
        mainManager = MainManager.getDefaultInstance(getActivity());
        initView(rootView);
        initPresenter(savedInstanceState);
        return rootView;
    }

    private void initView(View view) {
        adapter = new RepositoryAdapter();
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        searchPublish = PublishSubject.create();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                searchPublish.onNext(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return true;
            }
        });
        searchView.onActionViewExpanded();

    }


    private void initPresenter(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey(PRESENTER_ID)) {
            presenterId = savedInstanceState.getLong(PRESENTER_ID);
            presenter = mainManager
                    .getPresenterManager()
                    .getPresenter(presenterId, IMasterPresenter.class);
        }
        if (presenter == null) {
            initNewPresenter();
            presenterId = mainManager
                    .getPresenterManager().putPresenter(presenter);
        }
        presenter.updateUiState(true);

    }

    private void initNewPresenter() {
        presenter = new MasterPresenter();
        presenter.init(this);
    }

    @Override
    public void showError(String error) {
        if (getActivity() == null) {
            return;
        }
        if (getActivity() instanceof IBaseView) {
            IBaseView baseView = (IBaseView) getActivity();
            baseView.showError(error);
        } else {
            Log.d(TAG, "showError: " + error);
        }
    }

    @Override
    public void showError(Throwable throwable) {
        if (getActivity() == null) {
            return;
        }
        if (getActivity() instanceof IBaseView) {
            IBaseView baseView = (IBaseView) getActivity();
            baseView.showError(throwable);
        } else {
            throwable.printStackTrace();
        }
    }

    @Override
    public void updateRepository(ArrayList<RepositoryViewModel> repositoryViewModels, boolean isFullUpdate) {
        adapter.update(repositoryViewModels, isFullUpdate);
    }

    @Override
    public Observable<String> getSearchObservable() {
        return searchPublish;
    }

    @Override
    public void setSearchText(String searchText) {
        searchView.setQuery(searchText, false);
    }

    @Override
    public Long getPresenterId() {
        return presenterId;
    }

    @Override
    public void setMore(IMore more) {
        adapter.setMore(more);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putLong(PRESENTER_ID, presenterId);
        super.onSaveInstanceState(outState);
    }
}
