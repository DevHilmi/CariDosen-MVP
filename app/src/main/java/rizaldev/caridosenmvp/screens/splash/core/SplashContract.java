package rizaldev.caridosenmvp.screens.splash.core;

import rizaldev.caridosenmvp.BasePresenter;
import rizaldev.caridosenmvp.BaseView;

/**
 * Created by devel on 5/02/2018.
 */

public interface SplashContract {
    interface View extends BaseView<Presenter> {
        void showLoadingIndicator();
        void hideLoadingIndicator();
        void showMainUI();
    }

    interface Presenter extends BasePresenter {
        void loadDosen();
    }
}
