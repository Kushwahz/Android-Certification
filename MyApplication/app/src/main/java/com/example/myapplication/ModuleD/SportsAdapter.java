package life.vishalsingh.ModuleD;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import life.vishalsingh.R;

public class SportsAdapter extends RecyclerView.Adapter<SportsAdapter.MyViewHolder> {
    private ArrayList<Sport> sports = new ArrayList<Sport>();
    private Context context;

    SportsAdapter(Context c, ArrayList<Sport> sports) {
        this.context = c;
        this.sports = sports;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view  = layoutInflater.inflate(R.layout.sports_item_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Sport currentSport = sports.get(position);
        Glide.with(context).load(currentSport.getImage()).into(holder.imageView);
        holder.title.setText(currentSport.getTitle());
        holder.description.setText(currentSport.getBody());
    }

    @Override
    public int getItemCount() {
        return sports.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView title;
        TextView description;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.sport_image);
            title = itemView.findViewById(R.id.tv_sport_title);
            description = itemView.findViewById(R.id.tv_sport_body);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            Toast.makeText(context, title.getText(), Toast.LENGTH_SHORT).show();
        }
    }
}
