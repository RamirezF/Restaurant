package com.ramirezf.restaurant.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ramirezf.restaurant.R;

import java.text.DecimalFormat;

public class CanExtraActivity extends AppCompatActivity {

    private TextView pizza_name;
    private TextView txt_description;
    private ImageView imagePizza;

    private TextView btn_add;
    private TextView btn_remove;
    private TextView text_cantidad;

    private TextView valor_pasta;
    private TextView text_total;

    private int cantidad=0;
    private Button btn_carrito;
    private Button btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_can_extra);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        pizza_name = findViewById(R.id.pizza_name);
        txt_description = findViewById(R.id.txt_description);
        imagePizza = findViewById(R.id.imagePizza);
        //txt_precio = findViewById(R.id.txt_precio);
        valor_pasta = findViewById(R.id.valor_pasta);
        text_total = findViewById(R.id.text_total);

        getData();

        btn_add = findViewById(R.id.text_add);
        btn_remove = findViewById(R.id.text_remove);
        text_cantidad = findViewById(R.id.text_cantidad);

        cantidad = Integer.parseInt(text_cantidad.getText().toString());


        btn_carrito = findViewById(R.id.btn_carrito);
        btn_back = findViewById(R.id.btn_back);


        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cantidad = cantidad + 1;
                text_cantidad.setText(String.valueOf(cantidad));
                calc();
            }
        });
        btn_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cantidad == 1)
                {
                    text_cantidad.setText("1");
                    calc();
                }else
                {
                    cantidad = cantidad -1;
                    text_cantidad.setText(String.valueOf(cantidad));
                    calc();
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
        String pizzaName = extras.getString("ExtraName");
        double precio = extras.getDouble("ExtraPrecio");
        String pizzaDescripction = extras.getString("ExtraDescription");
        int pizzaImage = extras.getInt("ExtraImage");

        pizza_name.setText(pizzaName);
        txt_description.setText(pizzaDescripction);
        imagePizza.setImageResource(pizzaImage);
        valor_pasta.setText(String.valueOf(precio));
        text_total.setText(String.valueOf(precio));
    }

    private void calc()
    {
        double total;
        String valor = valor_pasta.getText().toString();
        double val = Double.parseDouble(valor);
        total = val*cantidad;
        String finalizado = obtieneDosDecimales(total);
        //text_total.setText(String.valueOf(total));
        text_total.setText(finalizado);
    }

    private String obtieneDosDecimales(double valor){
        DecimalFormat format = new DecimalFormat();
        format.setMaximumFractionDigits(3); //Define 2 decimales.
        return format.format(valor);
    }
}