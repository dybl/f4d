package com.junjc9.funu.f4d.ui.activity;

import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

//import android.view.Display;
//import android.view.MotionEvent;
//import android.view.WindowManager;
//import android.content.Context;
import android.content.Intent;
import android.view.View;

import android.net.Uri;

import android.os.Environment;

import android.provider.MediaStore;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;


import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
// import androidx.coordinatorlayout.widget.CoordinatorLayout;

//import com.getbase.floatingactionbutton.FloatingActionButton;
//import com.getbase.floatingactionbutton.FloatingActionsMenu;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.junjc9.funu.f4d.R;




public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    /*
    private CoordinatorLayout right;
    private NavigationView left;
    private boolean isDrawer=false;
    */
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    private File currentImageFile = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view,getResources().getString(R.string.nav_header_subtitle), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        /*
        final FloatingActionsMenu menuMultipleActions = (FloatingActionsMenu) findViewById(R.id.multiple_actions);
        FloatingActionButton fablandmarkbt = (FloatingActionButton) findViewById(R.id.fab_landmark);
        fablandmarkbt.setSize(FloatingActionButton.SIZE_MINI);
        fablandmarkbt.setColorNormalResId(R.color.pink);
        fablandmarkbt.setColorPressedResId(R.color.pink_pressed);
        fablandmarkbt.setIcon(R.drawable.ic_center_focus_weak);
        fablandmarkbt.setStrokeVisible(false);
        fablandmarkbt.setTitle("landmark");
        fablandmarkbt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File dir = new File(Environment.getExternalStorageDirectory(),"libpic");
                if(dir.exists()){
                    dir.mkdirs();
                }
                currentImageFile = new File(dir,System.currentTimeMillis() + ".jpg");
                if(!currentImageFile.exists()){
                    try {
                        currentImageFile.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(currentImageFile)); // set the image file name

                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
            }
        });

        FloatingActionButton fabeditbt = (FloatingActionButton) findViewById(R.id.fab_edit);
        fabeditbt.setSize(FloatingActionButton.SIZE_MINI);
        fabeditbt.setColorNormalResId(R.color.blue_semi_transparent);
        fabeditbt.setColorPressedResId(R.color.blue_semi_transparent_pressed);
        fabeditbt.setIcon(R.drawable.ic_mode_edit);
        fabeditbt.setStrokeVisible(false);
        fabeditbt.setTitle("edit");
        */



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        /*
        right = (CoordinatorLayout) findViewById(R.id.right);
        left = (NavigationView) findViewById(R.id.nav_view);
        */

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        /*
        right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if(isDrawer){
                    return left.dispatchTouchEvent(motionEvent);
                }else{
                    return false;
                }
            }
        });
        drawer.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                isDrawer=true;
                //获取屏幕的宽高
                WindowManager manager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
                Display display = manager.getDefaultDisplay();
                //设置右面的布局位置  根据左面菜单的right作为右面布局的left   左面的right+屏幕的宽度（或者right的宽度这里是相等的）为右面布局的right
                right.layout(left.getRight(), 0, left.getRight() + display.getWidth(), display.getHeight());
            }
            @Override
            public void onDrawerOpened(View drawerView) {}
            @Override
            public void onDrawerClosed(View drawerView) {
                isDrawer=false;
            }
            @Override
            public void onDrawerStateChanged(int newState) {}
        });
        */

    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        } else if (id == R.id.action_open_in_browser) {
            return true;
        } else if (id == R.id.action_help_and_feedback) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        switch(item.getItemId()) {
            case R.id.nav_camera:
                break;

            case R.id.nav_gallery:
                break;

            case R.id.nav_manage:
                break;

            case R.id.nav_slideshow:
                break;

            case R.id.nav_share:
                break;

            case R.id.nav_send:
                break;

            case R.id.nav_about:
                startActivity(new Intent(this,AboutActivity.class));
                break;

            case R.id.nav_setting:
                break;

        }
        /*
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        } else if (id == R.id.nav_about) {
            Intent intent=new Intent(MainActivity.this,AboutActivity.class);
            startActivity(intent);

        } else if (id == R.id.nav_setting) {

        }
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
