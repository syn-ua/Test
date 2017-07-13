package pro.i_it.resume.dependency;

import android.app.Activity;
import android.content.Context;

import pro.i_it.resume.ResumeApp;
import pro.i_it.resume.dependency.interfaces.IMainManager;
import pro.i_it.resume.dependency.presenters.PresenterManager;
import pro.i_it.resume.dependency.presenters.interfaces.IPresenterManager;
import pro.i_it.resume.remote.RemoteManager;
import pro.i_it.resume.remote.github.GitHubApi;
import pro.i_it.resume.remote.github.interfaces.IGitHubApi;
import pro.i_it.resume.remote.interfaces.IRemoteManager;
import pro.i_it.resume.remote.retrofit.RetrofitManager;
import pro.i_it.resume.remote.retrofit.interfaces.IRetrofitManager;

/**
 * Created by syn on 13.07.17.
 */

public class MainManager implements IMainManager {
    private IPresenterManager presenterManager;
    private IRemoteManager remoteManager;

    public MainManager(Context context) {
        presenterManager = new PresenterManager();

        IRetrofitManager retrofitManager = new RetrofitManager();
        IGitHubApi gitHubApi = new GitHubApi(retrofitManager);

        RemoteManager remoteManager = new RemoteManager();
        remoteManager.setRetrofitManager(retrofitManager);
        remoteManager.setGitHubApi(gitHubApi);

        this.remoteManager = remoteManager;

    }

    public static IMainManager getDefaultInstance(Activity activity) {
        return ((ResumeApp) activity.getApplication()).getMainManager();
    }

    @Override
    public IPresenterManager getPresenterManager() {
        return presenterManager;
    }

    @Override
    public IRemoteManager getRemoteManager() {
        return remoteManager;
    }

}
