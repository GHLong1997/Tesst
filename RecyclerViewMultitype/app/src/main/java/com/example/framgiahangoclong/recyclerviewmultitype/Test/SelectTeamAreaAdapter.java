package com.example.framgiahangoclong.recyclerviewmultitype.Test;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.framgiahangoclong.recyclerviewmultitype.R;

import java.util.List;

public class SelectTeamAreaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context mContext;
    private List<Object> mObjects;

    public static final int AREA1 = 1;
    public static final int AREA2 = 2;

    public SelectTeamAreaAdapter(Context context, List<Object> objects) {
        mContext = context;
        mObjects = objects;
    }


    @Override
    public int getItemViewType(int position) {
        if (mObjects.get(position) instanceof String) {
            return AREA1;
        }else if (mObjects.get(position) instanceof Integer) {
            return AREA2;
        }else {
            return -1;
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case AREA1:
                View view = inflater.inflate(R.layout.item_layout_first_area, parent, false);
                return new Area1(view);
            case AREA2:
                View view2 = inflater.inflate(R.layout.item_layout_second_area, parent, false);
                return new Area1(view2);
            default:
                break;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case AREA1:
                Area1 area1 = (Area1) holder;
                break;
            case AREA2:
                Area1 area2 = (Area1) holder;


        }
    }


    @Override
    public int getItemCount() {
        return mObjects.size();
    }

    public class Area1 extends RecyclerView.ViewHolder {
        TextView textView;
        public Area1(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "haha", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }

    public class Area2 extends RecyclerView.ViewHolder {
        TextView textView;
        public Area2(View itemView) {
            super(itemView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "haha1", Toast.LENGTH_SHORT).show();
                }
            });

        }
    }
}
