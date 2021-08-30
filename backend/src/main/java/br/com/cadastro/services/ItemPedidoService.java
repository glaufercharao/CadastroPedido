package br.com.cadastro.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cadastro.dtos.ItemPedidoDTO;
import br.com.cadastro.entities.ItemPedido;
import br.com.cadastro.mapper.Mappable;
import br.com.cadastro.repositories.ItemPedidoRepository;

@Service
public class ItemPedidoService implements Mappable{
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	@Transactional
	public ItemPedidoDTO salvarItemPedido(ItemPedidoDTO itemPedido) {
		
		return map(itemPedidoRepository.save(map(itemPedido, ItemPedido.class)), ItemPedidoDTO.class);
	}
}
