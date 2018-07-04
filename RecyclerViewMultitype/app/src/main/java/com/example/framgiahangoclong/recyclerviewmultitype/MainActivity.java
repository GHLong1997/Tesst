package com.example.framgiahangoclong.recyclerviewmultitype;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.example.framgiahangoclong.recyclerviewmultitype.Example4.TeamArea;
import com.example.framgiahangoclong.recyclerviewmultitype.model.Area;
import com.example.framgiahangoclong.recyclerviewmultitype.Example3.SelectTeamAdapter;
import com.example.framgiahangoclong.recyclerviewmultitype.model.Team;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView rvMultipleViewType;
    private List<Area> mData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        DifferentRowAdapter adapter = new DifferentRowAdapter(DummyData.getData());
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, OrientationHelper.VERTICAL, false);
//        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        mRecyclerView.setLayoutManager(linearLayoutManager);
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        mRecyclerView.setAdapter(adapter);

//        List<User> users = new ArrayList<>();
//        users.add(new User("Long", "haha"));
//        users.add(new User("Long1", "haha1"));
        rvMultipleViewType = (RecyclerView) findViewById(R.id.recyclerView);
        mData = new ArrayList<>();
//
//        mData.add(new User("Nguyen Van Nghia", "Quan 11"));
//        mData.add(R.drawable.ic_launcher_background);
//        mData.add("Text 0");
//        mData.add("Text 1");
//        mData.add(new User("Nguyen Hoang Minh", "Quan 3"));
//        mData.add("Text 2");
//        mData.add(R.drawable.ic_launcher_foreground);
//        mData.add(R.drawable.ic_launcher_background);
//        mData.add(new User("Pham Nguyen Tam Phu", "Quan 10"));
//        mData.add("Text 3");
//        mData.add("Text 4");
//        mData.add(new User("Tran Van Phuc", "Quan 1"));
//        mData.add(R.drawable.ic_launcher_foreground);
//        mData.add(R.drawable.ic_launcher_background);
//        mData.add("Text 5");
//        mData.add(new User("Nguyen Ngoc Tien", "Quan 11"));
//        mData.add(R.drawable.ic_launcher_foreground);
//
//
//        mData.add("haha");
//        mData.add(R.drawable.ic_launcher_background);
//        mData.add("haha1");
//        mData.add("haha1");
//        mData.add("haha1");
//        mData.add("haha1");
//        mData.add(R.drawable.ic_launcher_background);
//        mData.add("haha1");
//        mData.add("haha1");
//        mData.add("haha1");
//        mData.add("haha1");
//        mData.add("haha1");
//        mData.add(R.drawable.ic_launcher_background);

        for (int i = 0; i < 4; i++) { // raw data from server
            Area area = new Area();
            area.setId(i);
            area.setName("東地区" + i);
            List<Team> teams = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                Team team = new Team();
                team.setId(j);
                team.setName("KAKA東地" + j);
                team.setArea(area);
                teams.add(team);
            }
            area.setTeamList(teams);
            mData.add(area);
        }
//
//        List<Object> objects = new ArrayList<>();
//        for (int i = 0; i < mData.size(); i++) { //convert data
//            Area area = new Area();
//            area.setId(mData.get(i).getId());
//            area.setName(mData.get(i).getName());
//
//            objects.add(area);
//            objects.addAll(mData.get(i).getTeamList());
//        }

        List<TeamArea> teamAreas = new ArrayList<>();
        for (Area area : mData) {

            TeamArea teamArea = new TeamArea();
            teamArea.setAreaName(area.getName());
            teamAreas.add(teamArea);

            for (Team team : area.getTeamList()) { ;
                TeamArea teamArea1 = new TeamArea();
                teamArea1.setTeam(team);
                teamAreas.add(teamArea1);
            }

        }
        com.example.framgiahangoclong.recyclerviewmultitype.Example5.SelectTeamAdapter adapter = new com.example.framgiahangoclong.recyclerviewmultitype.Example5.SelectTeamAdapter(teamAreas);
//        SelectTeamAdapter adapter = new SelectTeamAdapter(objects);
//        com.example.framgiahangoclong.recyclerviewmultitype.Example4.SelectTeamAdapter adapter = new
//                com.example.framgiahangoclong.recyclerviewmultitype.Example4.SelectTeamAdapter(teamAreas);
        rvMultipleViewType.setLayoutManager(new LinearLayoutManager(this, OrientationHelper.VERTICAL, false));
        rvMultipleViewType.setItemAnimator(new DefaultItemAnimator());
        rvMultipleViewType.setAdapter(adapter);
    }
}
