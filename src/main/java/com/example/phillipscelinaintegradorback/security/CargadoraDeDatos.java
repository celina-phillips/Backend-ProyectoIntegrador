package com.example.phillipscelinaintegradorback.security;

import com.example.phillipscelinaintegradorback.domain.Usuario;
import com.example.phillipscelinaintegradorback.domain.UsuarioRol;
import com.example.phillipscelinaintegradorback.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargadoraDeDatos implements ApplicationRunner {
    private UsuarioRepository usuarioRepository;
    @Autowired
    public CargadoraDeDatos(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args) {
        BCryptPasswordEncoder cifrador= new BCryptPasswordEncoder();
        String passACifrar="123456789";
        String passCifrada=cifrador.encode(passACifrar);
        Usuario usuarioAInsertar= new Usuario("celina","phillips",
                "celina@gmail.com",passCifrada,UsuarioRol.ROLE_USER);
        usuarioRepository.save(usuarioAInsertar);
    }
}
