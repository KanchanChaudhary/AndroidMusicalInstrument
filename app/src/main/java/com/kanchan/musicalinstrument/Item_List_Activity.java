package com.kanchan.musicalinstrument;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.kanchan.musicalinstrument.Adapter.ItemRecyclerAdapter;
import com.kanchan.musicalinstrument.Bll.ItemBll;

public class Item_List_Activity extends AppCompatActivity {
    private RecyclerView item_recycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item__list_);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        PopulateRecyclerViewList();
    }
    public void PopulateRecyclerViewList(){
        item_recycleView = findViewById(R.id.arecycleitemlists);
        ItemBll itemBll = new ItemBll();
        ItemRecyclerAdapter itemRecyclerAdapter = new ItemRecyclerAdapter(this,itemBll.getAllItems());
        item_recycleView.setAdapter(itemRecyclerAdapter);
        item_recycleView.setLayoutManager(new LinearLayoutManager(this));
    }
}