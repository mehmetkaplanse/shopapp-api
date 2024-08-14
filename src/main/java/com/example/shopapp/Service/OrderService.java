package com.example.shopapp.Service;

import com.example.shopapp.Entitities.Order;
import com.example.shopapp.Entitities.User;
import com.example.shopapp.Repository.OrderRepository;
import com.example.shopapp.Repository.UserRepository;
import com.example.shopapp.Requests.CreateOrderRequest;
import com.example.shopapp.Requests.UpdateOrderRequest;
import com.example.shopapp.Responses.OrderResponse;
import com.example.shopapp.Responses.ProductResponse;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public OrderService(OrderRepository orderRepository,
                        UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.userRepository = userRepository;
    }

    public List<OrderResponse> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream().map(order -> {
            OrderResponse response = new OrderResponse();
            Optional<User> optionalUser = userRepository.findById(order.getUser().getId());
            response.setId(order.getId());
            response.setUser(optionalUser.get().getUsername());
            response.setName(order.getName());
            response.setPrice(order.getPrice());
            response.setQuantity(order.getQuantity());
            response.setCreatedDate(order.getCreatedDate());

            return response;
        }).collect(Collectors.toList());
    }

    public Order getOrderById(Long orderId) {
        return orderRepository.findById(orderId).orElse(null);
    }

    public Order createOrder(CreateOrderRequest createOrderRequest) {
        Order toCreate = new Order();
        Optional<User> optionalUser = userRepository.findById(createOrderRequest.getUser_id());
        if(optionalUser.isPresent()) {
            toCreate.setUser(optionalUser.get());
            toCreate.setName(createOrderRequest.getName());
            toCreate.setPrice(createOrderRequest.getPrice());
            toCreate.setQuantity(createOrderRequest.getQuantity());
            toCreate.setCreatedDate(new Date());
        } else {
            throw new RuntimeException("User not found with id: " + createOrderRequest.getUser_id());
        }

        return orderRepository.save(toCreate);
    }

    public void deleteOrderById(Long id) {
        orderRepository.deleteById(id);
    }

    public Order updateOrderById(Long orderId, UpdateOrderRequest updateOrderRequest) {
        Optional<Order> optionalOrder = orderRepository.findById(orderId);
        Optional<User> optionalUser = userRepository.findById(updateOrderRequest.getUser_id());
        if(optionalOrder.isPresent() && optionalUser.isPresent()) {
            Order toUpdate = new Order();
            toUpdate.setName(updateOrderRequest.getName());
            toUpdate.setUser(optionalUser.get());
            toUpdate.setQuantity(updateOrderRequest.getQuantity());
            toUpdate.setPrice(updateOrderRequest.getPrice());
            orderRepository.save(toUpdate);
            return toUpdate;
        } else {
            return null;
        }
    }
}