package pro.i_it.resume.ui.base;

import android.app.Activity;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import pro.i_it.resume.ui.base.interfaces.IBaseView;

/**
 * Created by syn on 13.07.17.
 */

public class BaseActivity extends AppCompatActivity implements IBaseView {
    @Override
    public Activity getActivity() {
        return this;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showError(Throwable throwable) {
        if (throwable == null) {
            return;
        }
        Toast.makeText(this, throwable.getMessage(), Toast.LENGTH_SHORT).show();
    }
}
