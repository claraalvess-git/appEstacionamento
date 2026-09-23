package br.gov.sp.etc.estacionamento.service;

import br.gov.sp.etc.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etc.estacionamento.model.Veiculo;

import java.util.List;

public interface VeiculoService {
    public void cadastrarVeiculo (Veiculo veiculo);
    public List<VeiculoEntity> listaVeiculo();
    public boolean deletarVeiculo(Long id);
    public VeiculoEntity atualizarVeiculo(VeiculoEntity v);
    public VeiculoEntity buscaVeiculoPorId(Long id);

    // o void serve para já cadastrar


}
