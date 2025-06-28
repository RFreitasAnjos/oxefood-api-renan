package br.com.ifpe.oxefood.util.expections;

public class ProdutoException extends RuntimeException{
    public static final String MSG_VALOR_MINIMO_PRODUTO = "Não é permitido inserir produtos com valores inferiores a R$10,00";

    public ProdutoException(String msg){
        super(String.format(msg));
    }
}
