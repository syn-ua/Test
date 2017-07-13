package pro.i_it.resume.remote.github.interfaces;

import java.util.List;

import io.reactivex.Single;
import pro.i_it.resume.remote.github.model.RepositorySearchNetModel;
import pro.i_it.resume.remote.github.model.UserNetModel;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

import static pro.i_it.resume.remote.github.GitHubApiConstant.REPOS_BY_USER_NAME_URL;
import static pro.i_it.resume.remote.github.GitHubApiConstant.SEARCH_USERS_URL;
import static pro.i_it.resume.remote.github.GitHubApiConstant.USER_BY_NAME_URL;

/**
 * Created by syn on 13.07.17.
 */

public interface IGitHubRetrofit {
    @GET(USER_BY_NAME_URL)
    Single<UserNetModel> getDataByUserName(@Path("user") String userName);

    @GET(SEARCH_USERS_URL)
    Single<List<UserNetModel>> getSearchUsersByName(@Query("q") String userName, @Query("page") String page);

    @GET(REPOS_BY_USER_NAME_URL)
    Single<List<RepositorySearchNetModel>> getReposByUserName(@Path("user") String userName, @Query("page") Long page);
}
