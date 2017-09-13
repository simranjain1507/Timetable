package com.example.android.indinetworktask;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by simranjain1507 on 12/09/17.
 */

public class GridviewAdapter extends BaseAdapter {

    String[] subjects, periods;
    String[] backgroundColor;
    private Context mContext;

    public GridviewAdapter(Context context, String[] subjects, String[] periods, String[] backgroundColor) {
        this.mContext = context;
        this.subjects = subjects;
        this.periods = periods;
        this.backgroundColor = backgroundColor;
    }

    @Override
    public int getCount() {
        return subjects.length;
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Holder holder = new Holder();
        View rowview = view;
        if (view == null) {
            rowview = LayoutInflater.from(mContext).inflate(R.layout.item, null);


        }
        holder.subjectText = rowview.findViewById(R.id.tv_subject);
        holder.periodText = rowview.findViewById(R.id.tv_period);
        holder.linearLayout = rowview.findViewById(R.id.ll_item);

        holder.subjectText.setText(subjects[i]);
        holder.periodText.setText(periods[i]);
        holder.linearLayout.setBackgroundColor(Color.parseColor(backgroundColor[i]));

        return rowview;

    }

    public class Holder {
        TextView subjectText, periodText;
        LinearLayout linearLayout;

    }
}
