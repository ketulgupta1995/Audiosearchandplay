package com.example.ketulgupta.audiosearchandplay;

import android.content.Intent;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.LogPrinter;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.jar.Manifest;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    String[] Countries = new String[]{"India", "Australia", "Newzealand",
            "Indonesia", "China", "Russia", "Japan", "South Korea"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this,new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE},255);
        mListView = (ListView) findViewById(R.id.list_view);
        Log.d("S", Environment.getExternalStorageDirectory().toString());
        File rootFolder=Environment.getExternalStorageDirectory();
//        File downloads=Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//        Log.d("S", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).toString());
        List<File >allFiles =getListFiles(rootFolder);
//        for (int i=0;i<allFiles.size();i++)
//        {
//            Log.d("F",allFiles.get(i).getName());
//        }
        ArrayAdapter<String> countryAdapter =new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,Countries);
        mListView.setAdapter(countryAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this,Countries[i],Toast.LENGTH_SHORT).show();
            }
        });
    }

    private List<File> getListFiles(File parentDir){
        List<File> inFiles = new ArrayList<>();
        File [] files= parentDir.listFiles();
        for (File file : files) {
            if (file.isDirectory())
            {
                inFiles.addAll(getListFiles(file));
            }
            else {
                if(file.getName().endsWith(".mp3")){
                    inFiles.add(file);
                    Log.d("F",file.getName());
                }
            }
        }
        return inFiles;
    }


}
