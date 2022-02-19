package uz.webbrain.appgreenshop.service;

import org.springframework.data.domain.Pageable;
import uz.webbrain.appgreenshop.dto.OrderCreateDto;
import uz.webbrain.appgreenshop.rest.responses.Response;


public interface OrderService {
    Response saveOrder(OrderCreateDto dto);

    Response findById(Long orderId);

    Response updateOrder(Long orderId, OrderCreateDto dto);

    Response removeOrderById(Long orderId);

    Response findAllPageable(Pageable pageable);
}
