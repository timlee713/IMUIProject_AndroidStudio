package browan.myapplication;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by junli on 14/12/1.
 */
public class MoveGroupAdapter extends BaseAdapter {
    //private final LayoutInflater m_layoutInflater;
    private Context m_context;
    private static final int TYPE_GRP_ITEM_BEGIN = 0;
    private static final int TYPE_GRP_ITEM = 1;
    private static final int TYPE_MAX_COUNT = TYPE_GRP_ITEM + 1;
    private final List m_list;


    public MoveGroupAdapter(Context context, List list) {
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
        if (position == 0)
        {
            return TYPE_GRP_ITEM_BEGIN;
        } else {
            return TYPE_GRP_ITEM;
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
        if (viewType == TYPE_GRP_ITEM) {
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

        view = ((Activity) m_context).getLayoutInflater().inflate(R.layout.move_group_item, null);
        holder.labelView = (TextView) view.findViewById(R.id.tv_label);
        holder.headerView = (TextView) view.findViewById(R.id.tv_headview);

        view.setTag(holder);
        return view;
    }

    public class ViewHolder
    {
        public TextView headerView;
        public TextView labelView;
        public Button marknameSettingBtn;
        public ImageButton delGroupBtn;
        public TextView devideLine;
    }
}
