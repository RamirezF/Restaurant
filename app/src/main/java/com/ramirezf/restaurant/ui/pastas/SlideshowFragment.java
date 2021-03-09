package com.ramirezf.restaurant.ui.pastas;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ramirezf.restaurant.R;
import com.ramirezf.restaurant.activities.CanPastaActivity;
import com.ramirezf.restaurant.activities.CanPizzaActivity;
import com.ramirezf.restaurant.clases.MyAdapterPastas;
import com.ramirezf.restaurant.clases.PastasM;
import com.ramirezf.restaurant.databinding.FragmentSlideshowBinding;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {
    private List<PastasM> pastasM;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private SlideshowViewModel slideshowViewModel;
    private FragmentSlideshowBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //***********************************************************************************************************
        View vista;
        vista = inflater.inflate(R.layout.fragment_slideshow, container, false);
        pastasM = this.getAllCartaMs();

        mRecyclerView = vista.findViewById(R.id.recyclerView3);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new MyAdapterPastas(pastasM, R.layout.recycler_view_menu, new MyAdapterPastas.OnItemClickListener() {       //recycler_view_item
            @Override
            public void OnItemClick(PastasM pastasM, int position) {
                String nombre = pastasM.getNameP();
                String descripcion = pastasM.getDescription();
                double precio = pastasM.getPrecio();
                int pImage = pastasM.getImgP();
                Intent intent = new Intent(getContext(), CanPastaActivity.class);
                intent.putExtra("PastaName", nombre);
                intent.putExtra("PastaDescription", descripcion);
                intent.putExtra("PastaPrecio", precio);
                intent.putExtra("PastaImage", pImage);
                startActivity(intent);
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        //***********************************************************************************************************
        // Inflate the layout for this fragment
        return vista;
    }

    private ArrayList<PastasM> getAllCartaMs()
    {
        return new ArrayList<PastasM>() {
            {
                add(new PastasM("Spaghetti a la carbonara","Delisiosa pasta con su verdadera salsa que contiene queso y bacon, carne y una pisca de orégano", 24.90, R.drawable.pastas01));
                add(new PastasM("Spaghetti a la boloñesa","Spaguetti a la boloñesa con salsa de tomate, queso, bastante carne y orégano", 25.50, R.drawable.pastas02));
                add(new PastasM("Spaghetti al Alfredo","Spaghetto al Alfredo acompañada con salsa blanca, carne y queso", 22.50, R.drawable.pastas03));
                add(new PastasM("Spaghetti al Pesto","Spaghetti al Pesto con carne montada y queso rallado", 28.00, R.drawable.pastas05));
                add(new PastasM("Lasagna de Carne","Deliciosa Lasagna de carne con una rica salsa de tomate y queso",  45.90, R.drawable.pastas04));
                add(new PastasM("Spaghetti a la carbonara","Delisiosa pasta con su verdadera salsa que contiene queso y bacon, carne y una pisca de orégano", 24.90, R.drawable.pastas01));
                add(new PastasM("Spaghetti a la boloñesa","Spaguetti a la boloñesa con salsa de tomate, queso, bastante carne y orégano", 25.50, R.drawable.pastas02));
                add(new PastasM("Spaghetti al Alfredo","Spaghetto al Alfredo acompañada con salsa blanca, carne y queso", 22.50, R.drawable.pastas03));
                add(new PastasM("Spaghetti al Pesto","Spaghetti al Pesto con carne montada y queso rallado", 24.50, R.drawable.pastas05));
                add(new PastasM("Lasagna de Carne","Deliciosa Lasagna de carne con una rica salsa de tomate y queso",  28.80, R.drawable.pastas04));
            }
        };
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}