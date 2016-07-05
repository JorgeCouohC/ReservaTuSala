package com.jjcouoh.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jjcouoh.Entities.Sala;
import com.jjcouoh.reservatusala.R;
import com.jjcouoh.reservatusala.RecyclerListaSalasAdpater;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListaSalasFragment extends Fragment {
RecyclerView rvSalas;
    ArrayList<Sala> salas;
    public ListaSalasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

       View v =  inflater.inflate(R.layout.fragment_lista_salas, container, false);
        setupView(v);
        salas = new ArrayList<>();
        Sala sala1 = new Sala();
        sala1.setNombre("Sala Turing");
        sala1.setCapacidad("10");
        sala1.setImagenUrl("http://www.escritoriosysillasparaoficina.com/images/salas%20de%20juntas.jpg");

        Sala sala2 = new Sala();
        sala2.setNombre("Sala 1");
        sala2.setCapacidad("10");
        sala2.setImagenUrl("http://abbamuebles.com.mx/media/images/productos/salas_de_juntas(12).jpg");
        salas.add(sala1);
        salas.add(sala2);
        setupRecyclerView(rvSalas, salas);
        return v;
    }

    private void setupView(View view) {
        rvSalas = (RecyclerView)view.findViewById(R.id.rvSalas);
    }

    private void setupRecyclerView(RecyclerView rv, ArrayList<Sala> data){

        if(data.size()<=0 || data==null) return;

        RecyclerListaSalasAdpater adapter = new RecyclerListaSalasAdpater(getActivity(), data);
        GridLayoutManager mGridLayoutManagerHorizontal = new GridLayoutManager(getActivity(), 1);
        mGridLayoutManagerHorizontal.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(mGridLayoutManagerHorizontal);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(adapter);
    }



}
