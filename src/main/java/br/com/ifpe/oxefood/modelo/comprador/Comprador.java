package br.com.ifpe.oxefood.modelo.comprador;


import java.time.LocalDate;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.segmento.Segmento;
import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "comprador")
@SQLRestriction("habilitado = true")
public class Comprador extends EntidadeAuditavel{
    
    @OneToOne
    private Segmento segmento;
    
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String enderecoComercial;

    @Column(nullable = false)
    private String enderecoResidencial;

    @Column(nullable = false)
    private Double comissao;

    @Column(nullable = false)
    private Integer qtdComprasMediasMes;

    @Column(nullable = false)
    private LocalDate contratadoEm;


}
