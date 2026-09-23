package br.gov.sp.etc.estacionamento.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;


@Entity(name = "tb_veiculo")
public class VeiculoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // como se fosse a chave primária
    // Strategy é o parâmetro que define qual regra/método será usado para gerar esse valor.
    // genarationtype serve para É o tipo enumerado (Enum) do Java que lista todas as estratégias disponíveis
    // .identity É a estratégia específica escolhida.
    // Ela manda o banco de dados usar a coluna de auto-incremento própria da tabela para criar o número do
    // ID durante o INSERT
    private Long id;
    // é Long pq daí é visão que o sistema pode crscer

    private String placa;
    private String modelo;
    private String cor;
    private String observacao;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private Boolean status;


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(LocalDateTime horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public void setHoraSaida(LocalDateTime horaSaida) {
        this.horaSaida = horaSaida;
    }
}

