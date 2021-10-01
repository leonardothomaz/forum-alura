package br.com.alura.forum.service

import br.com.alura.forum.model.Usuario
import org.springframework.stereotype.Service
import java.util.*

@Service
class UsuarioService(var usuario: List<Usuario>) {

    init {
        val user = Usuario(
                id = 1,
                nome = "Leonardo",
                email = "leonardo@.com"
        )

        usuario = Arrays.asList(user)
    }

    fun buscarPorId(id: Long): Usuario {
        return usuario
                .stream()
                .filter({ c -> c.id == id })
                .findFirst()
                .get()
    }
}
