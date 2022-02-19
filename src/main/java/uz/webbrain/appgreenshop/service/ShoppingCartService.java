package uz.webbrain.appgreenshop.service;

import uz.webbrain.appgreenshop.dto.ShoppingCartDto;
import uz.webbrain.appgreenshop.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {


    ShoppingCart save(ShoppingCartDto dto);

    ShoppingCart findById(Long id);

    ShoppingCart edit(Long id, ShoppingCartDto dto);

    String delete(Long id);

    List<ShoppingCart> findByList(List<Long> list);

}
