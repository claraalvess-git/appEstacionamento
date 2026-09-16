package br.gov.sp.etc.estacionamento.service;

import br.gov.sp.etc.estacionamento.entity.UsuarioEntity;
import br.gov.sp.etc.estacionamento.entity.VeiculoEntity;
import br.gov.sp.etc.estacionamento.model.Veiculo;
import br.gov.sp.etc.estacionamento.repository.VeiculoRepository;
import jakarta.persistence.FindOption;
import org.hibernate.annotations.Audited;
import org.hibernate.annotations.processing.Find;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired // serve para conectar a reposritory na classe serviceImplement, ou seja, injetar
    VeiculoRepository repository;

    @Override
    public void cadastrarVeiculo(Veiculo veiculo) {

        repository.save(toEntity(veiculo));
    }

    @Override
    public List<VeiculoEntity> listaVeiculo() {
       // return repository.findAll();
        List<VeiculoEntity>  veiculos = repository.findAll();
        return veiculos;
    }

    @Override
    public boolean deletarVeiculo(Long id) {

        try{
            repository.deleteById(id);
            return true; // vai retornar true se der certo
        } catch (Exception e) {
            throw new RuntimeException(e); // exceção falando que alguma coisa deu errado.
            // o try catch é capaz de pegar o erro.
            // e o exception joga na cara do usuário o erro
            // quando têm dependencias externas, como banco de dados e tals, teremos exception.
        }

    }

    @Override
    public VeiculoEntity atualizarVeiculo(VeiculoEntity v) {
        return repository.save(v); // .save serve para criar o dado na base e atualizar
    }

    // criar um metodo para mapear um Veiculo para VeiculoEntity

    private VeiculoEntity toEntity(Veiculo veiculo){
        VeiculoEntity entity = new VeiculoEntity();

        entity.setHoraEntrada(LocalDateTime.now());
        entity.setPlaca(veiculo.getPlaca());
        entity.setModelo(veiculo.getModelo());
        entity.setCor(veiculo.getCor());
        entity.setObservacao(veiculo.getObservacao());

        return entity;
    }

    private List<Veiculo>toListVeiculo(List<VeiculoEntity> entities){
        List<Veiculo> veiculos = new ArrayList<>();
        for (VeiculoEntity v: entities){
            Veiculo veiculo = new Veiculo();
            veiculo.setPlaca(v.getPlaca());
            veiculo.setCor(v.getCor());
            veiculo.setModelo(v.getModelo());
            veiculo.setObservacao(v.getObservacao());

            veiculos.add(veiculo);
        }
        return veiculos;
    }

}
