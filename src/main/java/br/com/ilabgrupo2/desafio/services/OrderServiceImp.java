package br.com.ilabgrupo2.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.ilabgrupo2.desafio.dto.CreateOrderDTO;
import br.com.ilabgrupo2.desafio.dto.ResponseOrderDTO;
import br.com.ilabgrupo2.desafio.model.Pedido;
import br.com.ilabgrupo2.desafio.repository.OrderRepository;

@Component
public class OrderServiceImp implements IOrderService{
    
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public ResponseOrderDTO createOrder(CreateOrderDTO newOrder) {
        try {
			Pedido order = new Pedido();

			order.setIdCliente(newOrder.getIdCliente()); 
			order.setListaProdutos(newOrder.getListaProdutos());
            order.setValorTotal(newOrder.getValorTotal());
			
			order = orderRepository.save(order);
			
			ResponseOrderDTO orderResponse = new ResponseOrderDTO(order);

			return orderResponse;
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
    }

    @Override
    public ResponseOrderDTO getOrderById(Long id) {
        try {
			return orderRepository.findByIdCliente(id);			
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
    }

    @Override
    public List<ResponseOrderDTO> getAllOrders() {
		return orderRepository.findClientAll();		
    }

    @Override
    public ResponseOrderDTO updateOrder(ResponseOrderDTO updateOrder) {
        try {
			Pedido order = orderRepository.findById(updateOrder.getId()).get();
			System.out.println("--------------"+ order);
			updateOrderFields(updateOrder, order);

			Pedido pedido = (orderRepository.save(new Pedido(order.getId(), order.getValorTotal(), order.getIdCliente(), order.getListaProdutos())));

            //return new ResponseOrderDTO(orderRepository.save(new Pedido(order.getId(), order.getValorTotal(), order.getIdCliente(), order.getListaProdutos())));
			System.out.println("-----------------------------"+ pedido);
            return new ResponseOrderDTO(pedido);
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
    }

    @Override
    public String deleteOrder(Long id) {
        try {
			Pedido order = orderRepository.findById(id).get();
			
			if (order == null) {
				System.out.println("Pedido não encontrado!");
				return "error";
			}
			
			orderRepository.delete(new Pedido(order.getId(), order.getValorTotal(), order.getIdCliente(), order.getListaProdutos()));
			
			return "redirect:/index";
		} catch (Exception ex) {
			ex.printStackTrace();
			return "error";
		}
    }


    private void updateOrderFields(ResponseOrderDTO updateOrder, Pedido order) {
		if(updateOrder.getListaProdutos() != null && updateOrder.getListaProdutos().size() > 0) {
			order.setListaProdutos(updateOrder.getListaProdutos());
		}

        if(updateOrder.getValorTotal() != null && updateOrder.getValorTotal() > 0) {
			order.setValorTotal(updateOrder.getValorTotal());
		}
    }
    
}
