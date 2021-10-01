package br.com.alura.forum.service

import br.com.alura.forum.DTO.NovoTopicoDTO
import br.com.alura.forum.model.Topico
import org.springframework.stereotype.Service
import kotlin.collections.ArrayList

@Service
class TopicoService(
        private var topicos: List<Topico> = ArrayList(),
        private val cursoService: CursoService,
        private val usuarioService: UsuarioService
) {

    fun listar(): List<Topico> {
        return topicos
    }

    fun buscarPorId(id: Long): Topico {
        return topicos
                .stream()
                .filter({ t -> t.id == id })
                .findFirst()
                .get()
    }

    fun cadastrar(DTO: NovoTopicoDTO) {
        topicos = topicos.plus(Topico(
                id = topicos.size.toLong(),
                titulo = DTO.titulo,
                mensagem = DTO.mensagem,
                curso = cursoService.buscarPorId(DTO.idCurso),
                autor = usuarioService.buscarPorId(DTO.idAutor)
        ))
    }

}