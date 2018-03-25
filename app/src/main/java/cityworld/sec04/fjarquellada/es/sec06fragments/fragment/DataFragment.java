package cityworld.sec04.fjarquellada.es.sec06fragments.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import cityworld.sec04.fjarquellada.es.sec06fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment implements View.OnClickListener{

    private static final String TAG = "DataFragment";


    private EditText editTextDetail;
    private Button btnSend;
    private DataListener callback;

    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_data, container, false);

        bindUI(view);

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try{
            callback = (DataListener) context;
        }catch(Exception ex){
            Log.e(TAG, ex.getMessage());
            throw new ClassCastException("Error al obtener el callback que impelmenta de la interface DataListener");
        }
    }

    private void bindUI(View view) {
        this.editTextDetail = view.findViewById(R.id.editTextDetail);
        this.btnSend        = view.findViewById(R.id.btnSend);

        this.btnSend.setOnClickListener(this);
    }

    void sendDetail(){
        String detail = editTextDetail.getText().toString();
        callback.sendData(detail);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == this.btnSend.getId()){
            sendDetail();
        }
    }

}
