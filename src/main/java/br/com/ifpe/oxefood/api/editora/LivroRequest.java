package br.com.ifpe.oxefood.api.editora;

import br.com.ifpe.oxefood.modelo.editora.Livro;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LivroRequest {
   
   private String autor; 

   private Integer anoLancamento;

   private String titulo;

   private Integer qtdPaginas;

   private Double preco;

   public Livro build(){
      return Livro.builder()
         .autor(autor)
         .anoLancamento(anoLancamento)
         .titulo(titulo)
         .qtdPaginas(qtdPaginas)
         .preco(preco)
         .build();
   }
}
