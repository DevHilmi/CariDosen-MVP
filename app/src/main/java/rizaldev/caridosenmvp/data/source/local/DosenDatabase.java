package rizaldev.caridosenmvp.data.source.local;

import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import rizaldev.caridosenmvp.data.Dosen;

/**
 * Created by devel on 8/02/2018.
 */
@Database(entities = Dosen.class, version = 1)
public abstract class DosenDatabase extends RoomDatabase {

    private static DosenDatabase INSTANCE;

    public abstract DosenDao dosenDao();

    public static final Object sLock = new Object();

    public static DosenDatabase getInstance(Context context) {
        synchronized (sLock) {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(), DosenDatabase.class, "Dosen.db").build();
            }
            return INSTANCE;
        }
    }
}
