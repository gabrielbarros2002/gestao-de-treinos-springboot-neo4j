package com.barros.gestao_de_treinos.mappers;

import com.barros.gestao_de_treinos.DTOs.UsuarioDTO;
import com.barros.gestao_de_treinos.entities.Usuario;
import com.barros.gestao_de_treinos.entities.enums.Perfil;

public class UsuarioMapper {

    public static UsuarioDTO toDTO(Usuario entity) {
        if (entity == null) return null;

        UsuarioDTO dto = new UsuarioDTO();
        dto.setIdUsuario(entity.getId());
        dto.setNomeUsuario(entity.getNome());
        dto.setEmailUsuario(entity.getEmail());
        dto.setSenhaUsuario(entity.getSenha());
        dto.setDataNascimentoUsuario(entity.getDataNascimento());

        if (entity.getPerfil() != null) {
            dto.setPerfilUsuario(entity.getPerfil().getCodigo());
        }

        return dto;
    }

    public static Usuario toEntity(UsuarioDTO dto) {
        if (dto == null) return null;

        Usuario entity = new Usuario();
        entity.setId(dto.getIdUsuario());
        entity.setNome(dto.getNomeUsuario());
        entity.setEmail(dto.getEmailUsuario());
        entity.setSenha(dto.getSenhaUsuario());
        entity.setDataNascimento(dto.getDataNascimentoUsuario());

        if (dto.getPerfilUsuario() != null) {
            entity.setPerfil(Perfil.fromCodigo(dto.getPerfilUsuario()));
        }

        return entity;
    }
}
