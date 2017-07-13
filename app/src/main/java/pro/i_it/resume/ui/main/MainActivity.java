package pro.i_it.resume.ui.main;

import android.os.Bundle;
import android.support.annotation.Nullable;

import pro.i_it.resume.R;
import pro.i_it.resume.ui.base.BaseActivity;

/**
 * Created by syn on 13.07.17.
 */

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
