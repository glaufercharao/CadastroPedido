package br.com.cadastro.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cadastro.dtos.ItemPedidoDTO;
import br.com.cadastro.services.ItemPedidoService;

@Controller
@RequestMapping(value = "/api/cadastroItemPedido")
public class ItemPedidoResource {
	
	@Autowired
	private ItemPedidoService itemPedidoService;
	
	@PostMapping
	public ResponseEntity<ItemPedidoDTO> salvar(@RequestBody ItemPedidoDTO itemPedidoDTO){
		itemPedidoDTO = itemPedidoService.salvarItemPedido(itemPedidoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(itemPedidoDTO.getUuid()).toUri();
        return ResponseEntity.created(uri).body(itemPedidoDTO);
	}
}
