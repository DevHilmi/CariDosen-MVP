package rizaldev.caridosenmvp.data;

/**
 * Created by devel on 30/01/2018.
 */

public class Dosen {
    private String nama;
    private String image_url;
    private Boolean hadir;

    public Dosen(String nama, String image_url, Boolean hadir) {
        this.nama = nama;
        this.image_url = image_url;
        this.hadir = hadir;
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
