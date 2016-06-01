package cn.paxos.judy;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
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
public class ReviewFragment extends Fragment {

    private ClassInstance instance;

    public void setInstance(ClassInstance instance) {
        this.instance = instance;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        System.out.println("Review " + instance.getId());
        final int fragmentId = R.layout.fragment_review;
        View rootView = inflater.inflate(fragmentId, container, false);
        TextView textView = (TextView) rootView.findViewById(R.id.review_text);
        textView.setText("Review " + instance.getId());
        return rootView;
    }

}
