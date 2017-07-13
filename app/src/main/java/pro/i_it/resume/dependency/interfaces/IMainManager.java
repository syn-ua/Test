package pro.i_it.resume.dependency.interfaces;

import pro.i_it.resume.dependency.presenters.interfaces.IPresenterManager;
import pro.i_it.resume.remote.interfaces.IRemoteManager;

/**
 * Created by syn on 13.07.17.
 */

public interface IMainManager {
    IPresenterManager getPresenterManager();

    IRemoteManager getRemoteManager();
}
