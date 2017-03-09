package com.example.vothuong.anhdemo1;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AbsListView.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vothuong.anhdemo1.Adapter.ListViewAdapter;
import com.example.vothuong.anhdemo1.Adapter.ViewPagerAdapter;
import com.example.vothuong.anhdemo1.fragment.Page1_Fragment;
import com.example.vothuong.anhdemo1.fragment.Page2_Fragment;
import com.example.vothuong.anhdemo1.fragment.Page3_Fragment;
import com.example.vothuong.anhdemo1.fragment.Page4_Fragment;
import com.example.vothuong.anhdemo1.fragment.Page5_Fragment;
import com.example.vothuong.anhdemo1.fragment.Page6_Fragment;
import com.example.vothuong.anhdemo1.fragment.Page7_Fragment;
import com.example.vothuong.anhdemo1.fragment.Page8_Fragment;

import java.util.ArrayList;

public class ListViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView listView;
    private ArrayList<String> listResult;
    private ArrayList<Fragment> fragmentList = new ArrayList<Fragment>();
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        listResult = new ArrayList<String>();
        createFakeResult();
        initialView();
    }

    private void createFakeResult() {
        listResult.add("AAAAAAAAAAAAAAAAAAAAAA");
        listResult.add("BBBB");
        listResult.add("CCC");
        listResult.add("DDDDDDDDD");
        listResult.add("EEEEEEEEEEE");
        listResult.add("FFFFF");
        listResult.add("GGGGGGG");
        listResult.add("H");
        listResult.add("I");
        listResult.add("J");
        listResult.add("K");
        listResult.add("L");
        listResult.add("M");
        listResult.add("N");
        listResult.add("O");
        listResult.add("P");
        listResult.add("Q");
    }

    private void initialView(){
        listView = (ListView) findViewById(R.id.list_view);
        View view = getLayoutInflater().inflate(R.layout.list_view_header,null);

        LinearLayout listViewHeader = (LinearLayout) view.findViewById(R.id.list_view_header);
        ListViewAdapter listViewAdapter = new ListViewAdapter(this, listResult);
        listView.addHeaderView(listViewHeader);

        TextView tv = new TextView(this);
        tv.setText("We have no more content.");
        tv.setTextSize(28);
        tv.setGravity(Gravity.CENTER);
        listView.addFooterView(tv);

        viewPager = (ViewPager) findViewById(R.id.list_view_widget);

        fragmentList.add(new Page1_Fragment());
        fragmentList.add(new Page2_Fragment());
        fragmentList.add(new Page3_Fragment());
        fragmentList.add(new Page4_Fragment());
        fragmentList.add(new Page5_Fragment());
        fragmentList.add(new Page6_Fragment());
        fragmentList.add(new Page7_Fragment());
        fragmentList.add(new Page8_Fragment());

        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        viewPagerAdapter.setContent(fragmentList);
        viewPager.setAdapter(viewPagerAdapter);
        listView.setAdapter(listViewAdapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"ListView was clicked at position: " +position,Toast.LENGTH_LONG).show();
        Log.d("testListViewActivity",String.valueOf(position));
    }
}
