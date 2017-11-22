package adapters.fitpaws;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import master.fitpaws.HeartRates;
import master.fitpaws.R;
import master.fitpaws.Temperatures;

/**
 * Created by domin on 10/21/2017.
 */

public class HeartRateRecyclerAdapter extends RecyclerView.Adapter<HeartRateRecyclerAdapter.UserViewHolder> {

    private List<HeartRates> HeartRates;

    public HeartRateRecyclerAdapter(List<HeartRates> listHR) {
        this.HeartRates = listHR;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hr_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textViewName.setText(HeartRates.get(position).getHeartRate());
        holder.textViewEmail.setText(HeartRates.get(position).getDate());

    }

    @Override
    public int getItemCount() {
        Log.v(HeartRateRecyclerAdapter.class.getSimpleName(),""+HeartRates.size());
        return HeartRates.size();
    }


    /**
     * ViewHolder class
     */
    public class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
//        public AppCompatTextView textViewPassword;

        public UserViewHolder(View view) {
            super(view);
            textViewName = (AppCompatTextView) view.findViewById(R.id.heartRateTextViewName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.heartRateTextViewEmail);
//            textViewPassword = (AppCompatTextView) view.findViewById(R.id.textViewPassword);
        }
    }


}