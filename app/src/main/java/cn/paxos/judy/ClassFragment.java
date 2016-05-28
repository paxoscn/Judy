package cn.paxos.judy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cn.paxos.judy.domain.ClassInstance;
import cn.paxos.judy.domain.Clazz;
import cn.paxos.judy.domain.User;

/**
 * Created by mergen on 16-5-28.
 */
public class ClassFragment extends Fragment {

    private final Clazz viewedClass;

    public ClassFragment() {
        viewedClass = User.getCurrentUser().selectDefaultClass();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        int fragment = R.layout.fragment_class;
        View rootView = inflater.inflate(fragment, container, false);
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_launcher);
        toolbar.setTitle(viewedClass.getName());
        toolbar.setSubtitle(viewedClass.getTeacher().getName());
        toolbar.inflateMenu(R.menu.menu_main);
        ListView listView = (ListView) rootView.findViewById(R.id.listView);
        listView.setAdapter(new InstancesAdapter(rootView.getContext(), viewedClass.listInstances()));
        return rootView;
    }

    public void showInfo(){
        new AlertDialog.Builder(this.getContext())
                .setTitle("我的listview")
                .setMessage("介绍...")
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }

    public final class ViewHolder{
        public ImageView img;
        public TextView title;
        public TextView info;
        public Button viewBtn;
    }

    public class InstancesAdapter extends BaseAdapter {

        private final LayoutInflater mInflater;
        private final List<ClassInstance> instances;

        public InstancesAdapter(Context context, List<ClassInstance> instances) {
            this.mInflater = LayoutInflater.from(context);
            this.instances = instances;
        }

        @Override
        public int getCount() {
            return instances.size();
        }

        @Override
        public Object getItem(int position) {
            return instances.get(position);
        }

        @Override
        public long getItemId(int position) {
            return instances.get(position).getId();
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder=new ViewHolder();
                convertView = mInflater.inflate(R.layout.list_class_instances, null);
                holder.img = (ImageView)convertView.findViewById(R.id.img);
                holder.title = (TextView)convertView.findViewById(R.id.title);
                holder.info = (TextView)convertView.findViewById(R.id.info);
                holder.viewBtn = (Button)convertView.findViewById(R.id.view_btn);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            ClassInstance instance = instances.get(position);
            ///holder.img.setBackgroundResource(instance.get("img"));
            holder.title.setText("" + instance.getDate());
            ///holder.info.setText(instance.get("info"));
            holder.viewBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInfo();
                }
            });
            return convertView;
        }
    }

}
