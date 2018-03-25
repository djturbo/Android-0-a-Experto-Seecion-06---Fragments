package cityworld.sec04.fjarquellada.es.sec06fragments.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.widget.Toast;

import cityworld.sec04.fjarquellada.es.sec06fragments.R;
import cityworld.sec04.fjarquellada.es.sec06fragments.fragment.DataFragment;
import cityworld.sec04.fjarquellada.es.sec06fragments.fragment.DataListener;
import cityworld.sec04.fjarquellada.es.sec06fragments.fragment.DetailFragment;

public class MainActivity extends FragmentActivity implements DataListener{

    private boolean isMultipanel;

    DetailFragment frgmtDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setMultipanel();
        // this.frgmtDetail = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.frgmntDetail);
    }

    private void setMultipanel(){
        isMultipanel = getSupportFragmentManager().findFragmentById(R.id.frgmntDetail) != null;
    }

    @Override
    public void sendData(String data) {
        Toast.makeText(this, "Data from fragment: "+data, Toast.LENGTH_LONG).show();

        if(isMultipanel) {
            this.frgmtDetail.populateData(data);
        }else{
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("detail", data);
            startActivity(intent);
        }
    }
}
