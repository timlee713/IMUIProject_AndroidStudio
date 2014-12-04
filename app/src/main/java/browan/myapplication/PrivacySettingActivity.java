package browan.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.Arrays;
import java.util.List;


public class PrivacySettingActivity extends Activity {

    ListView m_listView;
    PrivacySettingAdapter m_adapter;
    List m_list;
    ImageButton m_btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_privacy_setting);
        initView();
    }

    private void initView()
    {
        m_btnBack = (ImageButton) findViewById(R.id.btn_back);
        m_btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PrivacySettingActivity.this, ContactActivity.class);
                startActivity(intent);
            }
        });
        m_listView = (ListView) findViewById(R.id.group_manage_list);
        fillList();
        m_adapter = new PrivacySettingAdapter(this, m_list);
        m_listView.setAdapter(m_adapter);
    }
    android.R.style
    private void fillList()
    {
        String[] items = {"不让他（她）看我的动态", "打开后，你公开的动态，对方将无法看到",
        "不看他（她）的动态", "打开后对方发表新的动态，你将无法看到",
        "私密对其可见", "打开后对方将可以看到你的私密记事"};
        m_list =  Arrays.asList(items);
    }
}
