package cm.studio.devbee.pocketexam.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cm.studio.devbee.pocketexam.R;
import cm.studio.devbee.pocketexam.bepc_adapter.Bepc_adapter;
import cm.studio.devbee.pocketexam.bepc_adapter.Bepc_model;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProbatoireFragment extends Fragment {
    RecyclerView proba_recycler;
    List<Bepc_model> bepc_modelList;
    Bepc_adapter bepc_adapter;

    public ProbatoireFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate ( R.layout.fragment_probatoire, container, false );
        bepc_modelList=new ArrayList<>(  );
        bepc_modelList.add ( new Bepc_model ( "Pro A4 Allemand" ) );
        bepc_modelList.add ( new Bepc_model ( "Pro A4 Espagnol" ) );
        bepc_modelList.add ( new Bepc_model ( "Pro D" ) );
        bepc_modelList.add ( new Bepc_model ( "Pro C" ) );
        proba_recycler=v.findViewById ( R.id.proba_recycler );
        bepc_adapter=new Bepc_adapter (bepc_modelList,getActivity());
        proba_recycler.setAdapter ( bepc_adapter );
        proba_recycler.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        return v;
    }

}
