package rizaldev.caridosenmvp.screens.main.core;

import java.util.List;

import rizaldev.caridosenmvp.BasePresenter;
import rizaldev.caridosenmvp.BaseView;
import rizaldev.caridosenmvp.data.Dosen;

/**
 * Created by devel on 31/01/2018.
 */

public interface MainContract {

    interface View extends BaseView<Presenter> {
        void showDosen(List<Dosen> dosens);
    }

    interface Presenter extends BasePresenter {
        void loadDosen(boolean forceUpdate);
        void searchDosen(String namaDosen);
    }
}
