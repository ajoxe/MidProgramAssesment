package nyc.c4q.midprogramassesment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import nyc.c4q.midprogramassesment.R;
import nyc.c4q.midprogramassesment.controller.NumberAdapter;
import nyc.c4q.midprogramassesment.model.Number;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFirstFragment extends Fragment {
    View rootView;
    TextView displayUserName;
    RecyclerView numberRecyclerView;
    Bundle bundle;


    public ListFirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_list, container, false);
        displayUserName = rootView.findViewById(R.id.textview_display_user);
        bundle = getArguments();
        displayUserName.setText(bundle.getString("currentUser"));

        numberRecyclerView = rootView.findViewById(R.id.list_fragment_recyclerview);
        List<Number> numberList = new ArrayList<>();

        NumberAdapter numberAdapter = new NumberAdapter(numberList);
        LinearLayoutManager linearLayoutManager;
        linearLayoutManager = new LinearLayoutManager(getActivity().getApplicationContext());

        numberRecyclerView.setAdapter(numberAdapter);
        numberRecyclerView.setLayoutManager(linearLayoutManager);





        return rootView;
    }

}
