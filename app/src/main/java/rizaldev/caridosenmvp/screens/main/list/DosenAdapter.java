package rizaldev.caridosenmvp.screens.main.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import rizaldev.caridosenmvp.R;
import rizaldev.caridosenmvp.data.Dosen;

/**
 * Created by devel on 30/01/2018.
 */

public class DosenAdapter extends RecyclerView.Adapter<DosenViewHolder> {

    private List<Dosen> dosens;

    private Context context;


    public DosenAdapter(List<Dosen> dosens, Context context) {
        this.dosens = dosens;
        this.context = context;
    }

    public Context getContext() {
        return context;
    }

    @Override
    public DosenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        // Inflate the custom layout
        View contactView = inflater.inflate(R.layout.view_dosen, parent, false);

        // Return a new holder instance
        return new DosenViewHolder(contactView);
    }

    @Override
    public void onBindViewHolder(DosenViewHolder holder, int position) {
        Dosen dosen = dosens.get(position);
        TextView namaDosen = holder.namaDosen;
        TextView statusDosen = holder.statusDosen;
        ImageView imageDosen = holder.imageDosen;
        namaDosen.setText(dosen.getNama());
        statusDosen.setText(dosen.getHadir() ? "Hadir" : "Tidak Hadir");
        statusDosen.setTextColor(context.getResources().getColor(dosen.getHadir() ? R.color.colorGreen : R.color.colorRed ));
        Glide.with(context).load(dosen.getImage_url()).into(imageDosen);
    }

    @Override
    public int getItemCount() {
        return dosens.size();
    }
}
