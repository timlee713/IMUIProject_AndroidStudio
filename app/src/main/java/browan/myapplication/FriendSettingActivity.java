package browan.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;


public class FriendSettingActivity extends Activity {

    ListView m_listView;
    FriendSettingAdapter m_adapter;
    List m_list;
    ImageButton m_btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friend_setting);
        initView();
    }

    private void initView()
    {
        m_btnBack = (ImageButton) findViewById(R.id.btn_back);
        m_btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FriendSettingActivity.this, MoveGroupActivity.class);
                startActivity(intent);
            }
        });
        m_listView = (ListView) findViewById(R.id.group_manage_list);
        fillList();
        m_adapter = new FriendSettingAdapter(this, m_list);
        m_listView.setAdapter(m_adapter);
    }

    private void fillList()
    {
        String[] items = {"设置备注名", "动态权限设置", "分组", "删除聊天记录"};
        m_list =  Arrays.asList(items);
    }
}
