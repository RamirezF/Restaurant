package com.ramirezf.restaurant.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.ramirezf.restaurant.R;

import java.text.DecimalFormat;

public class CanPizzaActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private double producto;
    private TextView pizza_name;
    private TextView txt_description;
    private ImageView imagePizza;
    private TextView txt_precio;

    private TextView btn_add;
    private TextView btn_remove;
    private TextView text_cantidad;

    private Spinner sp01;
    private TextView text_total;

    private int cantidad=0;
    private String tama;
    private Button btn_carrito;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_pizza);

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        pizza_name = findViewById(R.id.pizza_name);
        txt_description = findViewById(R.id.txt_description);
        imagePizza = findViewById(R.id.imagePizza);
        txt_precio = findViewById(R.id.txt_precio);

        getData();

        btn_add = findViewById(R.id.text_add);
        btn_remove = findViewById(R.id.text_remove);
        text_cantidad = findViewById(R.id.text_cantidad);

        cantidad = Integer.parseInt(text_cantidad.getText().toString());

        text_total = findViewById(R.id.text_total);
        btn_carrito = findViewById(R.id.btn_carrito);
        btn_back = findViewById(R.id.btn_back);

        sp01 = findViewById(R.id.sp01);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.tamanio, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp01.setAdapter(adapter);

        sp01.setOnItemSelectedListener(this);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidad = cantidad + 1;
                text_cantidad.setText(String.valueOf(cantidad));
                calcular();
            }
        });
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidad == 1)
                {
                    text_cantidad.setText("1");
                    calcular();
                }else
                {
                    cantidad = cantidad -1;
                    text_cantidad.setText(String.valueOf(cantidad));
                    calcular();
                }
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        btn_carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
    }
    private void getData()
    {
        Bundle extras = getIntent().getExtras();
        String pizzaName = extras.getString("PizzaName");
        String pizzaDescripction = extras.getString("PizzaDescription");
        int pizzaImage = extras.getInt("PizzaImage");

        pizza_name.setText(pizzaName);
        txt_description.setText(pizzaDescripction);
        imagePizza.setImageResource(pizzaImage);
    }

    private void calcular()
    {
        tama = sp01.getSelectedItem().toString();
        double total;
        switch (tama)
        {
            case "Mediana":
                producto = 10.3;
                break;
            case "Grande":
                producto = 20.9;
                break;
            case "Familiar":
                producto = 28.9;
                break;
        }

        total = producto*cantidad;
        String finalizado = obtieneDosDecimales(total);
//        text_total.setText(String.valueOf(total));
        text_total.setText(finalizado);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String spinner = parent.getItemAtPosition(position).toString();
        calcular();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    private String obtieneDosDecimales(double valor){
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(3); //Define 2 decimales.
        return format.format(valor);
    }
}