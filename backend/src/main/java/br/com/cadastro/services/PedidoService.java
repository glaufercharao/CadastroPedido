package br.com.cadastro.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dtos.PedidoDTO;
import br.com.cadastro.entities.Pedido;
import br.com.cadastro.mapper.Mappable;
import br.com.cadastro.repositories.PedidoRepository;

@Service
public class PedidoService implements Mappable{
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Transactional
	public PedidoDTO salvarPedido(PedidoDTO pedido) {
		return map(pedidoRepository.save(map(pedido, Pedido.class)), PedidoDTO.class);
	}
}
