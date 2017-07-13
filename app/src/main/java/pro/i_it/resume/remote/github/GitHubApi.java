package pro.i_it.resume.remote.github;

import java.util.List;

import io.reactivex.Single;
import pro.i_it.resume.remote.github.interfaces.IGitHubApi;
import pro.i_it.resume.remote.github.interfaces.IGitHubRetrofit;
import pro.i_it.resume.remote.github.model.RepositorySearchNetModel;
import pro.i_it.resume.remote.github.model.UserNetModel;
import pro.i_it.resume.remote.retrofit.interfaces.IRetrofitManager;
import retrofit2.Response;

/**
 * Created by syn on 13.07.17.
 */

public class GitHubApi implements IGitHubApi {
    private IGitHubRetrofit gitHubRetrofit;

    public GitHubApi(IRetrofitManager retrofit) {
        gitHubRetrofit = retrofit.getRetrofit(GitHubApiConstant.MAIN_URL).create(IGitHubRetrofit.class);
    }

    @Override
    public Single<UserNetModel> getUserByUserName(String userName) {
        return gitHubRetrofit.getDataByUserName(userName);
    }

    @Override
    public Single<List<UserNetModel>> getSearchUsersByName(String userName, String page) {
        return gitHubRetrofit.getSearchUsersByName(userName, page);
    }

    @Override
    public Single<List<RepositorySearchNetModel>> getReposByUserName(String userName, Long page) {
        return gitHubRetrofit.getReposByUserName(userName,page);
    }
}
