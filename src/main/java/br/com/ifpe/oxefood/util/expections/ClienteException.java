package br.com.ifpe.oxefood.util.expections;

public class ClienteException extends RuntimeException{
    public static final String MSG_NUMERO_PREFIXO = "Não é permitido números com o prefixo diferente ao 81";

    public ClienteException(String msg){
        super(String.format(msg));
    }
}
