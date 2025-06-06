package br.com.ifpe.oxefood.api.entregador;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.ifpe.oxefood.modelo.entregador.Entregador;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntregadorRequest {
    private String nome;
    private String cpf;
    private String rg;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate dataNascimento;

    private String foneCelular;
    private String foneFixo;
    private String enderecoRua;
    private String enderecoCompleto;
    private String enderecoNumero;
    private String enderecoBairro;
    private String enderecoCidade;
    private String enderecoCep;
    private String enderecoComplemento;
    private String enderecoUf;

    public Entregador build(){
        return Entregador.builder()
                .nome(nome)
                .dataNascimento(dataNascimento)
                .cpf(cpf)
                .rg(rg)
                .foneCelular(foneCelular)
                .foneFixo(foneFixo)
                .enderecoRua(enderecoRua)
                .enderecoComplemento(enderecoComplemento)
                .enderecoNumero(enderecoNumero)
                .enderecoBairro(enderecoBairro)
                .enderecoCidade(enderecoCidade)
                .enderecoCep(enderecoCep)
                .enderecoComplemento(enderecoComplemento)
                .enderecoUf(enderecoUf)
            .build();
    }
}
