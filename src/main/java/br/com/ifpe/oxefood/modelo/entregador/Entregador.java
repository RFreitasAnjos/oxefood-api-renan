package br.com.ifpe.oxefood.modelo.entregador;

import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Entregador")
@SQLRestriction("habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Entregador extends EntidadeAuditavel{
    @Column(nullable= false)
    private String nome;
    
    @Column(nullable= false)
    private String cpf;

    @Column(nullable= false)
    private String rg;

    @Column(nullable= false)
    private LocalDate dataNascimento;

    @Column(nullable= false)
    private String foneCelular;

    @Column
    private String foneFixo;

    @Column
    private Integer qtdEntregasRealizadas;

    @Column
    private Double valorFrete;

    @Column(nullable= false)
    private String enderecoRua;

    @Column
    private String enderecoCompleto;

    @Column(nullable= false)
    private String enderecoNumero;

    @Column(nullable= false)
    private String enderecoBairro;

    @Column(nullable= false)
    private String enderecoCidade;

    @Column(nullable= false)
    private String enderecoCep;

    @Column(nullable= false)
    private String enderecoComplemento;

    @Column(nullable= false)
    private String enderecoUf;

    @Column
    private Boolean ativo;
}
