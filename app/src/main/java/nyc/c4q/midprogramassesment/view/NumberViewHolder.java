package nyc.c4q.midprogramassesment.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import nyc.c4q.midprogramassesment.LoopActivity;
import nyc.c4q.midprogramassesment.R;
import nyc.c4q.midprogramassesment.fragments.MultipliedNumberFragment;
import nyc.c4q.midprogramassesment.model.Number;

/**
 * Created by amirahoxendine on 12/6/17.
 */

public class NumberViewHolder extends RecyclerView.ViewHolder {
    private TextView numberTextView;
    private Context context;
    String numberString;

    public NumberViewHolder(View itemView) {
        super(itemView);
        numberTextView = (TextView) itemView.findViewById(R.id.number_item_textview);
        context = itemView.getContext();

    }

    public void onBind(final Number number) {
        int numberView = number.getNumber();

         numberString = String.valueOf(numberView);
        numberTextView.setText(numberString);
        numberTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultipliedNumberFragment multipliedNumberFragment = new MultipliedNumberFragment();
                FragmentManager fragmentManager =((FragmentActivity) context).getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Bundle bundle = new Bundle();
                bundle.putString("thisnumber", numberString);
                multipliedNumberFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.listactivity_fragment_container_framelayout, multipliedNumberFragment);
                fragmentTransaction.addToBackStack("next");
                fragmentTransaction.commit();


            }

        });
    }


}
