package com.ramirezf.restaurant.clases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramirezf.restaurant.R;

import org.w3c.dom.Text;

import java.util.List;

public class MyAdapterPromos extends RecyclerView.Adapter<MyAdapterPromos.ViewHolder> {
    private List<PromoM> promoMs;
    private int layout;
    private OnItemClickListener itemClickListener;

    public MyAdapterPromos(List<PromoM> promoMs, int layout, OnItemClickListener listener)
    {
        this.promoMs = promoMs;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(promoMs.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return promoMs.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewName;
        public TextView textViewDescription;
        public TextView txt_precio;
        public ImageView imageViewPizza;

        public ViewHolder(View itemView){
            super(itemView);
            textViewName = itemView.findViewById(R.id.txt_pizza);
            textViewDescription = itemView.findViewById(R.id.txt_description);
            txt_precio = itemView.findViewById(R.id.txt_precio);
            imageViewPizza = itemView.findViewById(R.id.imagePizza);
        }

        public void bind(final PromoM promoMs, final OnItemClickListener listener)
        {
            textViewName.setText(promoMs.getNameP());
            imageViewPizza.setImageResource(promoMs.getImgP());
            txt_precio.setText(Double.toString(promoMs.getPrecio()));
            textViewDescription.setText(promoMs.getDescription());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(promoMs, getAdapterPosition());        // para ver la posición
                }
            });
        }
    }

    public interface OnItemClickListener{
        void OnItemClick(PromoM promoM, int position);
    }
}