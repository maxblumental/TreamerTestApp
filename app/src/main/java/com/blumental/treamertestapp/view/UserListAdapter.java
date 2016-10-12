package com.blumental.treamertestapp.view;

import android.content.res.Resources;
import android.support.v4.content.res.ResourcesCompat;
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

import static java.lang.String.format;

class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.ViewHolder> {

    private List<User> users;

    public void setUsers(List<User> users) {
        this.users = users;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(android.R.layout.simple_list_item_2, parent, false);
        return new ViewHolder(view);
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

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            setSecondaryTextColor(itemView.getResources());
        }

        void bind(User user) {
            name.setText(user.getName());
            username.setText(format("@%s", user.getUsername()));
        }

        private void setSecondaryTextColor(Resources resources) {
            int textColor = ResourcesCompat.getColor(resources, R.color.secondaryText, null);
            username.setTextColor(textColor);
        }
    }
}
