package br.com.ifpe.oxefood.api.categoria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ifpe.oxefood.modelo.categoria.CategoriaProduto;
import br.com.ifpe.oxefood.modelo.categoria.CategoriaProdutoService;

@RestController
@RequestMapping("/api/categoriaproduto")
@CrossOrigin
public class CategoriaProdutoController {
	@Autowired
	private CategoriaProdutoService categoriaProdutoService;
	
	@PostMapping
	public ResponseEntity<CategoriaProduto> save(@RequestBody CategoriaProdutoRequest request){
		
	}
	
	@GetMapping("/{ìd}")
	public CategoriaProduto obterPorId(@PathVariable Long id) {
		return categoriaProdutoService.obterPorId(id);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<CategoriaProduto> update(@PathVariable("id") Long id, @RequestBody CategoriaProdutoRequest request){
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		categoriaProdutoService.delete(id);
		return ResponseEntity.ok().build();
	}
}
