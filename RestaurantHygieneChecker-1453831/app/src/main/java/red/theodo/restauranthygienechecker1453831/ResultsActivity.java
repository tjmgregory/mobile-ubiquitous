package red.theodo.restauranthygienechecker1453831;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    public static String RESULTS_STRING = "search";

    FragmentManager fm = getFragmentManager();

    private ArrayList<Establishment> searchResults;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment chosenFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_list:
                    chosenFragment = EstablishmentListFragment.newInstance(searchResults);
                    break;
                case R.id.navigation_map:
                    chosenFragment = EstablishmentMapFragment.newInstance(searchResults);
                    break;
            }
            fm.beginTransaction().replace(R.id.listMapFragment, chosenFragment).commit();
            return true;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        searchResults = getIntent().getParcelableArrayListExtra(RESULTS_STRING);

        EstablishmentListFragment list = EstablishmentListFragment.newInstance(searchResults);
        fm.beginTransaction().add(R.id.listMapFragment, list).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
