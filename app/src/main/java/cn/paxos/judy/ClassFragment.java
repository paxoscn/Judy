package cn.paxos.judy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

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
        return rootView;
    }

}
