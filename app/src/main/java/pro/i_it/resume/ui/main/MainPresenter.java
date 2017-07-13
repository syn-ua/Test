package pro.i_it.resume.ui.main;

import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import pro.i_it.resume.dependency.MainManager;
import pro.i_it.resume.dependency.interfaces.IMainManager;
import pro.i_it.resume.ui.main.interfaces.IMainPresenter;
import pro.i_it.resume.ui.main.interfaces.IMainView;
import pro.i_it.resume.ui.master.MasterFragment;

/**
 * Created by syn on 13.07.17.
 */

public class MainPresenter implements IMainPresenter {
    private static final String TAG = MainPresenter.class.getSimpleName();
    private IMainManager mainManager;
    private IMainView view;
    private MasterFragment masterFragment;

    @Override
    public void init(IMainView view) {
        this.view = view;
        masterFragment = new MasterFragment();
        view.showFragment(masterFragment);
    }

    @Override
    public void finish() {
        mainManager.getPresenterManager().removeCashById(masterFragment.getPresenterId());
    }
}
