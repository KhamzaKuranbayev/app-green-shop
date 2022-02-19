package uz.webbrain.appgreenshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.webbrain.appgreenshop.dto.ShoppingCartDto;
import uz.webbrain.appgreenshop.entity.ShoppingCart;
import uz.webbrain.appgreenshop.service.ShoppingCartService;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/shopping_cart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public ShoppingCart save(@RequestBody ShoppingCartDto dto){
        return shoppingCartService.save(dto);
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
    public ShoppingCart findById(@PathVariable Long id){
        return shoppingCartService.findById(id);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String delete(@PathVariable Long id){
        return shoppingCartService.delete(id);
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
    public ShoppingCart edit(@PathVariable Long id, @RequestBody ShoppingCartDto dto){
        return shoppingCartService.edit(id, dto);
    }

    @RequestMapping(value = "/get_list", method = RequestMethod.GET)
    public List<ShoppingCart> shoppingCarts(@RequestParam List<Long> id){
        return shoppingCartService.findByList(id);
    }

}
