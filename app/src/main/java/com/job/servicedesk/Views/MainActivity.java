package com.job.servicedesk.Views;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.job.servicedesk.R;
import com.job.servicedesk.Models.Usuario;
import com.job.servicedesk.Controllers.UsuarioRepository;

public class MainActivity extends AppCompatActivity {

    public EditText user;
    public EditText password;
   /* private String nom;
    private String rol;
    private String useri;
    private  String pass;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = (EditText) findViewById(R.id.user);
        password = (EditText) findViewById(R.id.pass);

        UsuarioRepository usuarioRepository = UsuarioRepository.getInstance();
        usuarioRepository.agregarUsuario();

        //UsuarioRepository usuarioRepository1 = UsuarioRepository.getUsuarios;
    }

    public void login(View view) {

        String usr1 = user.getText().toString();
        String pss1 = password.getText().toString();

        /*UsuarioRepository opeRepository = UsuarioRepository.getInstance();
        opeRepository.validarUsuario(usr1,pss1);*/

        Usuario usuario = UsuarioRepository.validarUsuario(usr1, pss1);

        if (usuario != null) {

            String nom = usuario.getNombre();
            String rol = usuario.getRol();
            String useri = usuario.getUsuario();

            Intent intent = new Intent(this, ResultMenu.class);
            /*Usuario userlogin = new Usuario(useri,pass,nom,rol);
            intent.putExtra("Usuasrio", userlogin);*/
            intent.putExtra("usuario", useri);
            intent.putExtra("nombre", nom);
            intent.putExtra("rol", rol);
            startActivity(intent);
            Toast.makeText(this, "Bienvenido " + nom, Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(this, "Usuario/Contraseña Incorrectos", Toast.LENGTH_SHORT).show();
            Toast.makeText(this, "Intentelo Nuevamente", Toast.LENGTH_SHORT).show();

        }
    }
}
