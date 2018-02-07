package rizaldev.caridosenmvp.screens.main.core;


import android.support.annotation.NonNull;

import java.util.List;

import rizaldev.caridosenmvp.data.Dosen;
import rizaldev.caridosenmvp.data.source.DosenDataSource;
import rizaldev.caridosenmvp.data.source.DosenRepository;

/**
 * Created by devel on 30/01/2018.
 */

public class MainPresenter implements MainContract.Presenter {

    private final DosenRepository dosenRepository;

    private final MainContract.View mainView;

    public MainPresenter(@NonNull DosenRepository dosenRepository, @NonNull MainContract.View mainView) {
        this.dosenRepository = dosenRepository;
        this.mainView = mainView;
        mainView.setPresenter(this);
    }

    @Override
    public void start() {

    }


    @Override
    public void loadDosen(boolean forceUpdate) {
        loadDosen();
    }

    @Override
    public void searchDosen(String namaDosen) {

    }

    private void loadDosen() {
        dosenRepository.getAllDosen(new DosenDataSource.GetDosenCallBack() {
            @Override
            public void onDosenLoaded(List<Dosen> dosens) {
                mainView.showDosen(dosens);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }
}
