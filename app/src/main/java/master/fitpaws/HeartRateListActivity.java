package master.fitpaws;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import adapters.fitpaws.HeartRateRecyclerAdapter;
import sql.fitpaws.DatabaseHelper;

import static master.fitpaws.ControlActivity.heartRateList;

/**
 * Created by domin on 10/21/2017.
 */

public class HeartRateListActivity extends AppCompatActivity {

    private AppCompatActivity activity = HeartRateListActivity.this;
    private AppCompatTextView hrTextViewName;
    private RecyclerView recyclerHRViewUsers;
    //    private List<User> listUsers;
    private List<HeartRates> listHR;
    private HeartRateRecyclerAdapter heartRateRecyclerAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_rate_list);
        initViews();
        initObjects();
    }

    /**
     * This method is to initialize views
     */
    private void initViews() {
        hrTextViewName = (AppCompatTextView) findViewById(R.id.hrTextViewName);
        recyclerHRViewUsers = (RecyclerView) findViewById(R.id.recyclerHRViewUsers);
    }

    /**
     * This method is to initialize objects to be used
     */
    private void initObjects() {
        listHR = heartRateList;
        heartRateRecyclerAdapter = new HeartRateRecyclerAdapter(listHR);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerHRViewUsers.setLayoutManager(mLayoutManager);
        recyclerHRViewUsers.setItemAnimator(new DefaultItemAnimator());
        recyclerHRViewUsers.setHasFixedSize(true);
        recyclerHRViewUsers.setAdapter(heartRateRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);

        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        hrTextViewName.setText(emailFromIntent);

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
//                heartRateRecyclerAdapter.notifyDataSetChanged();
//            }
//        }.execute();
//    }
}
