package nyc.c4q.midprogramassesment;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import nyc.c4q.midprogramassesment.fragments.ListFirstFragment;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Intent getUser = getIntent();
        String user = getUser.getStringExtra("currentUser");

        ListFirstFragment listFirstFragment = new ListFirstFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Bundle bundle = new Bundle();
        bundle.putString("currentUser", user);
        listFirstFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.listactivity_fragment_container_framelayout, listFirstFragment);
        fragmentTransaction.commit();
    }
}
