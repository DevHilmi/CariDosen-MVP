package rizaldev.caridosenmvp.screens.main.list;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import rizaldev.caridosenmvp.R;

/**
 * Created by devel on 30/01/2018.
 */

class DosenViewHolder extends RecyclerView.ViewHolder {
    TextView namaDosen, statusDosen;
    ImageView imageDosen;
    DosenViewHolder(View itemView) {
        super(itemView);
        namaDosen = itemView.findViewById(R.id.text_nama_dosen);
        statusDosen = itemView.findViewById(R.id.text_status_dosen);
        imageDosen = itemView.findViewById(R.id.image_dosen);
    }
}
