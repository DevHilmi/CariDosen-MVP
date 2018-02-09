package rizaldev.caridosenmvp.data.source;

import android.support.annotation.NonNull;

import java.util.List;

import rizaldev.caridosenmvp.data.Dosen;

/**
 * Created by devel on 31/01/2018.
 */

public class DosenRepository implements DosenDataSource {

    private static DosenRepository INSTANCE = null;

    private final DosenDataSource dosenRemoteDataSource;

    private final DosenDataSource dosenLocalDataSource;

    boolean localDirty = true;

    public DosenRepository(@NonNull DosenDataSource dosenRemoteDataSource, @NonNull DosenDataSource dosenLocalDataSource) {
        this.dosenRemoteDataSource = dosenRemoteDataSource;
        this.dosenLocalDataSource = dosenLocalDataSource;
    }

    public static DosenRepository getInstance(@NonNull DosenDataSource dosenRemoteDataSource, @NonNull DosenDataSource dosenLocalDataSource) {
        if (INSTANCE == null) {
            INSTANCE = new DosenRepository(dosenRemoteDataSource, dosenLocalDataSource);
        }
        return INSTANCE;
    }

    @Override
    public void getAllDosen(final GetDosenCallBack dosenCallBack) {
        if(!localDirty){
            dosenLocalDataSource.getAllDosen(new GetDosenCallBack() {
                @Override
                public void onDosenLoaded(List<Dosen> dosens) {
                    dosenCallBack.onDosenLoaded(dosens);
                }

                @Override
                public void onDataNotAvailable() {

                }
            });
        }else{
            dosenRemoteDataSource.getAllDosen(new GetDosenCallBack() {
                @Override
                public void onDosenLoaded(List<Dosen> dosens) {
                    refreshLocalDataSource(dosens);
                   // localDirty = false;
                    dosenCallBack.onDosenLoaded(dosens);
                }

                @Override
                public void onDataNotAvailable() {

                }
            });
        }

    }

    @Override
    public void saveDosen(Dosen dosen) {

    }

    @Override
    public void deleteAllDosen() {

    }


    private void refreshLocalDataSource(List<Dosen> dosens) {
        dosenLocalDataSource.deleteAllDosen();
        for (Dosen dosen : dosens) {
            dosenLocalDataSource.saveDosen(dosen);
        }
    }

}
