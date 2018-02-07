package rizaldev.caridosenmvp.screens.splash.core;

import java.util.List;

import rizaldev.caridosenmvp.data.Dosen;
import rizaldev.caridosenmvp.data.source.DosenDataSource;
import rizaldev.caridosenmvp.data.source.DosenRepository;

/**
 * Created by devel on 5/02/2018.
 */

public class SplashPresenter implements SplashContract.Presenter {

    DosenRepository dosenRepository;
    SplashContract.View view;


    public SplashPresenter(DosenRepository dosenRepository, SplashContract.View view) {
        this.dosenRepository = dosenRepository;
        this.view = view;
        view.setPresenter(this);
    }

    @Override
    public void start() {
        view.showLoadingIndicator();
        loadDosen();
    }

    @Override
    public void loadDosen() {
        dosenRepository.getAllDosen(new DosenDataSource.GetDosenCallBack() {
            @Override
            public void onDosenLoaded(List<Dosen> dosens) {
                view.hideLoadingIndicator();
                view.showMainUI();
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }
}
