package br.com.ifpe.oxefood.modelo.comprador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class CompradorService {

    @Autowired
    private CompradorRepository compradorRepository;

    @Transactional
    public Comprador save(Comprador comprador){
        comprador.setHabilitado(Boolean.TRUE);
        return compradorRepository.save(comprador);
    }

    @Transactional
    public void update(Long id, Comprador compradorAlterado){
        Comprador comprador = compradorRepository.findById(id).get();
        comprador.setSegmento(compradorAlterado.getSegmento());
        comprador.setNome(compradorAlterado.getNome());
        comprador.setEnderecoComercial(compradorAlterado.getEnderecoComercial());
        comprador.setEnderecoResidencial(compradorAlterado.getEnderecoResidencial());
        comprador.setComissao(compradorAlterado.getComissao());
        comprador.setQtdComprasMediasMes(compradorAlterado.getQtdComprasMediasMes());
        comprador.setContratadoEm(compradorAlterado.getContratadoEm());

        compradorRepository.save(comprador);
    }

    @Transactional
    public void delete(Long id){
        Comprador comprador = compradorRepository.findById(id).get();
        comprador.setHabilitado(Boolean.FALSE);

        compradorRepository.save(comprador);
    }

    public List<Comprador> listarTodos(){
        return compradorRepository.findAll();
    }

    public Comprador obterPorId(Long id){
        return compradorRepository.findById(id).get();
    }
}
