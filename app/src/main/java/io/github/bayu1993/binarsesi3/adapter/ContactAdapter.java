package io.github.bayu1993.binarsesi3.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import io.github.bayu1993.binarsesi3.R;
import io.github.bayu1993.binarsesi3.interfaces.ItemClickListener;
import io.github.bayu1993.binarsesi3.pojo.Contact;

/**
 * Created by dell on 3/27/18.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder>{
    private List<Contact> contactList;
    private ItemClickListener itemClickListener;

    public ContactAdapter(List<Contact> contactList, ItemClickListener itemClickListener) {
        this.contactList = contactList;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View viewLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent,false);
        return new ViewHolder(viewLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Contact dataContact = contactList.get(position);
        holder.tvName.setText(dataContact.getName());
        holder.tvPhone.setText(dataContact.getPhone());
        holder.imgProfile.setImageResource(dataContact.getImageProfile());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(dataContact,position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView tvName,tvPhone;
        CircleImageView imgProfile;

        public ViewHolder(View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_name);
            tvPhone = itemView.findViewById(R.id.tv_phone);
            imgProfile = itemView.findViewById(R.id.iv_profile);
        }
    }
}
