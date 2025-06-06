package br.com.ifpe.oxefood.modelo.segmento;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.modelo.comprador.Comprador;
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
@Table(name= "segmento")
@SQLRestriction("habilitado = true")
public class Segmento extends EntidadeAuditavel{
    
    @OneToOne
    private Comprador comprador;

    @Column(length = 100, nullable = false)
    private String descricao;
}
