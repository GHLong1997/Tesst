package com.example.framgiahangoclong.recyclerviewmultitype.Example5;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.framgiahangoclong.recyclerviewmultitype.Example4.TeamArea;
import com.example.framgiahangoclong.recyclerviewmultitype.R;

import java.util.List;

public class SelectTeamAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static final int TYPE_AREA = 0;
    public static final int TYPE_TEAM = 1;

    private List<TeamArea> mData;

    public SelectTeamAdapter(List<TeamArea> data) {
        mData = data;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType) {
            case TYPE_AREA:
                View viewArea = inflater.inflate(R.layout.layout_item_header_select_team, parent, false);
                return new AreaViewHolder(viewArea);
            case TYPE_TEAM:
                View viewTeam = inflater.inflate(R.layout.layout_item_content_select_team, parent, false);
                return new TeamViewHolder(viewTeam);
        }
        return null;
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_AREA:
                AreaViewHolder areaViewHolder = (AreaViewHolder) holder;
                areaViewHolder.bindData(mData.get(position));
                break;
            case TYPE_TEAM:
                TeamViewHolder teamViewHolder = (TeamViewHolder) holder;
                teamViewHolder.bindData(mData.get(position));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (mData.get(position).getTeam() == null) {
            return TYPE_AREA;
        }else {
            return TYPE_TEAM;
        }
    }

    static class AreaViewHolder extends RecyclerView.ViewHolder {
        TextView txtAreaName;
        public AreaViewHolder(View itemView) {
            super(itemView);
            txtAreaName = itemView.findViewById(R.id.txt_area_name);
        }

        void bindData(TeamArea teamArea) {
            txtAreaName.setText(teamArea.getAreaName());
        }
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {
        TextView txtTeamName;
        public TeamViewHolder(View itemView) {
            super(itemView);
            txtTeamName = itemView.findViewById(R.id.txt_team_name);
        }

        void bindData(TeamArea teamArea) {
            txtTeamName.setText(teamArea.getTeam().getName());
        }

    }
}
