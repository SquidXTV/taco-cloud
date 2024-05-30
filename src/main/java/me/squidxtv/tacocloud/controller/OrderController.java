package me.squidxtv.tacocloud.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import me.squidxtv.tacocloud.data.OrderRepository;
import me.squidxtv.tacocloud.model.TacoOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
public class OrderController {

    private final OrderRepository orders;

    @Autowired
    public OrderController(OrderRepository orders) {
        this.orders = orders;
    }

    @ModelAttribute("order")
    public TacoOrder order() {
        return new TacoOrder();
    }

    @GetMapping
    public String view() {
        return "orders";
    }

    @PostMapping
    public String processOrder(@ModelAttribute("order") @Valid TacoOrder order, Errors errors, SessionStatus session) {
        if (errors.hasErrors()) {
            return "orders";
        }

        orders.save(order);
        log.info("Order submitted: {}", order);
        session.setComplete();

        return "redirect:/";
    }

}
