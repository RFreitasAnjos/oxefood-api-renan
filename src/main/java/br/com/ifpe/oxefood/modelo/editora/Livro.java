package br.com.ifpe.oxefood.modelo.editora;

import org.hibernate.annotations.SQLRestriction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@SQLRestriction("habilitado = true")
@Entity
@Table(name = "Livro")
public class Livro extends EntidadeAuditavel{
   @JsonIgnore
   @ManyToOne
   private Editora editora;
   
   @Column
   private String titulo;

   @Column
   private Integer qtdPaginas;

   @Column
   private String autor;
   
   @Column
   private Integer anoLancamento;

   @Column
   private Double preco;
}
