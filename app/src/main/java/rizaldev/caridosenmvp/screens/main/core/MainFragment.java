package rizaldev.caridosenmvp.screens.main.core;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.List;

import rizaldev.caridosenmvp.R;
import rizaldev.caridosenmvp.data.Dosen;
import rizaldev.caridosenmvp.screens.main.list.DosenAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment implements MainContract.View{


    private MainContract.Presenter presenter;

    private RecyclerView recyclerView;

    private EditText editTextDosen;
    public MainFragment() {
        // Required empty public constructor
    }
    public static MainFragment newInstance(){
        return new MainFragment();
    }
    @Override
    public void setPresenter(MainContract.Presenter presenter) {
        this.presenter = presenter;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        this.recyclerView = view.findViewById(R.id.recyclerview);
        this.editTextDosen = view.findViewById(R.id.edit_text_nama_dosen);
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter.loadDosen(false);

    }

    @Override
    public void showDosen(List<Dosen> dosens) {
        RecyclerView.Adapter mAdapter = new DosenAdapter(dosens,getContext());
        this.recyclerView.setAdapter(mAdapter);
        this.recyclerView.invalidate();
    }
}
