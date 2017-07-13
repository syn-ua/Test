package pro.i_it.resume.dependency.presenters;

import java.util.HashMap;
import java.util.Objects;

import pro.i_it.resume.dependency.presenters.interfaces.IPresenterManager;

/**
 * Created by syn on 13.07.17.
 */

public class PresenterManager implements IPresenterManager {
    private long id;
    private HashMap<Long, Object> hashMap;

    public PresenterManager() {
        id = 0;
        hashMap = new HashMap<>();
    }

    @Override
    public <T> T getPresenter(long id, Class<T> presenter) {
        if (presenter.isInstance(hashMap.get(id))) {
            return (T) hashMap.get(id);
        }
        return null;
    }

    @Override
    public long putPresenter(Object presenter) {
        id++;
        hashMap.put(id, presenter);
        return id;
    }

    @Override
    public void removeCashById(long id) {
        hashMap.remove(id);
    }
}
