package pro.i_it.resume.remote.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import pro.i_it.resume.remote.retrofit.interfaces.IRetrofitManager;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by syn on 13.07.17.
 */

public class RetrofitManager implements IRetrofitManager {
    @Override
    public Retrofit getRetrofit(String mainUrl) {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(mainUrl)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        return retrofit;
    }
}
