package com.example.lab2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class Menus extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menus);

        drawerLayout = findViewById(R.id.drawerLayout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Bikaji Foods");
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_home){
            Snackbar.make(findViewById(android.R.id.content).getRootView(), "Going to Home", Snackbar.LENGTH_SHORT)
                    .show();
        }
        if(item.getItemId()==R.id.menu_profile){
            Snackbar.make(findViewById(android.R.id.content).getRootView(), "Going to Profile", Snackbar.LENGTH_SHORT)
                    .show();
        }
        if(item.getItemId()==R.id.menu_orders){
            Snackbar.make(findViewById(android.R.id.content).getRootView(), "Going to Orders", Snackbar.LENGTH_SHORT)
                    .show();
        }
        if(item.getItemId()==R.id.menu_logout){
            Snackbar.make(findViewById(android.R.id.content).getRootView(), "Good Bye..", Snackbar.LENGTH_SHORT)
                    .show();
        }

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if(item.getItemId()==R.id.menu_home){
            Snackbar.make(findViewById(android.R.id.content).getRootView(), "Going to Home", Snackbar.LENGTH_SHORT)
                    .show();
        }
        if(item.getItemId()==R.id.menu_profile){
            Snackbar.make(findViewById(android.R.id.content).getRootView(), "Going to Profile", Snackbar.LENGTH_SHORT)
                    .show();
        }
        if(item.getItemId()==R.id.menu_orders){
            Snackbar.make(findViewById(android.R.id.content).getRootView(), "Going to Orders", Snackbar.LENGTH_SHORT)
                    .show();
        }
        if(item.getItemId()==R.id.menu_logout){
            Snackbar.make(findViewById(android.R.id.content).getRootView(), "Good Bye..", Snackbar.LENGTH_SHORT)
                    .show();
        }
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_drawer, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
//        AlertDialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Do you want to exit ?");
        builder.setTitle("Alert !");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes",
                new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        finish();
                    }
                });
        builder.setNegativeButton("No",
                new DialogInterface
                        .OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        dialog.cancel();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}