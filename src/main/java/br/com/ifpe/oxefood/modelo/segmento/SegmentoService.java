package br.com.ifpe.oxefood.modelo.segmento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class SegmentoService {

    @Autowired
    private SegmentoRepository segmentoRepository;

    @Transactional
    public Segmento save(Segmento categoriaProduto) {
		categoriaProduto.setHabilitado(Boolean.TRUE);
		return segmentoRepository.save(categoriaProduto);
	}
	public List<Segmento> listarTodos(){
		return segmentoRepository.findAll();
	}
	@Transactional
	public Segmento obterPorId(Long id) {
		return segmentoRepository.findById(id).get();
	}
	
	@Transactional
	public void update(Long id, Segmento segmentoAlterado) {
		
		Segmento segmento = segmentoRepository.findById(id).get();
		segmento.setDescricao(segmentoAlterado.getDescricao());
		
		segmentoRepository.save(segmento);
	}
	
	@Transactional
	public void delete(Long id) {
		Segmento segmento = segmentoRepository.findById(id).get();
		segmento.setHabilitado(Boolean.FALSE);
		segmentoRepository.save(segmento);
	}
}
