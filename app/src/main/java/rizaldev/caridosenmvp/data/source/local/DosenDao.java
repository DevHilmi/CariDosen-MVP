package rizaldev.caridosenmvp.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

import rizaldev.caridosenmvp.data.Dosen;

/**
 * Created by devel on 8/02/2018.
 */
@Dao
public interface DosenDao {

    @Query("SELECT * FROM Dosen")
    List<Dosen> getDosen();

    @Query("SELECT * FROM Dosen WHERE id = :id")
    Dosen getDosenById(String id);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDosen(Dosen dosen);

    @Query("UPDATE Dosen SET hadir = :hadir WHERE id = :id")
    void updateHadir(String id, boolean hadir);


    @Query("DELETE FROM Dosen")
    void deleteDosen();
}
