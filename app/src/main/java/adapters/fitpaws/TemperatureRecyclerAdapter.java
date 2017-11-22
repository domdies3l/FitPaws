package adapters.fitpaws;

import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import master.fitpaws.R;
import master.fitpaws.Temperatures;

/**
 * Created by domin on 10/21/2017.
 */

public class TemperatureRecyclerAdapter extends RecyclerView.Adapter<TemperatureRecyclerAdapter.UserViewHolder> {

    private List<Temperatures> listTemps;

    public TemperatureRecyclerAdapter(List<Temperatures> listTemps) {
        this.listTemps = listTemps;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // inflating recycler item view
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user_recycler, parent, false);

        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(UserViewHolder holder, int position) {
        holder.textViewName.setText(listTemps.get(position).getTemperatures());
        holder.textViewEmail.setText(listTemps.get(position).getDate());
//        holder.textViewPassword.setText(listUsers.get(position).getPassword());
    }

    @Override
    public int getItemCount() {
        Log.v(TemperatureRecyclerAdapter.class.getSimpleName(),""+listTemps.size());
        return listTemps.size();
    }


    /**
     * ViewHolder class
     */
    public static class UserViewHolder extends RecyclerView.ViewHolder {

        public AppCompatTextView textViewName;
        public AppCompatTextView textViewEmail;
//        public AppCompatTextView textViewPassword;

        public UserViewHolder(View view) {
            super(view);
            textViewName = (AppCompatTextView) view.findViewById(R.id.textViewName);
            textViewEmail = (AppCompatTextView) view.findViewById(R.id.textViewEmail);
//            textViewPassword = (AppCompatTextView) view.findViewById(R.id.textViewPassword);
        }
    }


}