package nyc.c4q.midprogramassesment.controller;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import nyc.c4q.midprogramassesment.R;
import nyc.c4q.midprogramassesment.model.Number;
import nyc.c4q.midprogramassesment.view.NumberViewHolder;

/**
 * Created by amirahoxendine on 12/6/17.
 */

public class NumberAdapter extends RecyclerView.Adapter<NumberViewHolder> {
    private List<Number> numberlist;
    public NumberAdapter(List<Number> numberlist){
        this.numberlist = numberlist;
    }
    @Override
    public NumberViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.number_itemview, parent, false);

        return new NumberViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(final NumberViewHolder holder, int position) {
        Number number = numberlist.get(position);
        holder.onBind(number);


    }

    @Override
    public int getItemCount() {
        return numberlist.size();
    }
}
