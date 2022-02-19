package uz.webbrain.appgreenshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import uz.webbrain.appgreenshop.dto.OrderCreateDto;
import uz.webbrain.appgreenshop.entity.Order;
import uz.webbrain.appgreenshop.entity.User;
import uz.webbrain.appgreenshop.exception.BadRequestException;
import uz.webbrain.appgreenshop.exception.NotFoundException;
import uz.webbrain.appgreenshop.repository.OrderRepository;
import uz.webbrain.appgreenshop.repository.UserRepository;
import uz.webbrain.appgreenshop.rest.responses.Response;
import uz.webbrain.appgreenshop.service.OrderService;

import java.util.List;


@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;



    @Override
    public Response saveOrder(OrderCreateDto dto) {

        Order order = new Order(
                dto.getTotalPrice(),
                dto.getDate(),
                userRepository.findById(dto.getUserId()).orElseThrow(() -> new NotFoundException("Not Found User")).getId(),
                dto.getStatus(),
                null);
        Order savedOrder = orderRepository.save(order);

        return new Response(true, "Successfully Saved", savedOrder, HttpStatus.CREATED);
    }


    @Override
    public Response findAllPageable(Pageable pageable) {
        Page<Order> orderPage = orderRepository.findAll(pageable);
        List<Order> orderList = orderPage.getContent();

        Response response = new Response(true, "Order List", orderList, HttpStatus.OK);
        response.getMap().put("size", orderPage.getSize());
        response.getMap().put("total_elements", orderPage.getTotalElements());
        response.getMap().put("total_pages", orderPage.getTotalPages());
        return response;
    }


    @Override
    public Response findById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order Not Found"));
        return new Response(true, "Order", order, HttpStatus.OK);
    }

    @Override
    public Response updateOrder(Long orderId, OrderCreateDto dto) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order Not Found"));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new NotFoundException("User Not Found"));

        if (!order.getTotalPrice().equals(dto.getTotalPrice())) {
            order.setTotalPrice(dto.getTotalPrice());
        }

        if (!order.getDate().equals(dto.getDate())) {
            throw new BadRequestException("Not Access To Change The Date!");
        }

        if (!order.getStatus().equals(dto.getStatus())) {
            order.setStatus(dto.getStatus());
        }

        if (!order.getDeliveryAddressId().equals(dto.getDeliveryAddressId())) {
            order.setDeliveryAddressId(dto.getDeliveryAddressId());
        }

        if (!order.getUserId().equals(user.getId())) {
            order.setUserId(user.getId());
        }

        Order updatedOrder = orderRepository.save(order);
        return new Response(true, "The Order Updated: ", updatedOrder, HttpStatus.CREATED);
    }


    @Override
    public Response removeOrderById(Long orderId) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order Not Found"));

        return new Response(true, "Successfully Deleted", order, HttpStatus.OK);
    }
}
