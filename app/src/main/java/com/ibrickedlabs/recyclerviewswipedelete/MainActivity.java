package com.ibrickedlabs.recyclerviewswipedelete;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

public class MainActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.reclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        /**
         * Or you can set the layout in the xml using app:LayoutManager
         */
        mRecyclerView.setLayoutManager(layoutManager);
        ItemAdapter itemAdapter = new ItemAdapter(this);
        mRecyclerView.setAdapter(itemAdapter);
        mRecyclerView.setItemAnimator(new SlideInLeftAnimator());
        SimpleTouchCallback simpleTouchCallback = new SimpleTouchCallback(itemAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleTouchCallback);
        itemTouchHelper.attachToRecyclerView(mRecyclerView);

    }
}
