package pro.i_it.resume.remote.interfaces;

import pro.i_it.resume.remote.github.interfaces.IGitHubApi;
import pro.i_it.resume.remote.retrofit.interfaces.IRetrofitManager;

/**
 * Created by syn on 13.07.17.
 */

public interface IRemoteManager {
    IRetrofitManager getRetrofitManager();

    IGitHubApi getGitHubApi();

}
