package br.com.ilabgrupo2.desafio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ilabgrupo2.desafio.dto.CreateOrderDTO;
import br.com.ilabgrupo2.desafio.dto.ResponseOrderDTO;
import br.com.ilabgrupo2.desafio.services.IOrderService;

@Controller
@RequestMapping("pedidos")
public class OrderController {
    

    @Autowired
    private IOrderService orderService;

    @GetMapping
    public String listOrders(Model model) {
      model.addAttribute("pedidos", orderService.getAllOrders());

      return "order/index";
    }

    @GetMapping("/register")
    public String createOrder(Model model) {
		model.addAttribute("pedidos", new CreateOrderDTO());

        return "order/order_register";
  }
	
  @PostMapping("/register")
	public String createOrder(@ModelAttribute CreateOrderDTO order, Model model) {

		ResponseOrderDTO regOrder = orderService.createOrder(order);
        
		if (regOrder == null) {
			model.addAttribute("error", "Erro ao criar pedido!");
			return "order/order_error";
		}
       
		model.addAttribute("pedidos", orderService.getAllOrders());
		return "order/index";
	}

    @GetMapping("/update/{id}")
	public String updateOrder(Model model) {
        model.addAttribute("pedido", new ResponseOrderDTO());
	    return "order/order_update";
	}

    @PostMapping("/update/{id}")
	public String updateOrder(@PathVariable("id") Long id, @ModelAttribute ResponseOrderDTO pedido, Model model) {
		System.out.println("---------" + pedido);
		ResponseOrderDTO updatedOrder = orderService.updateOrder(pedido);

		if (updatedOrder == null) {
			model.addAttribute("error", "Erro ao atualizar o pedido!");
			return "order/order_error";
		}
		
		model.addAttribute("pedidos", orderService.getAllOrders());
		return "order/index";
	}


    @GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable("id") Long id, Model model) {
		orderService.deleteOrder(id);

		model.addAttribute("pedidos", orderService.getAllOrders());
		return "order/index";
	}
}
