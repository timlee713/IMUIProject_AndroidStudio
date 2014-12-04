package browan.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by junli on 14/12/1.
 */
public class GroupManagementAdapter extends BaseAdapter {
    //private final LayoutInflater m_layoutInflater;
    private Context m_context;
    private static final int TYPE_GRP_BEGIN = 0;
    private static final int TYPE_GRP_MIDDLE = 1;
    private static final int TYPE_GRP_END = 2;
    private static final int TYPE_MAX_COUNT = TYPE_GRP_END + 1;
    private final List m_list;

    private static final String STR_DEFAULT = "默认分组";

    public GroupManagementAdapter(Context context, List list) {
        //m_layoutInflater = LayoutInflater.from(context);
        this.m_context = context;
        m_list = list;

    }

    @Override
    public int getCount() {
        return m_list.size();
    }

    @Override
    public Object getItem(int position) {
        return m_list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        if (m_list.get(position).equals(STR_DEFAULT))
        {
            return TYPE_GRP_END;
        } else if (position == 0)
        {
            return TYPE_GRP_BEGIN;
        } else {
            return TYPE_GRP_MIDDLE;
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        int viewType = getItemViewType(position);
        if (convertView == null)
        {
            convertView = createView(viewType);
        }
        holder = (ViewHolder) convertView.getTag();
        if (viewType == TYPE_GRP_MIDDLE) {
            holder.headerView.setVisibility(View.GONE);
        } else {
            holder.headerView.setVisibility(View.VISIBLE);
        }
        holder.labelView.setText(m_list.get(position).toString());


        return convertView;
    }

    private View createView(final int viewType) {
        ViewHolder holder = new ViewHolder();
        View view;
        if (viewType == TYPE_GRP_BEGIN)
        {
            view = ((Activity) m_context).getLayoutInflater().inflate(R.layout.group_manage_add, null);
            holder.labelView = (TextView) view.findViewById(R.id.tv_label);
            holder.addGroupBtn = (ImageButton) view.findViewById(R.id.btn_group_add);
            holder.headerView = (TextView) view.findViewById(R.id.tv_headview);
            holder.addGroupBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(m_context, "add group", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            view = ((Activity) m_context).getLayoutInflater().inflate(R.layout.group_manage_del, null);
            holder.headerView = (TextView) view.findViewById(R.id.tv_headview);
            holder.labelView = (TextView) view.findViewById(R.id.tv_label);
            holder.delGroupBtn = (ImageButton) view.findViewById(R.id.btn_group_del);
            holder.delGroupBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (viewType == TYPE_GRP_END)
                    {
                        Toast.makeText(m_context, "默认分组不能删除", Toast.LENGTH_SHORT).show();
                    }
                    Toast.makeText(m_context, "delete group", Toast.LENGTH_SHORT).show();
                }
            });

        }
        view.setTag(holder);
        return view;
    }

    public class ViewHolder
    {
        public TextView headerView;
        public TextView labelView;
        public ImageButton addGroupBtn;
        public ImageButton delGroupBtn;
        public TextView devideLine;
    }
}
