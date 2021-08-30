package br.com.cadastro.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.cadastro.dtos.PedidoDTO;
import br.com.cadastro.services.PedidoService;

@Controller
@RequestMapping(value = "/api/cadastroPedido")
public class PedidoResource {
	
	@Autowired
	private PedidoService pedidoService;
	
	@PostMapping
	public ResponseEntity<PedidoDTO> salvar(@RequestBody PedidoDTO pedidoDTO){
		pedidoDTO = pedidoService.salvarPedido(pedidoDTO);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                    .buildAndExpand(pedidoDTO.getUuid()).toUri();
        return ResponseEntity.created(uri).body(pedidoDTO);
	}
}
