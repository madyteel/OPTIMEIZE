//This will show the apps in the main locker app people can opt in apps to.
package com.example.myapp;

import android.app.ProgressDialog;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ShowApps extends AppCompatActivity {

    RecyclerView recyclerView;
    List<AppDataSet> appDataSetList = new ArrayList<>();
    AppAdapter adapter;

//    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_show_apps);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recyclerView = findViewById(R.id.recycleView);

        adapter = new AppAdapter(appDataSetList, this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);

//        progressBar = new ProgressBar(this);
//        progressBar.setVisibility(RecyclerView.VISIBLE);
    }

//    @Override
//    protected void onResume(){
//        super.onResume();
//        progressBar.set
    public void getInstalledApps(){
        List<PackageInfo> packageInfos = getPackageManager().getInstalledPackages(0);

        //add to list of appdata
        for (int i = 0; i < packageInfos.size(); i++){
            String name = packageInfos.get(i).applicationInfo.loadLabel(getPackageManager()).toString();
            Drawable icon = packageInfos.get(i).applicationInfo.loadIcon(getPackageManager());
            String packagename = packageInfos.get(i).packageName;

            appDataSetList.add(new AppDataSet(name, icon, 0, packagename));
        }
        adapter.notifyDataSetChanged();
//        if (progressBar.getVisibility() == RecyclerView.VISIBLE){
//        progressBar.setVisibility(RecyclerView.GONE);
        }
}
