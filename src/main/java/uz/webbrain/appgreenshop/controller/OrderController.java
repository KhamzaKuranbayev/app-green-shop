package uz.webbrain.appgreenshop.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import uz.webbrain.appgreenshop.dto.OrderCreateDto;
import uz.webbrain.appgreenshop.rest.responses.Response;
import uz.webbrain.appgreenshop.service.OrderService;
import uz.webbrain.appgreenshop.utils.ApiPageable;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/orders")
public class OrderController {

    private final OrderService orderService;


    @PostMapping
    public Response save(@RequestBody OrderCreateDto dto) {
        return orderService.saveOrder(dto);
    }


    @ApiPageable
    @GetMapping("/page/list")
    public HttpEntity<?> findAllPageable(@ApiIgnore Pageable pageable) {
        Response response = orderService.findAllPageable(pageable);
        return ResponseEntity.status(response.isSuccess() ? 200 : 500).body(response);
    }


    @GetMapping("/{order_id}")
    public Response findById(@PathVariable("order_id") Long orderId) {
        return orderService.findById(orderId);
    }

    @PutMapping("/{order_id}")
    public Response edit(@PathVariable("order_id") Long orderId,
                         @RequestBody OrderCreateDto dto) {
        return orderService.updateOrder(orderId, dto);
    }

    @DeleteMapping("/{order_id}")
    public Response removeById(@PathVariable("order_id") Long orderId) {
        return orderService.removeOrderById(orderId);
    }


}
