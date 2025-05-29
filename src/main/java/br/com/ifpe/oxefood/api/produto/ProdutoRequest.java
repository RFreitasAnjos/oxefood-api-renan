package br.com.ifpe.oxefood.api.produto;

import br.com.ifpe.oxefood.modelo.produto.Produto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoRequest {

    private String titulo;
    
    private String codigo;

    private String descricao;

    public Produto build(){

        return Produto.builder()
            .codigo(codigo)    
            .titulo(titulo)
            .descricao(descricao)
            
            .build();
    }
}
