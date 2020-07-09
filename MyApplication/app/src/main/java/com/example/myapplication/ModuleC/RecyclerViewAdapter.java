package life.vishalsingh.ModuleC;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.LinkedList;
import life.vishalsingh.R;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private LinkedList<String> mWordList;
    private LayoutInflater mInflater;
    private RecyclerViewAdapter mAdapter;

    public RecyclerViewAdapter(Context context,
                               LinkedList<String> wordList) {
        mInflater = LayoutInflater.from(context);
        this.mWordList = wordList;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvWord;

        public ViewHolder(@NonNull View itemView, RecyclerViewAdapter adapter) {
            super(itemView);
            tvWord = itemView.findViewById(R.id.tv_recycler_view_item);
            mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
// Use that to access the affected item in mWordList.
            String element = mWordList.get(mPosition);
// Change the word in the mWordList.
            mWordList.set(mPosition, "Clicked! " + element);
// Notify the adapter, that the data has changed so it can
// update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.recycler_view_list_item,
                parent, false);
        return new ViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String mCurrent = mWordList.get(position);
        holder.tvWord.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


}
