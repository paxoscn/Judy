package cn.paxos.judy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import cn.paxos.judy.domain.ClassInstance;
import cn.paxos.judy.domain.Clazz;
import cn.paxos.judy.domain.Institution;
import cn.paxos.judy.domain.User;

/**
 * Created by mergen on 16-5-28.
 */
public class ClassFragment extends Fragment {

    private Clazz viewedClass;

    public ClassFragment() {
        viewedClass = User.getCurrentUser().selectDefaultClass();
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        final int fragmentId = R.layout.fragment_class;
        View rootView = inflater.inflate(fragmentId, container, false);
        Toolbar toolbar = (Toolbar) rootView.findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_launcher);
        toolbar.setTitle(viewedClass.getName());
        toolbar.setSubtitle(String.format("%s老师", viewedClass.getTeacher().getName()));
        MenuItem.OnMenuItemClickListener onMenuItemClickListener = new MenuItem.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                ClassFragment fragment = ClassFragment.this;
                fragment.viewedClass = Institution.instance.getClasses().get(item.getItemId());
                ///fragment.onCreateView(inflater, container, savedInstanceState);
                fragment.getFragmentManager().beginTransaction().detach(fragment).attach(fragment).commit();
                /*
                FragmentManager fm = fragment.getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                String fragmentTag = fragment.getTag();
                ft.remove(ClassFragment.this);
                ft.add(container.getId(), fragment, fragmentTag);
                ft.attach(fragment);
                ft.commit();
                */
                return true;
            }
        };
        toolbar.inflateMenu(R.menu.menu_main);
        Menu menu = toolbar.getMenu().findItem(R.id.action_switch_class).getSubMenu();
        menu.clear();
        int itemIndex = 1;
        for (Clazz clazz : User.getCurrentUser().listOtherClasses(viewedClass)) {
            MenuItem item = menu.add(0, clazz.getId(), itemIndex, String.format("%s %s老师", clazz.getName(), clazz.getTeacher().getName()));
            item.setOnMenuItemClickListener(onMenuItemClickListener);
            itemIndex++;
        }
        ///Drawable drawable = ContextCompat.getDrawable(this.getContext(), R.drawable.ic_launcher);
        ///toolbar.setOverflowIcon(drawable);
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
        public TextView date;
        public TextView time;
        public TextView pending;
        public Button teacherReviewBtn;
        public Button homeworkBtn;
        public Button examBtn;
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
                holder.date = (TextView)convertView.findViewById(R.id.date);
                holder.time = (TextView)convertView.findViewById(R.id.time);
                holder.pending = (TextView)convertView.findViewById(R.id.pending);
                holder.teacherReviewBtn = (Button)convertView.findViewById(R.id.teacher_review_btn);
                holder.homeworkBtn = (Button)convertView.findViewById(R.id.homework_btn);
                holder.examBtn = (Button)convertView.findViewById(R.id.exam_btn);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            ClassInstance instance = instances.get(position);
            ///holder.img.setBackgroundResource(instance.get("img"));
            holder.date.setText(String.format("%02d-%02d", (instance.getTime() / 1000000) % 100, (instance.getTime() / 10000) % 100));
            holder.time.setText(String.format("%02d:%02d", (instance.getTime() / 100) % 100, instance.getTime() % 100));
            // Buffer 5 hours.
            boolean pending = Long.parseLong(new SimpleDateFormat("yyyyMMddHHmm").format(new Date())) < instance.getTime() + 500;
            holder.pending.setVisibility(pending ? View.VISIBLE: View.INVISIBLE);
            holder.teacherReviewBtn.setVisibility(pending || instance.getTeacherReview() == null ? View.INVISIBLE: View.VISIBLE);
            holder.homeworkBtn.setVisibility(pending || instance.getHomework() == null ? View.INVISIBLE: View.VISIBLE);
            holder.examBtn.setVisibility(pending || instance.getExam() == null ? View.INVISIBLE: View.VISIBLE);
            ///holder.info.setText(instance.get("info"));
            holder.teacherReviewBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInfo();
                }
            });
            return convertView;
        }
    }

}
