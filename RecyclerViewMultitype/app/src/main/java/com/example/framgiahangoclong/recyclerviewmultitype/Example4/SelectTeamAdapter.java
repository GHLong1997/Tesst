package com.example.framgiahangoclong.recyclerviewmultitype.Example4;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.framgiahangoclong.recyclerviewmultitype.R;

import java.util.List;

public class SelectTeamAdapter extends RecyclerView.Adapter<SelectTeamAdapter.ViewHolder> {

    private List<TeamArea> mData;

    public SelectTeamAdapter(List<TeamArea> data) {
        mData = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item_select_team, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindData(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtTeamName;
        TextView txtAreaName;
        public ViewHolder(View itemView) {
            super(itemView);
            txtAreaName = itemView.findViewById(R.id.txt_area_name);
            txtTeamName = itemView.findViewById(R.id.txt_team_name);
        }
        void bindData(TeamArea teamArea) {
//            if (teamArea.isArea()) {
//                txtAreaName.setVisibility(View.VISIBLE);
//                txtTeamName.setVisibility(View.GONE);
//                txtAreaName.setText(teamArea.getName());
//            }else {
//                txtAreaName.setVisibility(View.GONE);
//                txtTeamName.setVisibility(View.VISIBLE);
//                txtTeamName.setText(teamArea.getName());
//            }
        }
    }
}
