package pro.i_it.resume.remote;

import pro.i_it.resume.remote.github.interfaces.IGitHubApi;
import pro.i_it.resume.remote.interfaces.IRemoteManager;
import pro.i_it.resume.remote.retrofit.interfaces.IRetrofitManager;

/**
 * Created by syn on 13.07.17.
 */

public class RemoteManager implements IRemoteManager {
    private IRetrofitManager retrofitManager;
    private IGitHubApi gitHubApi;

    public void setRetrofitManager(IRetrofitManager retrofitManager) {
        this.retrofitManager = retrofitManager;
    }

    public void setGitHubApi(IGitHubApi gitHubApi) {
        this.gitHubApi = gitHubApi;
    }

    @Override
    public IRetrofitManager getRetrofitManager() {
        return retrofitManager;
    }

    @Override
    public IGitHubApi getGitHubApi() {
        return gitHubApi;
    }
}
