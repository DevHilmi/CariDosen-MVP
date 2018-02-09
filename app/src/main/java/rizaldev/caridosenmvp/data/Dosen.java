package rizaldev.caridosenmvp.data;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Created by devel on 30/01/2018.
 */
@Entity(tableName = "Dosen")
public class Dosen {

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    private String id;
    @Nullable
    @ColumnInfo(name = "nama")
    private String nama;
    @Nullable
    @ColumnInfo(name = "image")
    private String image_url;
    @Nullable
    @ColumnInfo(name = "hadir")
    private Boolean hadir;


    public Dosen(@NonNull String id, String nama, String image_url, Boolean hadir) {
        this.id = id;
        this.nama = nama;
        this.image_url = image_url;
        this.hadir = hadir;
    }


    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public Boolean getHadir() {
        return hadir;
    }

    public void setHadir(Boolean hadir) {
        this.hadir = hadir;
    }
}
