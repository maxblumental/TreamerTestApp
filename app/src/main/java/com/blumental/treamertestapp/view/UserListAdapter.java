package com.blumental.treamertestapp.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.blumental.treamertestapp.R;
import com.blumental.treamertestapp.model.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static android.support.v4.content.res.ResourcesCompat.getColor;
import static java.lang.String.format;

class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<User> users;

    private View.OnClickListener itemClickListener;

    public UserListAdapter(View.OnClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bind(users.get(position));
    }

    @Override
    public int getItemCount() {
        return users == null ? 0 : users.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(android.R.id.text1)
        TextView name;

        @BindView(android.R.id.text2)
        TextView username;

        ViewHolder(View itemView, View.OnClickListener listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            initializeItemView(itemView);
            itemView.setOnClickListener(listener);
        }

        void bind(User user) {
            itemView.setTag(user);
            name.setText(user.getName());
            username.setText(format("@%s", user.getUsername()));
        }

        private void initializeItemView(View itemView) {
            itemView.setBackgroundResource(R.drawable.user_list_item);
            itemView.setClickable(true);

            int textColor = getColor(itemView.getResources(), R.color.secondaryText, null);
            username.setTextColor(textColor);
        }
    }
}
