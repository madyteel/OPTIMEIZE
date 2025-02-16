package com.example.myapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.adapter_design_backend> {

    List<AppDataSet> appDataSets = new ArrayList<>();
    Context context;

    public AppAdapter(List<AppDataSet> appDataSets, Context context){
        this.appDataSets = appDataSets;
        this.context = context;
    }
    @NonNull
    @Override
    public adapter_design_backend onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.adapterdesign, parent, false);
        adapter_design_backend design = new adapter_design_backend(view);
        return design;
    }

    @Override
    public void onBindViewHolder(@NonNull adapter_design_backend holder, int position) {
        AppDataSet app = appDataSets.get(position);

        holder.appname.setText(app.getAppname());
        holder.appicon.setImageDrawable(app.getAppIcon());

       if (app.getStatus() == 0){
           holder.status.setImageResource(R.drawable.baseline_check_24);
       }
       else{
           holder.status.setImageResource(R.drawable.baseline_block_24);
       }

    }

    @Override
    public int getItemCount() {
        return appDataSets.size();
    }

    public class adapter_design_backend extends RecyclerView.ViewHolder{

        TextView appname;
        ImageView appicon, status;
        public adapter_design_backend(@NonNull View itemView) {
            super(itemView);
            appname = itemView.findViewById(R.id.Appname);
            appicon = itemView.findViewById(R.id.AppIcon);
            status = itemView.findViewById(R.id.StatusIcon);



        }
    }
}
