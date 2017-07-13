package pro.i_it.resume.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import pro.i_it.resume.R;
import pro.i_it.resume.dependency.MainManager;
import pro.i_it.resume.dependency.interfaces.IMainManager;
import pro.i_it.resume.ui.base.BaseActivity;
import pro.i_it.resume.ui.main.interfaces.IMainPresenter;
import pro.i_it.resume.ui.main.interfaces.IMainView;
import pro.i_it.resume.ui.master.MasterPresenter;
import pro.i_it.resume.ui.master.interfaces.IMasterPresenter;

/**
 * Created by syn on 13.07.17.
 */

public class MainActivity extends BaseActivity implements IMainView {
    private IMainManager mainManager;
    private IMainPresenter presenter;
    private long presenterId;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainManager = MainManager.getDefaultInstance(this);
        initPresenter(savedInstanceState);
    }

    private void initPresenter(Bundle savedInstanceState) {
        if (savedInstanceState != null && savedInstanceState.containsKey(PRESENTER_ID)) {
            presenterId = savedInstanceState.getLong(PRESENTER_ID);
            presenter = mainManager
                    .getPresenterManager()
                    .getPresenter(presenterId, IMainPresenter.class);
        }
        if (presenter == null) {
            initNewPresenter();
            presenterId = mainManager
                    .getPresenterManager().putPresenter(presenter);
        }
    }

    private void initNewPresenter() {
        presenter = new MainPresenter();
        presenter.init(this);
    }


    @Override
    public void showFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.activity_main_frame, fragment)
                .commit();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putLong(PRESENTER_ID, presenterId);
        super.onSaveInstanceState(outState);
    }

    @Override
    public void finish() {
        super.finish();
        presenter.finish();
        mainManager.getPresenterManager().removeCashById(presenterId);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        mainManager.getPresenterManager().removeCashById(presenterId);
    }
}
