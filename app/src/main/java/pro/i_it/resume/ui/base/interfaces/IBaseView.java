package pro.i_it.resume.ui.base.interfaces;

import android.app.Activity;
import android.content.Context;

/**
 * Created by syn on 13.07.17.
 */

public interface IBaseView {
     String PRESENTER_ID = "presenterId";

    Activity getActivity();

    Context getContext();

    void showError(String error);

    void showError(Throwable throwable);

}
