package com.job.servicedesk.Views;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.job.servicedesk.R;

public class ResultMenu extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private String nombre;
    private String rol;
    private String user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_menu);

        Intent intent = getIntent();
        nombre = intent.getStringExtra("nombre");
        rol = intent.getStringExtra("rol");
        user = intent.getStringExtra("usuario");

        // Setear Toolbar como action bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set DrawerLayout
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        // Set drawer toggle icon
        /*final ActionBar ab = getSupportActionBar();
        if (ab != null) {
            ab.setHomeAsUpIndicator(R.drawable.ic_menu);
            ab.setDisplayHomeAsUpEnabled(true);
        }*/

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, android.R.string.ok, android.R.string.cancel);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set NavigationItemSelectedListener
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                // Do action by menu item id
                switch (menuItem.getItemId()) {
                    case R.id.new_ticket:
                        Toast.makeText(ResultMenu.this, "Registrar Ticket Nuevo...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.est_ticket:
                        Toast.makeText(ResultMenu.this, "Consultar Estado de Tickets...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.all_ticket:
                        Toast.makeText(ResultMenu.this, "Consultar Todos los Tickets...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.asig_ticket:
                        Toast.makeText(ResultMenu.this, "Asignar Tickets a Tecnico...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.rep_ticket:
                        Toast.makeText(ResultMenu.this, "Reporte de Tickets...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.cons_ticket:
                        Toast.makeText(ResultMenu.this, "Consultar Tickets Asignados...", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.ate_ticket:
                        Toast.makeText(ResultMenu.this, "Atender Tickets Asignados...", Toast.LENGTH_SHORT).show();
                        break;
                }

                // Close drawer
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        // Change navigation header information
        ImageView photoImage = (ImageView) navigationView.getHeaderView(0).findViewById(R.id.menu_photo);
        photoImage.setBackgroundResource(R.drawable.ic_profile);

        TextView fullnameText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_fullname);
        fullnameText.setText("Bienvenido " + nombre);

        TextView userText = (TextView) navigationView.getHeaderView(0).findViewById(R.id.menu_email);
        userText.setText("Rol: " + rol);

        switch (rol) {
            case "Cliente":
                navigationView.getMenu().findItem(R.id.new_ticket).setVisible(true);
                navigationView.getMenu().findItem(R.id.est_ticket).setVisible(true);
                navigationView.getMenu().findItem(R.id.all_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.asig_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.rep_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.cons_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.ate_ticket).setVisible(false);
                break;
            case "Supervisor":
                navigationView.getMenu().findItem(R.id.new_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.est_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.all_ticket).setVisible(true);
                navigationView.getMenu().findItem(R.id.asig_ticket).setVisible(true);
                navigationView.getMenu().findItem(R.id.rep_ticket).setVisible(true);
                navigationView.getMenu().findItem(R.id.cons_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.ate_ticket).setVisible(false);
                break;
            case "Tecnico":
                navigationView.getMenu().findItem(R.id.new_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.est_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.all_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.asig_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.rep_ticket).setVisible(false);
                navigationView.getMenu().findItem(R.id.cons_ticket).setVisible(true);
                navigationView.getMenu().findItem(R.id.ate_ticket).setVisible(true);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }
/*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.perfil:
                Toast.makeText(this, "Acer+ca de...", Toast.LENGTH_SHORT).show();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home: // Option open drawer
                if (!drawerLayout.isDrawerOpen(GravityCompat.START))
                    drawerLayout.openDrawer(GravityCompat.START);   // Open drawer
                else
                    drawerLayout.closeDrawer(GravityCompat.START);    // Close drawer
                return true;
        }

        int id = item.getItemId();
        switch (id) {
            case R.id.perfil:
                Toast.makeText(this, "Soy " + nombre, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.configuracion:
                Toast.makeText(this, "Revise Menu...", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.cerrar_sesion:
                Intent intent = new Intent(ResultMenu.this, MainActivity.class);
                startActivity(intent);
                finish();
                Toast.makeText(this, "Vuelva pronto", Toast.LENGTH_SHORT).show();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
