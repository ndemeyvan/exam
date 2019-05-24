package cm.studio.devbee.pocketexam.activity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.Toast;


import cm.studio.devbee.pocketexam.R;
import cm.studio.devbee.pocketexam.list_fragment.Bepc_allemand_Fragment;
import cm.studio.devbee.pocketexam.list_fragment.Bepc_espagnol_Fragment;

public class ListExamChoiceActivity extends AppCompatActivity  {
    FrameLayout framelayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_list_exam_choice );
        framelayout=findViewById(R.id.framelayout);
        String name =getIntent().getExtras().getString("name");
        Toast.makeText(getApplicationContext(),name,Toast.LENGTH_LONG).show();
        if (name.equals("Bepc Espagnol")){

            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Bepc_espagnol_Fragment()).commit();
        }
        if(name.equals("Bepc Allemand")){

            getSupportFragmentManager().beginTransaction().replace(R.id.framelayout,new Bepc_allemand_Fragment()).commit();
        }
    }


}
