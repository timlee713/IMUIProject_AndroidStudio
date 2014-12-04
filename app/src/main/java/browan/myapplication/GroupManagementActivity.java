package browan.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GroupManagementActivity extends Activity {

    ListView m_listView;
    GroupManagementAdapter m_adapter;
    List m_list;
    Button m_btnDone;
    ImageButton m_btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        initView();
    }

    private void initView()
    {
        m_btnBack = (ImageButton) findViewById(R.id.btn_back);
        m_btnDone = (Button) findViewById(R.id.btn_done);
        m_btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GroupManagementActivity.this, FriendSettingActivity.class);
                startActivity(intent);
            }
        });
        m_listView = (ListView) findViewById(R.id.group_manage_list);
        fillList();
        m_adapter = new GroupManagementAdapter(this, m_list);
        m_listView.setAdapter(m_adapter);
    }

    private void fillList()
    {
        String[] items = {"添加分组", "我的好友", "亲人", "邻居", "默认分组"};
        //String[] items = {"添加分组", "默认分组"};
        m_list =  Arrays.asList(items);
    }
}
