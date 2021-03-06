package cn.paxos.judy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
        ClassInstancesFragment classInstancesFragment = new ClassInstancesFragment();
        classInstancesFragment.setViewedClass(viewedClass);
        this.getFragmentManager().beginTransaction().add(R.id.frame_container_class, classInstancesFragment).commit();
        return rootView;
    }

}
