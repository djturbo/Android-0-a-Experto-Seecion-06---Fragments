package cityworld.sec04.fjarquellada.es.sec06fragments.activity;

import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cityworld.sec04.fjarquellada.es.sec06fragments.R;
import cityworld.sec04.fjarquellada.es.sec06fragments.fragment.DetailFragment;

public class DetailActivity extends FragmentActivity {

    private DetailFragment detailFragment;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        this.detailFragment = (DetailFragment)getSupportFragmentManager().findFragmentById(R.id.frgmntDetail);

        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            String detail = bundle.getString("detail");
            this.detailFragment.populateData(detail);
        }
    }
}
