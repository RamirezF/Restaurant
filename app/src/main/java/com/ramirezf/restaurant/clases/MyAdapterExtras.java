package com.ramirezf.restaurant.clases;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ramirezf.restaurant.R;

import java.util.List;

public class MyAdapterExtras extends RecyclerView.Adapter<MyAdapterExtras.ViewHolder> {
    private List<ExtrasM> extrasMs;
    private int layout;
    private OnItemClickListener itemClickListener;

    public MyAdapterExtras(List<ExtrasM> extrasM, int layout, OnItemClickListener listener)
    {
        this.extrasMs = extrasM;
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
        holder.bind(extrasMs.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return extrasMs.size();
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

        public void bind(final ExtrasM extrasMs, final OnItemClickListener listener)
        {
            textViewName.setText(extrasMs.getNameP());
            imageViewPizza.setImageResource(extrasMs.getImgP());
            txt_precio.setText(Double.toString(extrasMs.getPrecio()));
            textViewDescription.setText(extrasMs.getDescription());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemClick(extrasMs, getAdapterPosition());        // para ver la posición
                }
            });
        }
    }

    public interface OnItemClickListener{
        void OnItemClick(ExtrasM extrasMs, int position);
    }
}