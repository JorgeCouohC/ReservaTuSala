package com.jjcouoh.reservatusala;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;

import com.android.volley.toolbox.ImageLoader;
import com.jjcouoh.util.VolleyRequestMgr;

public class DetallesSalaActivity extends AppCompatActivity {
    ImageLoader imageLoader ;
    Context context;
    NetworkImageView imgDetallesSala;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_sala);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        imgDetallesSala = (NetworkImageView)findViewById(R.id.imgDetallesSala);
        imageLoader = VolleyRequestMgr.getInstance(context).getImageLoader();
        imageLoader.get("http://www.escritoriosysillasparaoficina.com/images/salas%20de%20juntas.jpg", ImageLoader.getImageListener(imgDetallesSala, R.drawable.ic_menu_gallery, R.drawable.ic_menu_gallery));
        imgDetallesSala.setImageUrl("http://www.escritoriosysillasparaoficina.com/images/salas%20de%20juntas.jpg", imageLoader);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
