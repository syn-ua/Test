package pro.i_it.resume.ui.master.interfaces;

import pro.i_it.resume.ui.main.interfaces.IMainView;

/**
 * Created by syn on 13.07.17.
 */

public interface IMasterPresenter {
    void init(IMasterView view);

    void updateUiState(boolean isFullUpdate);
}
