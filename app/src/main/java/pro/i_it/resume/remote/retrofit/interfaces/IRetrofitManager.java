package pro.i_it.resume.remote.retrofit.interfaces;

import retrofit2.Retrofit;

/**
 * Created by syn on 13.07.17.
 */

public interface IRetrofitManager {
    Retrofit getRetrofit(String mainUrl);
}
