package br.gov.sp.etc.estacionamento.controller;


import br.gov.sp.etc.estacionamento.model.Veiculo;
import br.gov.sp.etc.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("veiculo") // quer dizer que tudo vai ter veiculo antes, generalização
public class VeiculoController {

    @Autowired
    VeiculoService service;

    @PostMapping("cadastrar")
    public String cadastrar(Veiculo x){
        service.cadastrarVeiculo(x);
        return "registrar-entrada";
    }

    @GetMapping("registrar-entrada")
    public String registrarEntrada(){
        return "registrar-entrada";
    }

    @GetMapping("registrar-saida")
    public String registrarSaida() {
        return "registrar-saida";
    }
}
