package cn.paxos.judy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import cn.paxos.judy.domain.ChatMessage;
import cn.paxos.judy.domain.ChatSession;
import cn.paxos.judy.domain.User;

/**
 * Created by mergen on 16-5-28.
 */
public class ChatFragment extends Fragment {

    private ChatSession session;

    public void setSession(ChatSession session) {
        this.session = session;
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        System.out.println("Chat " + session.getId());
        final int fragmentId = R.layout.fragment_chat;
        View rootView = inflater.inflate(fragmentId, container, false);
        ListView listView = (ListView) rootView.findViewById(R.id.listView_messages);
        listView.setAdapter(new MessagesAdapter(rootView.getContext(), session.getMessages()));
        return rootView;
    }

    public final class ViewHolder{
        public TextView time;
        public TextView message;
    }

    public class MessagesAdapter extends BaseAdapter {

        private final LayoutInflater mInflater;
        private final List<ChatMessage> messages;

        public MessagesAdapter(Context context, List<ChatMessage> messages) {
            this.mInflater = LayoutInflater.from(context);
            this.messages = messages;
        }

        @Override
        public int getCount() {
            return messages.size();
        }

        @Override
        public Object getItem(int position) {
            return messages.get(position);
        }

        @Override
        public long getItemId(int position) {
            return messages.get(position).getId();
        }

        @Override
        public int getViewTypeCount() {
            return 2;
        }

        @Override
        public int getItemViewType(int position) {
            return messages.get(position).getReceiverType().equals(User.class) ? 1 : 2;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder=new ViewHolder();
                if (messages.get(position).getReceiverType().equals(User.class)) {
                    convertView = mInflater.inflate(R.layout.list_messages_left, null);
                } else {
                    convertView = mInflater.inflate(R.layout.list_messages_right, null);
                }
                holder.time = (TextView)convertView.findViewById(R.id.message_time);
                holder.message = (TextView)convertView.findViewById(R.id.message_content);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder)convertView.getTag();
            }
            final ChatMessage message = messages.get(position);
            holder.time.setText(Long.toString(message.getTime()));
            holder.message.setText(message.getMessage());
            return convertView;
        }
    }

}
