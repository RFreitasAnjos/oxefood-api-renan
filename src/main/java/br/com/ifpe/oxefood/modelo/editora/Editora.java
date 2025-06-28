package br.com.ifpe.oxefood.modelo.editora;

import java.util.List;

import org.hibernate.annotations.SQLRestriction;

import br.com.ifpe.oxefood.util.entity.EntidadeAuditavel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Editora")
@SQLRestriction("habilitado = true")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Editora extends EntidadeAuditavel{
   
   @Column
   private String nome;
   @Column
   private Integer anoFundacao;
   @Column
   private String endereco;

   @OneToMany(mappedBy = "editora", orphanRemoval = true, fetch= FetchType.EAGER)
   private List<Livro> livros;

}
