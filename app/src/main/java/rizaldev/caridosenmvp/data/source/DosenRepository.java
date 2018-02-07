package rizaldev.caridosenmvp.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import rizaldev.caridosenmvp.data.Dosen;

/**
 * Created by devel on 31/01/2018.
 */

public class DosenRepository implements DosenDataSource {

    private final DosenDataSource dosenRemoteDataSource;

    public DosenRepository(@NonNull DosenDataSource dosenRemoteDataSource) {
        this.dosenRemoteDataSource = dosenRemoteDataSource;
    }

    @Override
    public void getAllDosen(final GetDosenCallBack dosenCallBack) {
        dosenRemoteDataSource.getAllDosen(new GetDosenCallBack() {
            @Override
            public void onDosenLoaded(List<Dosen> dosens) {
                dosenCallBack.onDosenLoaded(dosens);
            }

            @Override
            public void onDataNotAvailable() {

            }
        });
    }

}
