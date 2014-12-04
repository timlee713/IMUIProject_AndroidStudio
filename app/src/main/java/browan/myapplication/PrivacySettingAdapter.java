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

import java.util.List;

/**
 * Created by junli on 14/12/1.
 */
public class PrivacySettingAdapter extends BaseAdapter {
    //private final LayoutInflater m_layoutInflater;
    private Context m_context;
    private static final int TYPE_GRP_BEGIN = 0;
    private static final int TYPE_GRP_MIDDLE = 1;
    private static final int TYPE_GRP_END = 2;
    private static final int TYPE_MAX_COUNT = TYPE_GRP_END + 1;
    private final List m_list;

    private static final String STR_DEFAULT = "默认分组";

    public PrivacySettingAdapter(Context context, List list) {
        this.m_context = context;
        m_list = list;

    }

    @Override
    public int getCount() {
        return m_list.size()/2;
    }

    @Override
    public Object getItem(int position) {
        return m_list.get(position*2);
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
        } else {
        }
        if (position < m_list.size()/2) {
            holder.labelView.setText(m_list.get(position * 2).toString());
            holder.subLabelView.setText(m_list.get(position * 2 + 1).toString());
        }
        return convertView;
    }

    private View createView(final int viewType) {
        ViewHolder holder = new ViewHolder();
        View view;
        view = ((Activity) m_context).getLayoutInflater().inflate(R.layout.privacy_setting_item, null);
        holder.labelView = (TextView) view.findViewById(R.id.tv_label);
        holder.subLabelView = (TextView) view.findViewById(R.id.tv_sub_label);
        view.setTag(holder);
        return view;
    }

    public class ViewHolder
    {
        public TextView headerView;
        public TextView labelView;
        public TextView subLabelView;
        public Button marknameSettingBtn;
        public ImageButton delGroupBtn;
        public TextView devideLine;
    }
}
