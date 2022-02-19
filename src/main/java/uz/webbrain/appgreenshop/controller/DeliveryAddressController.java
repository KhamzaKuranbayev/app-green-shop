package uz.webbrain.appgreenshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.webbrain.appgreenshop.dto.DeliveryAddressDto;
import uz.webbrain.appgreenshop.entity.DeliveryAddress;
import uz.webbrain.appgreenshop.service.DeliveryAddressService;

import java.util.List;

@RestController
@RequestMapping("/api/delivery_address")
@RequiredArgsConstructor
public class DeliveryAddressController {

    private final DeliveryAddressService deliveryAddressService;

    @PostMapping("/add")
    public DeliveryAddress add(@RequestBody DeliveryAddressDto dto){
        return deliveryAddressService.add(dto);
    }

    @GetMapping("/getOne/{id}")
    public DeliveryAddress getOne(@PathVariable Long id){
        return deliveryAddressService.findById(id);
    }

    @GetMapping("/getAll")
    public List<DeliveryAddress> getAll(){
        return deliveryAddressService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public String deleteById(@PathVariable Long id){
        return deliveryAddressService.deleteById(id);
    }

    @PutMapping("/update/{id}")
    public DeliveryAddress update(@PathVariable Long id, @RequestBody DeliveryAddressDto dto){
        return deliveryAddressService.updateById(id, dto);
    }
}
