package com.example.shopapp.Controller;

import com.example.shopapp.Entitities.Order;
import com.example.shopapp.Requests.CreateOrderRequest;
import com.example.shopapp.Requests.UpdateOrderRequest;
import com.example.shopapp.Service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }



    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long orderId) {
        return orderService.getOrderById(orderId);
    }

    @PostMapping
    public Order createOrder(@RequestBody CreateOrderRequest createOrderRequest) {
        return orderService.createOrder(createOrderRequest);
    }

    @PutMapping("/{id}")
    public Order updateOrderById(@PathVariable Long orderId,
                                 @RequestBody UpdateOrderRequest updateOrderRequest) {
        return orderService.updateOrderById(orderId, updateOrderRequest);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderById(@PathVariable Long id) {
        orderService.deleteOrderById(id);
    }
}
