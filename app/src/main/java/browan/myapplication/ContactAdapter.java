package browan.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by junli on 14/12/1.
 */
public class ContactAdapter extends BaseExpandableListAdapter {
    //private final LayoutInflater m_layoutInflater;
    private Context m_context;
    private static final int TYPE_GRP_BEGIN = 0;
    private static final int TYPE_GRP_MIDDLE = 1;
    private static final int TYPE_GRP_END = 2;
    private static final int TYPE_MAX_COUNT = TYPE_GRP_END + 1;
    private final List<String> m_groupList;
    private final List<List<String>> m_childList;

    private static final String STR_DEFAULT = "默认分组";

    public ContactAdapter(Context context, List group, List child) {
        this.m_context = context;
        m_groupList = group;
        m_childList = child;

    }

    @Override
    public int getGroupCount() {
        return m_groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return m_childList.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return m_groupList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return  m_childList.get(groupPosition).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return  childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String string = m_groupList.get(groupPosition);

        ViewHolder holder = null;
        //return getGenericView(string);
        if (convertView == null)
        {
            convertView = createGroupView();
        }
        holder = (ViewHolder) convertView.getTag();
        holder.m_image.setImageResource(R.drawable.ic_contact_right);
        if(isExpanded){
            holder.m_image.setImageResource(R.drawable.ic_contact_down);
        }
        holder.m_name.setText(string);

        return convertView;
    }

    private View createGroupView()
    {
        ViewHolder holder = new ViewHolder();
        View view;

        view = ((Activity) m_context).getLayoutInflater().inflate(R.layout.contact_group_item, null);
        holder.m_image = (ImageView) view.findViewById(R.id.contact_arrow);
        holder.m_name = (TextView) view.findViewById(R.id.contact_group_name);

        view.setTag(holder);
        return view;
    }


    private View createChildView()
    {
        ViewHolder holder = new ViewHolder();
        View view;

        view = ((Activity) m_context).getLayoutInflater().inflate(R.layout.contact_child_item, null);
        holder.m_image = (ImageView) view.findViewById(R.id.contact_photo);
        holder.m_name = (TextView) view.findViewById(R.id.contact_child_name);
        view.setTag(holder);
        return view;
    }


    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String string = m_childList.get(groupPosition).get(childPosition);
        ViewHolder holder = null;
        //return getGenericView(string);
        if (convertView == null)
        {
            convertView = createChildView();
        }
        holder = (ViewHolder) convertView.getTag();
        holder.m_name.setText(string);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class ViewHolder
    {
        ImageView m_image;
        TextView m_name;
    }
}
