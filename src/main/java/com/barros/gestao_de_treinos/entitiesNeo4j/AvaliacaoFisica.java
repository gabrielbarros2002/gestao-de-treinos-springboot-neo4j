package com.barros.gestao_de_treinos.entitiesNeo4j;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Objects;

@Node("AvaliacaoFisica")
public class AvaliacaoFisica implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull(message = "A data da avaliação é obrigatória")
    @PastOrPresent(message = "A data da avaliação não pode ser no futuro")
    private LocalDate data;

    @NotNull(message = "O peso é obrigatório")
    @Positive(message = "O peso deve ser maior que zero")
    private BigDecimal peso;

    @NotNull(message = "A altura é obrigatória")
    @Positive(message = "A altura deve ser maior que zero")
    private BigDecimal altura;

    @NotNull(message = "O IMC é obrigatório")
    @Positive(message = "O IMC deve ser maior que zero")
    private BigDecimal imc;

    @NotNull(message = "O percentual de gordura é obrigatório")
    @Positive(message = "O percentual de gordura deve ser maior que zero")
    private BigDecimal percentualGordura;

    @NotNull(message = "A massa muscular é obrigatória")
    @Positive(message = "A massa muscular deve ser maior que zero")
    private BigDecimal massaMuscularKg;

    @Relationship(type = "REALIZADA_POR", direction = Relationship.Direction.OUTGOING)
    private Usuario aluno;

    @Relationship(type = "REALIZADA_POR_INSTRUTOR", direction = Relationship.Direction.OUTGOING)
    private Usuario instrutor;

    public AvaliacaoFisica() {}

    public AvaliacaoFisica(Long id, LocalDate data, BigDecimal peso, BigDecimal altura, BigDecimal percentualGordura,
            BigDecimal massaMuscularKg, Usuario instrutor, Usuario aluno) {
        this.id = id;
        this.data = data;
        this.peso = peso;
        this.altura = altura;
        this.percentualGordura = percentualGordura;
        this.massaMuscularKg = massaMuscularKg;
        this.instrutor = instrutor;
        this.aluno = aluno;
        calcularIMC();
    }

    private void calcularIMC() {
        if (peso != null && altura != null && altura.compareTo(BigDecimal.ZERO) > 0) {
            BigDecimal alturaAoQuadrado = altura.multiply(altura);
            this.imc = peso.divide(alturaAoQuadrado, 2, RoundingMode.HALF_EVEN);
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
        calcularIMC();
    }

    public BigDecimal getAltura() {
        return altura;
    }

    public void setAltura(BigDecimal altura) {
        this.altura = altura;
        calcularIMC();
    }

    public BigDecimal getImc() {
        return imc;
    }

    public BigDecimal getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(BigDecimal percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public BigDecimal getMassaMuscularKg() {
        return massaMuscularKg;
    }

    public void setMassaMuscularKg(BigDecimal massaMuscularKg) {
        this.massaMuscularKg = massaMuscularKg;
    }

    public Usuario getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Usuario instrutor) {
        this.instrutor = instrutor;
    }

    public Usuario getAluno() {
        return aluno;
    }

    public void setAluno(Usuario aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        AvaliacaoFisica that = (AvaliacaoFisica) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "AvaliacaoFisica{" +
                "id=" + id +
                ", data=" + data +
                ", peso=" + peso +
                ", altura=" + altura +
                ", imc=" + imc +
                ", percentualGordura=" + percentualGordura +
                ", massaMuscularKg=" + massaMuscularKg +
                ", aluno=" + aluno +
                ", instrutor=" + instrutor +
                '}';
    }
}
