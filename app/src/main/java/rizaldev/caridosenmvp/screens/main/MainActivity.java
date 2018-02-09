package rizaldev.caridosenmvp.screens.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import rizaldev.caridosenmvp.R;
import rizaldev.caridosenmvp.data.source.DosenRepository;
import rizaldev.caridosenmvp.data.source.local.DosenDatabase;
import rizaldev.caridosenmvp.data.source.local.DosenLocalDataSource;
import rizaldev.caridosenmvp.data.source.remote.DosenRemoteDataSource;
import rizaldev.caridosenmvp.screens.main.core.MainFragment;
import rizaldev.caridosenmvp.screens.main.core.MainPresenter;
import rizaldev.caridosenmvp.utils.ActivityUtils;
import rizaldev.caridosenmvp.utils.AppExecutors;

public class MainActivity extends AppCompatActivity {

    MainPresenter mainPresenter;
    MainFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeView();
        initializePresenter();
    }


    public void initializeView() {
        this.mainFragment = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (mainFragment == null) {
            mainFragment = MainFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), mainFragment, R.id.contentFrame);
        }
    }

    public void initializePresenter() {
        this.mainPresenter = new MainPresenter(DosenRepository.getInstance(DosenRemoteDataSource.getInstance(), DosenLocalDataSource.getInstance(new AppExecutors(),DosenDatabase.getInstance(this).dosenDao())),this.mainFragment);
    }
}
