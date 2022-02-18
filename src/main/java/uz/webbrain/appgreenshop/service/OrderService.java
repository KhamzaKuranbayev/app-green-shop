package uz.webbrain.appgreenshop.service;

import org.springframework.data.domain.Sort;
import uz.webbrain.appgreenshop.dto.OrderCreateDto;
import uz.webbrain.appgreenshop.entity.Order;
import uz.webbrain.appgreenshop.rest.responses.Response;

import java.util.List;

public interface OrderService {
    Response saveOrder(OrderCreateDto dto);

    Response findById(Long orderId);

    Response updateOrder(Long orderId, OrderCreateDto dto);

    Response removeOrderById(Long orderId);

    Response findAllPageable(Integer page, Integer size, Sort sort);
}
