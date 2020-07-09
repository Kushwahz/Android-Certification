package life.vishalsingh.ModuleC;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.LinkedList;

import life.vishalsingh.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TabLayoutFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TabLayoutFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TabLayoutFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TabLayoutFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static TabLayoutFragment2 newInstance(String param1, String param2) {
        TabLayoutFragment2 fragment = new TabLayoutFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter mAdapter;
    private FloatingActionButton floatingActionButton;

    private final LinkedList<String> mWordList = new LinkedList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tab_layout2, container, false);
        for (int i = 0; i < 50; i++) {
            mWordList.addLast("Word " + i);
        }
        // Inflate the layout for this fragment

        // Get a handle to the RecyclerView.
        mRecyclerView = view.findViewById(R.id.recycler_view);
        // Create an adapter and supply the data to be displayed.
        mAdapter = new RecyclerViewAdapter(getContext(), mWordList);
        // Connect the adapter with the RecyclerView.
        mRecyclerView.setAdapter(mAdapter);
        // Give the RecyclerView a default layout manager.
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        floatingActionButton = view.findViewById(R.id.floating_btn);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wordListSize = mWordList.size();
                // Add a new word to the wordList.
                mWordList.addLast("+ Word " + wordListSize);
                // Notify the adapter, that the data has changed.
                mRecyclerView.getAdapter().notifyItemInserted(wordListSize);
                // Scroll to the bottom.
                mRecyclerView.smoothScrollToPosition(wordListSize);
            }
        });

        return view;
    }
}