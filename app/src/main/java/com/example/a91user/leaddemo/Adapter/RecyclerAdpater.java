package com.example.a91user.leaddemo.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.a91user.leaddemo.Model.Unit;
import com.example.a91user.leaddemo.R;

import java.util.ArrayList;


public class RecyclerAdpater extends RecyclerView.Adapter<RecyclerAdpater.MyViewHolder> {

    //var
    Context context;
    ArrayList<Unit> unitList;
    private OnUnitListener monUnitListener;

    public RecyclerAdpater(Context context, ArrayList<Unit> unitList, OnUnitListener onUnitListener) {
        this.context = context;
        this.unitList = unitList;
        this.monUnitListener = onUnitListener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.cardview, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view, monUnitListener);
        return (myViewHolder);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.UnitName.setText(unitList.get(i).getUnitName());
        (myViewHolder).UnitNumber.setText(unitList.get(i).getUnitNumber());
    }

    @Override
    public int getItemCount() {
        return unitList.size();
    }

    // Interface  for recycler view click listener
    public interface OnUnitListener {
        void onUnitClick(int position);

    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnUnitListener onUnitListener;
        TextView UnitName;
        TextView UnitNumber;

        public MyViewHolder(@NonNull View itemView, OnUnitListener onUnitListener) {
            super(itemView);

            //ui element --> card view
            UnitName = itemView.findViewById(R.id.unitName);
            UnitNumber = itemView.findViewById(R.id.unitNumber);
            this.onUnitListener = onUnitListener;

            //attach OnClick Listener to the whole Unit
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            onUnitListener.onUnitClick(getAdapterPosition());

        }
    }

}
