package cityworld.sec04.fjarquellada.es.sec06fragments.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import cityworld.sec04.fjarquellada.es.sec06fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {

    TextView txtViewDetail;

    public DetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);
        txtViewDetail = view.findViewById(R.id.txtViewDetail);

        // Inflate the layout for this fragment
        return view;
    }

    public void populateData(String detail){
        txtViewDetail.setText(detail);
    }

}
