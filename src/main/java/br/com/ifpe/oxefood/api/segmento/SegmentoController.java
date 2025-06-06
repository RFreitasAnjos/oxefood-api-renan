package br.com.ifpe.oxefood.api.segmento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ifpe.oxefood.modelo.segmento.Segmento;
import br.com.ifpe.oxefood.modelo.segmento.SegmentoService;


@Controller
@RequestMapping
@CrossOrigin
public class SegmentoController {

    @Autowired
    private SegmentoService segmentoService;

    @PostMapping
    public ResponseEntity<Segmento> adicionarSegmento(@RequestBody SegmentoRequest segmentoRequest){
        Segmento segmento = segmentoService.save(segmentoRequest.build());
        return new ResponseEntity<Segmento>(segmento, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Segmento> atualizarSegmento(@PathVariable("segmentoId") Long segmentoId, @RequestBody SegmentoRequest segmentoRequest){
        segmentoService.update(segmentoId, segmentoRequest.build());
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removerEnderecoCliente(@PathVariable("segmentoId") Long segmentoId){
        segmentoService.delete(segmentoId);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<Segmento> listarTodos() {
        return segmentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public Segmento obterPorIdSegmento(@PathVariable("id") Long id) {
        return segmentoService.obterPorId(id);
    }
    
    
}
