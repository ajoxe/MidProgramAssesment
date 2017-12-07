package nyc.c4q.midprogramassesment.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import nyc.c4q.midprogramassesment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MultipliedNumberFragment extends Fragment {
    View rootView;
    Bundle bundle;
    TextView multipliedNumber;

    public MultipliedNumberFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView =  inflater.inflate(R.layout.fragment_multiplied_number, container, false);
        bundle = getArguments();
        String passedNumber = bundle.getString("thisnumber");
        int preMultiple = Integer.valueOf(passedNumber);
        int multiplied = preMultiple * 10;
        multipliedNumber = (TextView) rootView.findViewById(R.id.number_fragment_textview);
        multipliedNumber.setText(String.valueOf(multiplied));
        return rootView;
    }

}
