package com.habib4990gmail.babyshopserver.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.habib4990gmail.babyshopserver.Interface.ItemClickListener;
import com.habib4990gmail.babyshopserver.R;
import com.habib4990gmail.babyshopserver.common.Common;

public class ItemViewHolder extends RecyclerView.ViewHolder implements
        View.OnClickListener,
        View.OnCreateContextMenuListener
{

    public TextView item_name;
    public ImageView item_image;

    private ItemClickListener itemClickListener;

    public ItemViewHolder(View itemView) {
        super(itemView);

        item_name = (TextView)itemView.findViewById(R.id.item_name);
        item_image = (ImageView) itemView.findViewById(R.id.item_image);

        itemView.setOnCreateContextMenuListener(this);
        itemView.setOnClickListener(this);
    }

    public void setItemClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }
    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view,getAdapterPosition(),false);

    }

    @Override
    public void onCreateContextMenu(ContextMenu contextMenu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        contextMenu.setHeaderTitle("Select the action");

        contextMenu.add(0,0,getAdapterPosition(), Common.UPDATE);
        contextMenu.add(0,1,getAdapterPosition(), Common.DELETE);
    }

}
