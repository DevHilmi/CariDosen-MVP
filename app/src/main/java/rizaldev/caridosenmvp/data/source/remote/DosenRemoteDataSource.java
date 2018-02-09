package rizaldev.caridosenmvp.data.source.remote;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Handler;
import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import rizaldev.caridosenmvp.data.Dosen;
import rizaldev.caridosenmvp.data.source.DosenDataSource;

/**
 * Created by devel on 30/01/2018.
 */

public class DosenRemoteDataSource implements DosenDataSource {

    private static DosenRemoteDataSource INSTANCE;


    public static DosenRemoteDataSource getInstance(){
        if(INSTANCE ==null){
            INSTANCE = new DosenRemoteDataSource();
        }
        return INSTANCE;
    }

    @SuppressLint("StaticFieldLeak")
    @Override
    public void getAllDosen(final GetDosenCallBack dosenCallBack) {
        new AsyncTask<Void, Void, List<Dosen>>() {
            @Override
            protected List<Dosen> doInBackground(Void... voids) {
                List<Dosen> dosens = new ArrayList<>();
                Document doc = null;
                try {
                    doc = Jsoup.connect("http://filkom.ub.ac.id/info/hadir").get();

                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                if (doc != null) {
                    Elements eles = doc.select("tbody > tr");
                    for (Element ele : eles) {
                        Elements cols = ele.select("td");
                        Element id = cols.get(1).select("div.media > a.pull-left").first();
                        Element nama = cols.get(1).select("div.media-body > b > a > span.text.text-default").first();
                        Element image = cols.get(1).select("div.media > a.pull-left > img").first();
                        Element hadir = cols.get(1).select("div.col-md-2 > div.label").first();
                        String idDosen = id.attr("href");
                        String namaDosen = nama.text();
                        String image_url = image.attr("src");
                        Boolean hadirDosen = hadir.text().equals("Hadir");
                        dosens.add(new Dosen(idDosen,namaDosen, image_url, hadirDosen));
                    }
                }
                return dosens;
            }

            @Override
            protected void onPostExecute(List<Dosen> dosens) {
                super.onPostExecute(dosens);
                dosenCallBack.onDosenLoaded(dosens);
            }
        }.execute();

    }

    @Override
    public void saveDosen(Dosen dosen) {

    }

    @Override
    public void deleteAllDosen() {

    }

}
