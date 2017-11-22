package master.fitpaws;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import adapters.fitpaws.TemperatureRecyclerAdapter;
import sql.fitpaws.DatabaseHelper;

import static master.fitpaws.ControlActivity.temperaturesList;

/**
 * Created by domin on 10/21/2017.
 */

public class TemperatureListActivity extends AppCompatActivity {

    private AppCompatActivity activity = TemperatureListActivity.this;
    private AppCompatTextView textViewName;
    private RecyclerView recyclerViewUsers;
//    private List<User> listUsers;
    private List<Temperatures> listTemps;
    private TemperatureRecyclerAdapter temperatureRecyclerAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        initViews();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);
        recyclerViewUsers = (RecyclerView) findViewById(R.id.recyclerViewUsers);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listTemps = temperaturesList;
        temperatureRecyclerAdapter = new TemperatureRecyclerAdapter(listTemps);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewUsers.setLayoutManager(mLayoutManager);
        recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerViewUsers.setHasFixedSize(true);
        recyclerViewUsers.setAdapter(temperatureRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);

        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText(emailFromIntent);

//        getDataFromSQLite();
    }

    /**
     * This method is to fetch all user records from SQLite
     */
//    private void getDataFromSQLite() {
//        // AsyncTask is used that SQLite operation not blocks the UI Thread.
//        new AsyncTask<Void, Void, Void>() {
//            @Override
//            protected Void doInBackground(Void... params) {
//                listUsers.clear();
//                listUsers.addAll(databaseHelper.getAllUser());
//
//                return null;
//            }
//
//            @Override
//            protected void onPostExecute(Void aVoid) {
//                super.onPostExecute(aVoid);
//                temperatureRecyclerAdapter.notifyDataSetChanged();
//            }
//        }.execute();
//    }
}
