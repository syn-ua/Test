package pro.i_it.resume.remote.github;

/**
 * Created by syn on 13.07.17.
 */

public interface GitHubApiConstant {
    String MAIN_URL = "https://api.github.com";



    String USER_BY_NAME_URL = "/users/{user}";
    String SEARCH_USERS_URL = "/search/users";
    String REPOS_BY_USER_NAME_URL = "/users/{user}/repos";
}
