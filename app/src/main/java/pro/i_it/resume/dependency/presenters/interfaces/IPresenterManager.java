package pro.i_it.resume.dependency.presenters.interfaces;

import java.util.Objects;

/**
 * Created by syn on 13.07.17.
 */

public interface IPresenterManager {
    <T> T getPresenter(long id, Class<T> presenter);

    long putPresenter(Object presenter);

    void removeCashById(long id);
}
