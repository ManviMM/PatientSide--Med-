package com.example.patient;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdapterItem extends RecyclerView.Adapter<AdapterItem.ViewHolder> {

    ArrayList<Modal> mList;
    Context context;

    public AdapterItem(Context context, ArrayList<Modal> mList) {
        this.mList = mList;
        this.context = context;
    }


    @NonNull
    @Override
    public AdapterItem.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterItem.ViewHolder holder, int position) {

        final String name, address, email, phone, website;

        Modal modal= mList.get(position);
        holder.txtName.setText(modal.getName());
        holder.txtAddress.setText(modal.getAddress());
        holder.txtEmail.setText(modal.getEmail());
        holder.txtPhone.setText(modal.getPhone());
        holder.txtWebsite.setText(modal.getWebsite());

        name = modal.getName();
        address = modal.getAddress();
        email = modal.getEmail();
        phone = modal.getPhone();
        website = modal.getWebsite();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), DisplayHospital.class);
                i.putExtra("Name", name);
                i.putExtra("Address", address);
                i.putExtra("Email", email);
                i.putExtra("Phone", phone);
                i.putExtra("Website", website);
                v.getContext().startActivity(i);

                /*Intent intent = new Intent(v.getContext(), UpiPaymentGateway.class);
                intent.putExtra("name", names);
                v.getContext().startActivity(intent);*/
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtAddress, txtEmail, txtPhone, txtWebsite;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtAddress = itemView.findViewById(R.id.txtAddress);
            txtEmail = itemView.findViewById(R.id.txtEmail);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            txtWebsite = itemView.findViewById(R.id.txtWebsite);

        }
    }
}
