package cm.studio.devbee.pocketexam.list_fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import cm.studio.devbee.pocketexam.R;
import cm.studio.devbee.pocketexam.bepc_adapter.Bepc_adapter;
import cm.studio.devbee.pocketexam.bepc_adapter.Bepc_model;
import cm.studio.devbee.pocketexam.bepc_adapter.SecondAdapter;
import cm.studio.devbee.pocketexam.choixlistAdapter.ChoiceListAdapter;
import cm.studio.devbee.pocketexam.choixlistAdapter.Model;

/**
 * A simple {@link Fragment} subclass.
 */
public class Bepc_espagnol_Fragment extends Fragment {
    RecyclerView bepc_recycler;
    List<Bepc_model> bepc_modelList;
    SecondAdapter bepc_adapter;

    public Bepc_espagnol_Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_bepc_espagnol_, container, false);
        bepc_modelList=new ArrayList<> (  );
        bepc_modelList.add ( new Bepc_model ( "ecm" ) );
        bepc_recycler=v.findViewById ( R.id.bepc_espagnol_recycler );
        bepc_adapter=new SecondAdapter (bepc_modelList,getActivity());
        bepc_recycler.setAdapter ( bepc_adapter );
        bepc_recycler.setLayoutManager(new LinearLayoutManager (getActivity(),LinearLayoutManager.VERTICAL,false));
        return  v;
    }


}
