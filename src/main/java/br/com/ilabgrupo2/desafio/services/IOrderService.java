package br.com.ilabgrupo2.desafio.services;

import java.util.List;

import br.com.ilabgrupo2.desafio.dto.CreateOrderDTO;
import br.com.ilabgrupo2.desafio.dto.ResponseOrderDTO;

public interface IOrderService {
    
    ResponseOrderDTO createOrder (CreateOrderDTO newOrder);
	ResponseOrderDTO getOrderById(Long id);
	List<ResponseOrderDTO> getAllOrders();
	ResponseOrderDTO updateOrder(ResponseOrderDTO updateOrder);
	String deleteOrder(Long id);
}
