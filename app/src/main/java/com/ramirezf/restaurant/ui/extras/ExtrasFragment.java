package com.ramirezf.restaurant.ui.extras;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ramirezf.restaurant.R;
import com.ramirezf.restaurant.activities.CanExtraActivity;
import com.ramirezf.restaurant.activities.CanPizzaActivity;
import com.ramirezf.restaurant.clases.ExtrasM;
import com.ramirezf.restaurant.clases.MyAdapterExtras;
import com.ramirezf.restaurant.databinding.FragmentGalleryBinding;

import java.util.ArrayList;
import java.util.List;

public class ExtrasFragment extends Fragment {
    private List<ExtrasM> extrasM;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private FragmentGalleryBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //***********************************************************************************************************
        View vista;
        vista = inflater.inflate(R.layout.fragment_extras, container, false);
        extrasM = this.getAllCartaMs();

        mRecyclerView = vista.findViewById(R.id.recyclerView4);
        mLayoutManager = new LinearLayoutManager(getContext());
        mAdapter = new MyAdapterExtras(extrasM, R.layout.recycler_view_menu, new MyAdapterExtras.OnItemClickListener() {       //recycler_view_item
            @Override
            public void OnItemClick(ExtrasM extrasM, int position) {
                String nombre = extrasM.getNameP();
                String descripcion = extrasM.getDescription();
                double precio = extrasM.getPrecio();
                int pImage = extrasM.getImgP();
                Intent intent = new Intent(getContext(), CanExtraActivity.class);
                intent.putExtra("ExtraName", nombre);
                intent.putExtra("ExtraDescription", descripcion);
                intent.putExtra("ExtraPrecio", precio);
                intent.putExtra("ExtraImage", pImage);
                startActivity(intent);
            }
        });
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
        //***********************************************************************************************************
        // Inflate the layout for this fragment
        return vista;
    }

    private ArrayList<ExtrasM> getAllCartaMs() {
        return new ArrayList<ExtrasM>() {
            {
                add(new ExtrasM("Regalo 1", "Opción número 1 para una sola persona", 15.90,R.drawable.extra01));
                add(new ExtrasM("Regalo 2", "Opción número 2 para dos personas", 18.90, R.drawable.extra02));
                add(new ExtrasM("Regalo 3", "Opción número 3 para 4 personas",  24.90, R.drawable.extra03));
                add(new ExtrasM("Regalo 4", "Opción número 4 para 1 persona pero de mayor calidad",  29.90, R.drawable.extra04));
                add(new ExtrasM("Regalo 5", "Extra para 4 personas, distintos regalos para cada uno de ellos", 18.90,  R.drawable.extra05));
                add(new ExtrasM("Regalo 6", "Opción número 6 para una sola persona", 15.90,R.drawable.extra01));
                add(new ExtrasM("Regalo 7", "Opción número 7 para dos personas",  25.90, R.drawable.extra02));
                add(new ExtrasM("Regalo 8", "Opción número 8 para 4 personas",  31.90, R.drawable.extra03));
                add(new ExtrasM("Regalo 9", "Opción número 9 para 1 persona pero de mayor calidad", 18.90,  R.drawable.extra04));
                add(new ExtrasM("Regalo 10", "Extra para 4 personas, distintos regalos para cada uno de ellos",15.90, R.drawable.extra05));
            }
        };
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}