package com.example.examenfac;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.examenfac.adapter.MyAdapter;
import com.example.examenfac.objetos.Producto;
import com.example.examenfac.objetos.Productos;

public class MainActivity extends AppCompatActivity {
    ListView myList;
    Productos products;
    Producto product;
    MyAdapter Adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myList=(ListView)findViewById(R.id.list1);
        myList.setOnCreateContextMenuListener(this);
        llenarLista();
    }

    void llenarLista() {
        products=new Productos();
        product=new Producto("Penicilina", "C$ 50", "Inyección", "Nica.S.A", "55");
        product.setImg(R.drawable.penicilina);
        products.add(product);

        product=new Producto("Acetaminofen", "C$ 30", "Tableta", "Nica","40");
        product.setImg(R.drawable.acetaminofen);
        products.add(product);

        product=new Producto("Prueba de hembarazo", "C$ 27", "Por unidad", "San Ramon","80");
        product.setImg(R.drawable.response);
        products.add(product);

        setAdapter();
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.setHeaderTitle("Opciones");
        getMenuInflater().inflate(R.menu.menu, menu);
    }

    public void setAdapter() {
        Adapter=new MyAdapter(this, R.layout.item_list, products);
        myList.setAdapter(Adapter);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();

        switch (item.getItemId()) {

            case R.id.btdelet:
                products.remove(info.position);
                setAdapter();
                break;
            case R.id.btexit:
                this.finish();
                break;
            case R.id.addProd:

                final Dialog dlg = new Dialog(this);// definir obejto del dialogo
                dlg.setContentView(R.layout.add_new);// xml del dialogo
                dlg.setTitle("ASIGNATURA");
                dlg.setCancelable(false);//no se puede cerrar

                Button btAddNew = (Button) dlg.findViewById(R.id.btnagregar);
                Button btCancel = (Button) dlg.findViewById(R.id.btncancelar);

                btAddNew.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View V) {
                        EditText editText_nombreProd = (EditText) dlg.findViewById(R.id.editText_nombreprod);
                        EditText ediText_presentacion = (EditText) dlg.findViewById(R.id.editText_presentacion);
                        EditText ediText_lab = (EditText) dlg.findViewById(R.id.editText_lab);
                        EditText editText_Precio = (EditText) dlg.findViewById(R.id.editText_precio);
                        EditText editText_Cantidad = (EditText) dlg.findViewById(R.id.editText_cantidad);

                        if ((editText_nombreProd.getText().toString().contentEquals(""))||(ediText_presentacion.getText().toString().contentEquals(""))|| //Valoracion al llenar campos
                                (ediText_lab.getText().toString().contentEquals(""))||(editText_Precio.getText().toString().contentEquals(""))||(editText_Cantidad.getText().toString().contentEquals(""))) {

                            Toast.makeText(MainActivity.this, "llenar todos los campos", Toast.LENGTH_LONG).show();

                        }else{
                            Producto nuevoProducto = new Producto();
                            nuevoProducto.setNombreProd(editText_nombreProd.getText().toString());
                            nuevoProducto.setPresentacion(ediText_presentacion.getText().toString());
                            nuevoProducto.setLaboratorio(ediText_lab.getText().toString());
                            nuevoProducto.setPrecio(editText_Precio.getText().toString());
                            nuevoProducto.setImg(R.drawable.download);
                            nuevoProducto.setCantidad(editText_Cantidad.getText().toString());

                            products.add(nuevoProducto);

                            editText_nombreProd.setText("");
                            ediText_presentacion.setText("");
                            ediText_lab.setText("");
                            editText_Precio.setText("");
                            editText_Cantidad.setText("");
                            dlg.cancel();
                        }
                    }

                });
                btCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dlg.cancel();
                    }
                });
                dlg.show();// muestra el dialogo
                break;
        }

        return super.onContextItemSelected(item);
    }

}
