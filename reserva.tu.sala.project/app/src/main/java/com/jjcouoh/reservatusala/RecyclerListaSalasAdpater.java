package com.jjcouoh.reservatusala;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.jjcouoh.Entities.Sala;
import com.jjcouoh.util.VolleyRequestMgr;

import java.util.ArrayList;

/**
 * Created by docampo on 30/06/2016.
 */
public class RecyclerListaSalasAdpater extends RecyclerView.Adapter<RecyclerListaSalasAdpater.MyViewHolder>{
    private static final String TAG= RecyclerListaSalasAdpater.class.getSimpleName();
    private RequestQueue queue;
    private ArrayList<Sala> mData;
    private LayoutInflater mInflater;
    Sala current;
    ImageLoader imageLoader ;
    Context context;
    CardView cvListSalas;
    public RecyclerListaSalasAdpater(Context context, ArrayList<Sala> data)
    {
        if(context==null) return;
        this.mData = data;
        this.mInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
        queue = VolleyRequestMgr.getInstance(context).getRequestQueue();
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.salas_list_item,parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        current = mData.get(position);
        holder.setData(current,position);
        holder.setListeners();
    }



    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvNombre, tvCapacidad;
        Sala sala;
        int position;
       NetworkImageView imgSala;
        ImageView imgReservarSala;


        public MyViewHolder(View itemView) {
            super(itemView);
            //Obtener los controles
            cvListSalas = (CardView)itemView.findViewById(R.id.cvListSalas);
           tvNombre = (TextView)itemView.findViewById(R.id.tvNombre);
            tvCapacidad = (TextView)itemView.findViewById(R.id.tvListItemSalasCapacidad);
           imgSala = (NetworkImageView) itemView.findViewById(R.id.imgSala);
            imgReservarSala = (ImageView)itemView.findViewById(R.id.imgReservarSala);
           imgReservarSala.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), ReservarSalaActivity.class);
                    v.getContext().startActivity(intent);
                }
            });
            cvListSalas.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(v.getContext(), DetallesSalaActivity.class);
                    v.getContext().startActivity(intent);
                }
            });

        }

        public void setListeners(){

        }

        public void setData(Sala current, int position){
            //  try {
            this.tvNombre.setText(current.getNombre());
            this.tvCapacidad.setText(current.getCapacidad());
            imageLoader = VolleyRequestMgr.getInstance(context).getImageLoader();
            imageLoader.get(current.getImagenUrl(), ImageLoader.getImageListener(imgSala, R.drawable.ic_menu_gallery, R.drawable.ic_menu_gallery));
            imgSala.setImageUrl(current.getImagenUrl(), imageLoader);


            this.position = position;
            this.sala = current;
            //  }
           /* catch (Exception e)
            {
                Log.i("ERROR IMAGE", e.getLocalizedMessage());
            }*/
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()){

            }
        }
    }
}
