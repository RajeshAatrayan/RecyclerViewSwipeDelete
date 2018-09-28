package com.ibrickedlabs.recyclerviewswipedelete;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by RajeshAatrayan on 28-09-2018.
 */

/**
 * We need to extend a class called RecyclerView.Adapter to create our own custom RecyclerView Adapter
 */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemHolder> implements SwipeListener {
    private LayoutInflater mLayoutInflater;


    /**
     * CREATE A LAYOUTINFLATER OBJ FOR FURTHER USE
     *
     * @param context
     */

    ArrayList<String> items;

    ItemAdapter(Context context) {
        mLayoutInflater = LayoutInflater.from(context);
        items = new ArrayList<String>();
        items.add("Item 1");
        items.add("Item 2");
        items.add("Item 3");
        items.add("Item 4");
        items.add("Item 5");
        items.add("Item 6");
        items.add("Item 7");

    }

    /**
     * In this method we need to create a view for the items in the recycler view
     * since we have created an xml layotu we need to inflate here
     *
     * @param parent
     * @param viewType
     * @return
     */
    @Override
    public ItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        /**
         * v---> here it is the root layout of xml layout file
         */
        View v = mLayoutInflater.inflate(R.layout.row_layout, parent, false);

        /**
         * and now we need to pass this view which is further used to create the objects of the layout
         */
        ItemHolder itemHolder = new ItemHolder(v);
        return itemHolder;
    }

    @Override
    public void onBindViewHolder(ItemHolder holder, int position) {
        Log.d("ItemAdapter.this", "Position-" + position);
        holder.textView.setText(items.get(position));

    }

    @Override
    public int getItemCount() {


        return items.size();
    }

    @Override
    public void onSwipe(int pos) {
        items.remove(pos);
        notifyDataSetChanged();
    }

    class ItemHolder extends RecyclerView.ViewHolder {
        TextView textView;

        /**
         * HERE WE USE THIS CONSTRUCTOR WHICH HAS GOT THE ROOT VIEW FROM ONCREATEVIEHOLDER TO CREATE THE OBJECTS OF THE VIEWS IN THE LAYOUT
         *
         * @param itemView
         */

        public ItemHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.tv);
        }
    }
}
