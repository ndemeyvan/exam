package cm.studio.devbee.pocketexam.bepc_adapter;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import cm.studio.devbee.pocketexam.R;
import cm.studio.devbee.pocketexam.activity.ListExamChoiceActivity;

public class Bepc_adapter extends RecyclerView.Adapter<Bepc_adapter.ViewHolder> {
    List<Bepc_model> bepc_modelList;
    Context context;

    public Bepc_adapter(List<Bepc_model> bepc_modelList, Context context) {
        this.bepc_modelList = bepc_modelList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from ( viewGroup.getContext () ).inflate (R.layout.item_exam ,viewGroup,false);
        return new ViewHolder ( v );
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final String name =bepc_modelList.get ( i ).getAnnee_du_bepc ();
        viewHolder.setName_exam ( name );
        viewHolder.go_icon_image.setAnimation ( AnimationUtils.loadAnimation ( context, R.anim.transition ) );
        viewHolder.item_card.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent gotolist=new Intent (context,ListExamChoiceActivity.class );
                gotolist.putExtra ( "name",name );
                context.startActivity ( gotolist );
            }
        } );

    }

    @Override
    public int getItemCount() {
        return bepc_modelList.size ();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView titre;
        ImageView go_icon_image;
        CardView item_card;
        public ViewHolder(@NonNull View itemView) {
            super ( itemView );
            titre=itemView.findViewById ( R.id.item_name );
            go_icon_image=itemView.findViewById ( R.id.go_icon_image );
            item_card=itemView.findViewById ( R.id.item_card );
        }
        public void setName_exam(String name){
            titre.setText ( name );
        }
    }

}
