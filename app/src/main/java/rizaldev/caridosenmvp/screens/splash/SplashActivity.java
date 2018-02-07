package rizaldev.caridosenmvp.screens.splash;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rizaldev.caridosenmvp.R;
import rizaldev.caridosenmvp.data.source.DosenRepository;
import rizaldev.caridosenmvp.data.source.remote.DosenRemoteDataSource;
import rizaldev.caridosenmvp.screens.splash.core.SplashFragment;
import rizaldev.caridosenmvp.screens.splash.core.SplashPresenter;
import rizaldev.caridosenmvp.utils.ActivityUtils;

public class SplashActivity extends AppCompatActivity {

    SplashPresenter splashPresenter;
    SplashFragment splashFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initializeView();
        initializePresenter();
    }


    public void initializeView(){
        this.splashFragment = (SplashFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if(splashFragment == null){
            splashFragment = SplashFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),splashFragment,R.id.contentFrame);
        }
    }


    public void initializePresenter(){
        splashPresenter = new SplashPresenter(new DosenRepository(new DosenRemoteDataSource()),this.splashFragment);
    }
}
