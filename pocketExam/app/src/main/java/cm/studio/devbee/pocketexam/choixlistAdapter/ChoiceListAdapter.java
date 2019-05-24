package cm.studio.devbee.pocketexam.choixlistAdapter;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import java.util.List;

import cm.studio.devbee.pocketexam.R;
import cm.studio.devbee.pocketexam.activity.ReadActivity;


public class ChoiceListAdapter extends  RecyclerView.Adapter<ChoiceListAdapter.ViewHolder>{

    List<Model> modelList;
    Context context;
    private FirebaseFirestore firebaseFirestore;

    public ChoiceListAdapter(List<Model> modelList, Context context) {
        this.modelList = modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from ( viewGroup.getContext () ).inflate (R.layout.item_exam ,viewGroup,false);
        viewGroup.getContext();
        firebaseFirestore=FirebaseFirestore.getInstance();
        return new ViewHolder ( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String annee=modelList.get(i).getAnnee();
        final String lien=modelList.get(i).getLien();
        viewHolder.card_nvx. setAnimation ( AnimationUtils. loadAnimation (context, R.anim.transition));
        viewHolder.card_nvx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gotoDetail =new Intent(context,ReadActivity.class);
                gotoDetail.putExtra("lien",lien);
            }
        });

        viewHolder.setNom(annee);
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nom;
        CardView card_nvx;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            card_nvx=itemView.findViewById(R.id.item_card);
            nom=itemView.findViewById(R.id.item_name);
        }
        public void setNom(final String desc){
            nom.setText(desc);
        }


}
}
