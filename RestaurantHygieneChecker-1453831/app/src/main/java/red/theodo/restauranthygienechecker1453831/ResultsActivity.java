package red.theodo.restauranthygienechecker1453831;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    private TextView mTextMessage;
    FragmentManager fm = getFragmentManager();

    private ArrayList<Establishment> searchResults;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment chosenFragment = null;
            switch (item.getItemId()) {
                case R.id.navigation_list:
                    chosenFragment = ListFragment.newInstance(searchResults);
                    mTextMessage.setText("List");
                    break;
                case R.id.navigation_map:
                    // TODO Will cause crash until chosenFragment is set here.
                    presentMap();
                    mTextMessage.setText("Map");
                    break;
            }
            fm.beginTransaction().replace(R.id.listMapFragment, chosenFragment).commit();
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        mTextMessage = (TextView) findViewById(R.id.message);

        searchResults = performSearch();

        ListFragment list = ListFragment.newInstance(searchResults);
        fm.beginTransaction().add(R.id.listMapFragment, list).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    // TODO
    private void presentMap() {

    }

    // TODO
    private ArrayList<Establishment> performSearch() {
        ArrayList<Establishment> searchResults = new ArrayList<>();
        searchResults.add(EstablishmentBuilder.anEstablishment()
                .withName("Roosters")
                .withRating("5")
                .build());
        searchResults.add(EstablishmentBuilder.anEstablishment()
            .withName("Dixies")
            .withRating("4")
            .build());

        return searchResults;
    }

}