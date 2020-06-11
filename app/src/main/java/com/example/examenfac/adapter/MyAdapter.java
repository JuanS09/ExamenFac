package com.example.examenfac.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.examenfac.R;
import com.example.examenfac.objetos.Producto;
import com.example.examenfac.objetos.Productos;

public class MyAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private Productos products;

    public MyAdapter(Context context, int layout, Productos products) {
        this.context = context;
        this.layout = layout;
        this.products = products;
    }

    @Override
    public int getCount() {
        return products.size();
    }

    @Override
    public Object getItem(int position) {
        return products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    static  class ViewHolder{
        private TextView textViewNombreProd;
        private TextView textViewPrecio;
        private TextView textViewPresentacion;
        private TextView textViewLaboratorio;
        private TextView textViewCantidad;
        private ImageView img;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if(convertView==null){
            LayoutInflater layoutInflater= LayoutInflater.from(this.context);
            convertView=layoutInflater.inflate(R.layout.item_list,null);
            holder=new ViewHolder();
            holder.textViewNombreProd=(TextView)convertView.findViewById(R.id.textViewNombreProd);
            holder.textViewPrecio=(TextView)convertView.findViewById(R.id.textViewPrecio);
            holder.textViewPresentacion=(TextView)convertView.findViewById(R.id.textViewPresentacion);
            holder.textViewLaboratorio=(TextView)convertView.findViewById(R.id.textViewLaboratorio);
            holder.textViewCantidad=(TextView)convertView.findViewById(R.id.textViewCantidad);
            holder.img=(ImageView)convertView.findViewById(R.id.imageViewList);
        }else{
            holder=(ViewHolder)convertView.getTag();
        }

        Producto current_Item=products.get(position);
        holder.textViewNombreProd.setText(current_Item.getNombreProd());
        holder.textViewPrecio.setText(current_Item.getPrecio());
        holder.textViewPresentacion.setText(current_Item.getPresentacion());
        holder.textViewLaboratorio.setText(current_Item.getLaboratorio());
        holder.textViewCantidad.setText(current_Item.getCantidad());
        holder.img.setImageResource(products.get(position).getImg());

        return  convertView;
    }
}
