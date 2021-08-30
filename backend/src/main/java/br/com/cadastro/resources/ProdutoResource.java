package br.com.cadastro.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cadastro.dtos.ProdutoDTO;
import br.com.cadastro.services.ProdutoService;

@Controller
@RequestMapping(value = "/api/cadastro")
public class ProdutoResource {
	
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public ResponseEntity<Page<ProdutoDTO>> listar(Pageable pageable){
		Page<ProdutoDTO> produto = produtoService.listarTodosProduto(pageable);
		return ResponseEntity.ok(produto);
	}
	
	@GetMapping(value = "/{uuid}")
	public ResponseEntity<ProdutoDTO> listarProdutoPorUuid(@PathVariable String uuid){
		ProdutoDTO produto = produtoService.listarProdutoPorUuid(uuid);
		return ResponseEntity.ok(produto);
	}
	
	@DeleteMapping(value = "/{uuid}")
	public ResponseEntity<ProdutoDTO> removerProduto(@PathVariable String uuid){
		produtoService.removerProduto(uuid);
		return ResponseEntity.noContent().build();
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> salvar(@RequestBody ProdutoDTO produtoDTO){
		produtoDTO = produtoService.salvarProduto(produtoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(produtoDTO.getUuid()).toUri();
        return ResponseEntity.created(uri).body(produtoDTO);
	}
	
	@PutMapping
	public ResponseEntity<ProdutoDTO> atualizar(@RequestBody ProdutoDTO produtoDTO, @PathVariable String uuid){
		produtoDTO = produtoService.atualizarProduto(produtoDTO, uuid);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(produtoDTO.getUuid()).toUri();
        return ResponseEntity.created(uri).body(produtoDTO);
	}
}
