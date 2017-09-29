package com.job.servicedesk.Controllers;

import com.job.servicedesk.Models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioRepository {

    private static UsuarioRepository _INSTANCE = null;

    private UsuarioRepository() {
    }

    public static UsuarioRepository getInstance() {
        if (_INSTANCE == null)
            _INSTANCE = new UsuarioRepository();
        return _INSTANCE;
    }

    private static List<Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario() {

        Usuario usr1 = new Usuario("calfredo", "cliente", "Alfredo", "Cliente");
        Usuario usr2 = new Usuario("slucho", "supervisor", "Lucho", "Supervisor");
        Usuario usr3 = new Usuario("tjorge", "tecnico", "Jorge", "Tecnico");

        usuarios.add(usr1);
        usuarios.add(usr2);
        usuarios.add(usr3);
    }

    public List<Usuario> getUsuarios() {
        return this.usuarios;
    }


    public static Usuario validarUsuario(String user, String password) {

        for (Usuario usuario : usuarios) {
            if (usuario.getUsuario().equals(user) && usuario.getContraseña().equals(password)) {
                return usuario;
            }
        }
        return null;
    }
}


/*
    String unom = Usuario.getNombre();
    String uuser = Usuario.getUsuario();
    String upass = Usuario.getContraseña();
    String urol = Usuario.getRol();
*/