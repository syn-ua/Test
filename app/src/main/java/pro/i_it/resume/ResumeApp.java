package pro.i_it.resume;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

import pro.i_it.resume.dependency.MainManager;
import pro.i_it.resume.dependency.interfaces.IMainManager;

/**
 * Created by syn on 13.07.17.
 */

public class ResumeApp extends Application {
    private IMainManager mainManager;

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(this);
        mainManager = new MainManager(this);
    }

    public IMainManager getMainManager() {
        return mainManager;
    }
}
