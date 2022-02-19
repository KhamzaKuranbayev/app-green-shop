package uz.webbrain.appgreenshop.service;

import uz.webbrain.appgreenshop.dto.DeliveryAddressDto;
import uz.webbrain.appgreenshop.entity.DeliveryAddress;

import java.util.List;

public interface DeliveryAddressService {

    DeliveryAddress add(DeliveryAddressDto dto);

    DeliveryAddress findById(Long id);

    List<DeliveryAddress> getAll();

    String deleteById(Long id);

    DeliveryAddress updateById(Long id, DeliveryAddressDto dto);
}
