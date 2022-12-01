package com.irma.irmauasmobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;


public class ListLaguAnakAdapter extends RecyclerView.Adapter<ListLaguAnakAdapter.LisViewHolder> {
    private ArrayList<LaguAnak> listLaguanak;

    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback){
        this.onItemClickCallback = onItemClickCallback;
    }

    public ListLaguAnakAdapter(ArrayList<LaguAnak> list) {
        this.listLaguanak = list;
    }


    @NonNull
    @Override
    public LisViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_row_laguanak, parent, false);

        return new LisViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LisViewHolder holder, int position) {
        LaguAnak laguanak = listLaguanak.get(position);

        Glide.with(holder.itemView.getContext())
                .load(laguanak.getPhoto())
                .apply(new RequestOptions().override(55,55))
                .into(holder.imgPhoto);

        holder.tvNama.setText(laguanak.getNama());
        holder.tvDetail.setText(laguanak.getDetail());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listLaguanak.get(holder.getAdapterPosition()));

            }
        });

    }

    @Override
    public int getItemCount() {
        return listLaguanak.size();
    }

    class LisViewHolder extends RecyclerView.ViewHolder {
        View tvSuara;
        ImageView imgPhoto;
        TextView tvNama, tvDetail;

        LisViewHolder(View itemview) {
            super(itemview);

            tvSuara = itemview.findViewById(R.id.suara);
            imgPhoto = itemview.findViewById(R.id.img_item_laguanak);
            tvNama = itemview.findViewById(R.id.tv_item_name);
            tvDetail = itemview.findViewById(R.id.tv_detail);


        }
    }



    public interface OnItemClickCallback{
        void onItemClicked(LaguAnak data);
    }

}
