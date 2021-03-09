package com.ramirezf.restaurant.ui.promociones;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ramirezf.restaurant.R;
import com.ramirezf.restaurant.activities.CanPizzaActivity;
import com.ramirezf.restaurant.activities.CanPromoActivity;
import com.ramirezf.restaurant.clases.MyAdapterPromos;
import com.ramirezf.restaurant.clases.PromoM;
import com.ramirezf.restaurant.databinding.FragmentGalleryBinding;

import java.util.ArrayList;
import java.util.List;

public class PromocionesFragment extends Fragment {
    private List<PromoM> promoMs;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private PromocionesViewModel galleryViewModel;
    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(PromocionesViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        promoMs = this.getAllPromo();

        mRecyclerView = root.findViewById(R.id.recyclerView2);
        mLayoutManager = new LinearLayoutManager(getContext());
        //mAdapter = new MyAdapter2
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter = new MyAdapterPromos(promoMs, R.layout.recycler_view_promoc, new MyAdapterPromos.OnItemClickListener() {
            @Override
            public void OnItemClick(PromoM promoM, int position) {
                String nombre = promoM.getNameP();
                String descripcion = promoM.getDescription();
                double precio = promoM.getPrecio();
                int pImage = promoM.getImgP();
                Intent intent = new Intent(getContext(), CanPromoActivity.class);
                intent.putExtra("PromoName",nombre).putExtra("PromoDescription", descripcion).putExtra("PromoImage", pImage).putExtra("PromoPrecio", precio);
                startActivity(intent);
            }
        });

        mRecyclerView.setAdapter(mAdapter);

        return root;
    }

    private ArrayList<PromoM> getAllPromo()
    {
        return new ArrayList<PromoM>() {
            {
                add(new PromoM("Americana","Deliciosa pizza con salsa de tomate, jamón y queso.", 25.90, R.drawable.menu01));
                add(new PromoM("Pepperoni", "Deliciosa pizza clásica con salsa de tomate, queso y bastante pepperoni.", 28.90, R.drawable.menu02));
                add(new PromoM("Continental", "Delisiosa pizza continental que lleva salsa de tomate, aceituna negra, cebolla blanca y champiñones.",  24.90, R.drawable.menu03));
                add(new PromoM("Hawaiana", "Deliciosa pizza hawaiana que lleva salsa de tomate, queso y riquísimos trozos de piña.",  20.90, R.drawable.menu04));
                add(new PromoM("Americana","Deliciosa pizza con salsa de tomate, jamón y queso.",  23.50, R.drawable.menu01));
                add(new PromoM("Pepperoni", "Deliciosa pizza clásica con salsa de tomate, queso y bastante pepperoni.", 30.90,  R.drawable.menu02));
                add(new PromoM("Pepperoni", "Deliciosa pizza clásica con salsa de tomate, queso y bastante pepperoni.", 28.90, R.drawable.menu02));
                add(new PromoM("Continental", "Delisiosa pizza continental que lleva salsa de tomate, aceituna negra, cebolla blanca y champiñones.",  24.90, R.drawable.menu03));
                add(new PromoM("Hawaiana", "Deliciosa pizza hawaiana que lleva salsa de tomate, queso y riquísimos trozos de piña.",  20.90, R.drawable.menu04));
                add(new PromoM("Americana","Deliciosa pizza con salsa de tomate, jamón y queso.",  23.50, R.drawable.menu01));
            }
        };
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}