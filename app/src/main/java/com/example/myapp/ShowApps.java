//This will show the apps in the main locker app people can opt in apps to.
package com.example.myapp;

import android.app.ProgressDialog;
import android.content.pm.PackageInfo;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Build;
import android.widget.ProgressBar;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.pm.PackageManager;
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

        ProgressBar progressBar = new ProgressBar(this);
        progressBar.setVisibility(RecyclerView.VISIBLE);
    }

    @Override
    protected void onResume(){
        super.onResume();
        getInstalledApps();
    }

    public void getInstalledApps(){
        List<PackageInfo> packageInfos;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) { // Android 13+
            packageInfos = getPackageManager().getInstalledPackages(PackageManager.PackageInfoFlags.of(0));
        } else {
            packageInfos = getPackageManager().getInstalledPackages(0);
        }

        appDataSetList.clear(); // Clear list before adding new items

        for (PackageInfo packageInfo : packageInfos) {
            String name = packageInfo.applicationInfo.loadLabel(getPackageManager()).toString();
            Drawable icon = packageInfo.applicationInfo.loadIcon(getPackageManager());
            String packagename = packageInfo.packageName;

            appDataSetList.add(new AppDataSet(name, icon, 0, packagename));
        }

        adapter.notifyDataSetChanged();
    }
}
