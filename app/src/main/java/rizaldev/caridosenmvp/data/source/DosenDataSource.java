package rizaldev.caridosenmvp.data.source;

import java.util.List;

import rizaldev.caridosenmvp.data.Dosen;

/**
 * Created by devel on 30/01/2018.
 */

public interface DosenDataSource {

    interface GetDosenCallBack {
        void onDosenLoaded(List<Dosen> dosens);

        void onDataNotAvailable();
    }
    void getAllDosen(GetDosenCallBack dosenCallBack);

    void saveDosen(Dosen dosen);

    void deleteAllDosen();
}
