package rizaldev.caridosenmvp.data.source.local;

import android.support.annotation.NonNull;

import java.util.List;

import rizaldev.caridosenmvp.data.Dosen;
import rizaldev.caridosenmvp.data.source.DosenDataSource;
import rizaldev.caridosenmvp.utils.AppExecutors;

/**
 * Created by devel on 5/02/2018.
 */

public class DosenLocalDataSource implements DosenDataSource{
    private static volatile DosenLocalDataSource INSTANCE;

    private DosenDao dosenDao;

    private AppExecutors appExecutors;

    private DosenLocalDataSource(@NonNull AppExecutors appExecutors, @NonNull DosenDao dosenDao){
        this.appExecutors = appExecutors;
        this.dosenDao = dosenDao;
    }

    public static DosenLocalDataSource getInstance(@NonNull AppExecutors appExecutors, @NonNull DosenDao dosenDao){
        if(INSTANCE == null){
            synchronized (DosenLocalDataSource.class){
                if(INSTANCE == null){
                    INSTANCE = new DosenLocalDataSource(appExecutors,dosenDao);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public void getAllDosen(final GetDosenCallBack dosenCallBack) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<Dosen> dosens = dosenDao.getDosen();
                appExecutors.mainThread().execute(new Runnable() {
                    @Override
                    public void run() {
                        if(dosens.isEmpty()){
                            dosenCallBack.onDataNotAvailable();
                        }else{
                            dosenCallBack.onDosenLoaded(dosens);
                        }
                    }
                });
            }
        };
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void saveDosen(final Dosen dosen) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                dosenDao.insertDosen(dosen);
            }
        };
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void deleteAllDosen() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                dosenDao.deleteDosen();
            }
        };
        appExecutors.diskIO().execute(runnable);
    }



}
