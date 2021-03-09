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

public class MyAdapterPizzas extends RecyclerView.Adapter<MyAdapterPizzas.ViewHolder> {

    private List<PizzasM> pizzasMS;
    private int layout;
    private OnItemClickListener itemClickListener;

    public MyAdapterPizzas(List<PizzasM> pizzasMS, int layout, OnItemClickListener listener) {
        this.pizzasMS = pizzasMS;
        this.layout = layout;
        this.itemClickListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(layout, parent, false);           // Inflar la vista
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(pizzasMS.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return pizzasMS.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewDescription;
        public ImageView imageViewPizza;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.txt_pizza);
            imageViewPizza = itemView.findViewById(R.id.imagePizza);
            textViewDescription = itemView.findViewById(R.id.txt_description);

        }

        public void bind(final PizzasM pizzasM, final OnItemClickListener listener) {
            textViewName.setText(pizzasM.getNameP());
            imageViewPizza.setImageResource(pizzasM.getImgP());
            textViewDescription.setText(pizzasM.getDescription());

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.OnItemFriscoClick(pizzasM, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void OnItemFriscoClick(PizzasM pizzasM, int position);
    }
}