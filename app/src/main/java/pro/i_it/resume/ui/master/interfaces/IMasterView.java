package pro.i_it.resume.ui.master.interfaces;

import java.util.ArrayList;

import io.reactivex.Observable;
import pro.i_it.resume.ui.base.interfaces.IBaseView;
import pro.i_it.resume.ui.master.model.RepositoryViewModel;

/**
 * Created by syn on 13.07.17.
 */

public interface IMasterView extends IBaseView {
    void updateRepository(ArrayList<RepositoryViewModel> repositoryViewModels, boolean isFullUpdate);

    Observable<String> getSearchObservable();


    void setSearchText(String searchText);

    Long getPresenterId();

    void setMore(IMore more);
}
