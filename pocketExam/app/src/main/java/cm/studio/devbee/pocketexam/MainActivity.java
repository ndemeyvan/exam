package cm.studio.devbee.pocketexam;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import cm.studio.devbee.pocketexam.fragment.AproposFragment;
import cm.studio.devbee.pocketexam.fragment.BacFragment;
import cm.studio.devbee.pocketexam.fragment.BepcFragment;
import cm.studio.devbee.pocketexam.fragment.ProbatoireFragment;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager tabsviewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        tabLayout=findViewById(R.id.tabslayout);
        tabsviewpager=findViewById(R.id.tabsview);
        setupViewPager(tabsviewpager);
        tabLayout.setupWithViewPager(tabsviewpager);
    }
    public void setupViewPager(ViewPager viewPager){
        TabsAdapter tabsAdapter=new TabsAdapter(getSupportFragmentManager());
        tabsAdapter.addFragment(new BepcFragment (),"Bepc");
        tabsAdapter.addFragment(new ProbatoireFragment (),"Probatoire");
        tabsAdapter.addFragment(new BacFragment (),"Bac");
        tabsAdapter.addFragment(new AproposFragment (),"A propos");
        viewPager.setAdapter(tabsAdapter);

    }
}
