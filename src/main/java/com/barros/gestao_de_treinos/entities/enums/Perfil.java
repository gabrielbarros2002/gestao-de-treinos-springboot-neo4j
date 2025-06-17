package com.barros.gestao_de_treinos.entities.enums;

public enum Perfil {
    ALUNO("ALUNO"),
    INSTRUTOR("INSTRUTOR");

    private String codigo;

    Perfil(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public static Perfil fromCodigo(String codigo) {
        for (Perfil perfil : Perfil.values()) {
            if (perfil.getCodigo().equalsIgnoreCase(codigo)) {
                return perfil;
            }
        }
        throw new IllegalArgumentException("Perfil inválido: " + codigo);
    }
}
