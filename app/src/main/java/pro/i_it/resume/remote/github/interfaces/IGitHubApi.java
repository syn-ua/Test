package pro.i_it.resume.remote.github.interfaces;

import java.util.List;

import io.reactivex.Single;
import pro.i_it.resume.remote.github.model.RepositorySearchNetModel;
import pro.i_it.resume.remote.github.model.UserNetModel;

/**
 * Created by syn on 13.07.17.
 */

public interface IGitHubApi {
    Single<UserNetModel> getUserByUserName(String userName);

    Single<List<UserNetModel>> getSearchUsersByName(String userName, String page);

    Single<List<RepositorySearchNetModel>> getReposByUserName(String userName, Long page);
}
