package com.barros.gestao_de_treinos.DTOs;

import static com.barros.gestao_de_treinos.utils.Util.iniciarAtributosEmBranco;

public class AlunoTreinoDTO {

    private TreinoDTO treino;
    private Integer quantExecucoes;

    public AlunoTreinoDTO() {
        iniciarAtributosEmBranco(this);
    }

    public TreinoDTO getTreino() {
        return treino;
    }

    public void setTreino(TreinoDTO treino) {
        this.treino = treino;
    }

    public Integer getQuantExecucoes() {
        return quantExecucoes;
    }

    public void setQuantExecucoes(Integer quantExecucoes) {
        this.quantExecucoes = quantExecucoes;
    }
}
