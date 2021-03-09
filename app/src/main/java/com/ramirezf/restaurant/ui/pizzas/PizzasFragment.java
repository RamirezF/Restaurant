package com.ramirezf.restaurant.ui.pizzas;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ramirezf.restaurant.R;
import com.ramirezf.restaurant.activities.CanPizzaActivity;
import com.ramirezf.restaurant.clases.PizzasM;
import com.ramirezf.restaurant.clases.MyAdapterPizzas;

import java.util.ArrayList;
import java.util.List;

public class PizzasFragment extends Fragment {

    private List<PizzasM> pizzasM;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //***********************************************************************************************************
        View vista;
        vista = inflater.inflate(R.layout.fragment_pizzas, container, false);
        pizzasM = this.getAllCartaMs();

        mRecyclerView = vista.findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new MyAdapterPizzas(pizzasM, R.layout.recycler_view_menu, new MyAdapterPizzas.OnItemClickListener() {       //recycler_view_item
            @Override
            public void OnItemFriscoClick(PizzasM pizzasM, int position) {
                String nombre = pizzasM.getNameP();
                String descripcion = pizzasM.getDescription();
                int pImage = pizzasM.getImgP();
                Intent intent = new Intent(getContext(), CanPizzaActivity.class);
                intent.putExtra("PizzaName", nombre);
                intent.putExtra("PizzaDescription", descripcion);
                intent.putExtra("PizzaImage", pImage);
                startActivity(intent);
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        //***********************************************************************************************************
        // Inflate the layout for this fragment

        return vista;
    }

    private ArrayList<PizzasM> getAllCartaMs()
    {
        return new ArrayList<PizzasM>() {
            {
                add(new PizzasM("Americana","Pizza con salsa de tomate, jamón y queso", R.drawable.menu01));
                add(new PizzasM("Peperoni","Pizza con salsa de tomate, pepperoni y queso", R.drawable.menu02));
                add(new PizzasM("Continental","Pizza con salsa de tomate, aceituna, champiñones y queso", R.drawable.menu03));
                add(new PizzasM("Hawaiana","Pizza con salsa de tomate, piña y queso",  R.drawable.menu04));
                add(new PizzasM("Vegetariana","Pizza con salsa de tomate, cebolla blanca, aceituna y queso", R.drawable.menu01));
                add(new PizzasM("Mozarella","Pizza con salsa especial y queso mozarella", R.drawable.menu02));
                add(new PizzasM("Americana","Pizza con salsa de tomate, jamón y queso", R.drawable.menu01));
                add(new PizzasM("Peperoni","Pizza con salsa de tomate, pepperoni y queso", R.drawable.menu02));
                add(new PizzasM("Continental","Pizza con salsa de tomate, aceituna, champiñones y queso", R.drawable.menu03));
                add(new PizzasM("Hawaiana","Pizza con salsa de tomate, piña y queso",  R.drawable.menu04));
            }
        };
    }
}