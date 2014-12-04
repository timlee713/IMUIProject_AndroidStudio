package browan.myapplication;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ContactActivity extends ExpandableListActivity {

    List<String> m_group;           //组列表
    List<List<String>> m_child;     //子列表

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        //initView();
        initializeData();
        getExpandableListView().setGroupIndicator(null);
        getExpandableListView().setAdapter(new ContactAdapter(ContactActivity.this, m_group, m_child));
    }

    private void initializeData(){
        m_group = new ArrayList<String>();
        m_child = new ArrayList<List<String>>();

        String[] friend = new String[]{"马云","马化腾"};
        String[] relative = new String[]{"王思聪","李彦宏"};
        String[] stranger = new String[]{"李开复","雷军"};

        addInfo("我的好友 (" + friend.length + ")",friend);
        addInfo("我的亲戚 (" + relative.length + ")",relative);
        addInfo("陌生人 (" + stranger.length + ")",stranger);

    }

    /**
     * 模拟给组、子列表添加数据
     * @param g-group
     * @param c-child
     */
    private void addInfo(String g,String[] c){
        m_group.add(g);
        List<String> childitem = new ArrayList<String>();
        for(int i=0;i<c.length;i++){
            childitem.add(c[i]);
        }
        m_child.add(childitem);
    }

}
