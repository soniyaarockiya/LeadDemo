package com.example.a91user.leaddemo;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.a91user.leaddemo.Adapter.ViewPageAdapter;
import com.example.a91user.leaddemo.Fragments.FragementOne;
import com.example.a91user.leaddemo.Fragments.FragmentTwo;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    static final int REQUEST_IMAGE_CAPTURE = 1;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;

    // create instance of view pager adapter class
    private TabLayout tabLayout;
    private ViewPager viewpager;
    private ViewPageAdapter VPadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Navigation view settings
        NavigationView navigationView = findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);

        //drawer Layout settings
        drawerLayout = findViewById(R.id.drawerLayout);

        //toggle settings
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.Open, R.string.Close);
        drawerLayout.addDrawerListener(drawerToggle);
        drawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        //Everything Tab
        tabLayout = findViewById(R.id.tablayout_id);
        viewpager = findViewById(R.id.viewpager_id);
        VPadapter = new ViewPageAdapter(getSupportFragmentManager());

        // add fragment
        VPadapter.AddFragment(new FragementOne(), " Tab 1");
        VPadapter.AddFragment(new FragmentTwo(), " Tab 2");

        //viewpager.setAnimation();
        viewpager.setPageTransformer(true, new ZoomOutPageTransformer());

        viewpager.setAdapter(VPadapter); // add adapter to view pager
        tabLayout.setupWithViewPager(viewpager); // add view pager to tab layout

        tabLayout.getTabAt(0);
        tabLayout.getTabAt(1);
        //tabLayout.getTabAt(1).setIcon(R.drawable.ic_india);// set icons instead of name for tabs
        tabLayout.getTabMode();

        ActionBar actionbar = getSupportActionBar();
        actionbar.setElevation(0);

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.takePicture:
                // GO TO CAMERA ACTIVITY
                takePicture();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    //camera activation method
    private void takePicture() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }


    //get captured image and past it as bitmap
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = null;
            if (data != null) {
                extras = data.getExtras();
            }
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            extras.putParcelable("Bitmap", imageBitmap);
            Intent displayintent = new Intent(this, DisplayActivity.class);
            displayintent.putExtras(extras);
            startActivity(displayintent);
        }
    }


}

