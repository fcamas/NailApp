package io.ria.nailapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.ria.nailapp.Adapter.NailAdapter;
import io.ria.nailapp.Model.NailModel;
import io.ria.nailapp.Utils.NailDBHelper;
import io.ria.nailapp.Utils.OnDialogCloseListner;
import io.ria.nailapp.Utils.RecyclerViewHelper;

public class MainActivity extends AppCompatActivity implements OnDialogCloseListner {

    private RecyclerView mRecyclerview;
    private NailDBHelper dbHelper;
    private List<NailModel> mList;
    private NailAdapter mAdapter;
    private Button nextActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerview = findViewById(R.id.recycle_view);
        dbHelper = new NailDBHelper(MainActivity.this);
        mList = new ArrayList<>();
        mAdapter = new NailAdapter(dbHelper, MainActivity.this);

        mRecyclerview.setHasFixedSize(true);
        mRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerview.setAdapter(mAdapter);
        nextActivity = findViewById(R.id.btn_create);

        mList = dbHelper.getAllTasks();
        Collections.reverse(mList);
        mAdapter.setTasks(mList);


        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NailCreateActivity.class);
                startActivity(intent);
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new RecyclerViewHelper(mAdapter));
        itemTouchHelper.attachToRecyclerView(mRecyclerview);
    }

    @Override
    public void onDialogClose(DialogInterface dialogInterface) {
        mList = dbHelper.getAllTasks();
        Collections.reverse(mList);
        mAdapter.setTasks(mList);
        mAdapter.notifyDataSetChanged();
    }
}