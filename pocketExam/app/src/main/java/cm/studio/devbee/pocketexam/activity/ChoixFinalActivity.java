package cm.studio.devbee.pocketexam.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.google.firebase.FirebaseApp;
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
import cm.studio.devbee.pocketexam.choixlistAdapter.ChoiceListAdapter;
import cm.studio.devbee.pocketexam.choixlistAdapter.Model;

public class ChoixFinalActivity extends AppCompatActivity {
    RecyclerView list_recycler;
    List<Model> list;
    ChoiceListAdapter choiceListAdapter;
    FirebaseFirestore firebaseFirestore;
    String matiere ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_final);
        FirebaseApp.initializeApp(getApplicationContext());
        String matiere =getIntent().getExtras().getString("matiere");
        list=new ArrayList<>(  );
        list_recycler=findViewById ( R.id.final_recycler );
        choiceListAdapter=new ChoiceListAdapter (list,getApplicationContext());
        list_recycler.setAdapter ( choiceListAdapter );
        list_recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        firebaseFirestore=FirebaseFirestore.getInstance();
        liste();
    }
    public void liste(){
        Query firstQuery =firebaseFirestore.collection ( "bepc" ).document ("Bepc Espagnol").collection ( matiere ).orderBy ( "annee",Query.Direction.ASCENDING );
        firstQuery.addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirebaseFirestoreException e) {
                for (DocumentChange doc:queryDocumentSnapshots.getDocumentChanges()){
                    if (doc.getType()==DocumentChange.Type.ADDED){
                        String idupost=doc.getDocument ().getId ();
                        Model model =doc.getDocument().toObject(Model.class).withId ( idupost );
                        list.add(model);
                        choiceListAdapter.notifyDataSetChanged();
                    }
                }

            }
        });
    }
}
