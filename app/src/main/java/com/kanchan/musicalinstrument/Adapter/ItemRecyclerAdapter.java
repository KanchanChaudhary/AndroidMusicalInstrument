package com.kanchan.musicalinstrument.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kanchan.musicalinstrument.Model.Item;
import com.kanchan.musicalinstrument.R;

import java.util.List;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {
    private Context mContext;
    private List<Item> itemList;

    public ItemRecyclerAdapter(Context mContext, List<Item> itemList) {
        this.mContext = mContext;
        this.itemList = itemList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemrecycler_layout, parent, false);
        return new ItemViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ItemRecyclerAdapter.ItemViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView Price, detail, ProductName;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            ProductName = itemView.findViewById(R.id.ProductName);
            imageView = itemView.findViewById(R.id.imageView);
            Price = itemView.findViewById(R.id.Price);
            detail = itemView.findViewById(R.id.detail);


        }
    }
}
