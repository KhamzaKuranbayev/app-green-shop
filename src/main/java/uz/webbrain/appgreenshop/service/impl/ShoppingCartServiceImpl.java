package uz.webbrain.appgreenshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.webbrain.appgreenshop.dto.ShoppingCartDto;
import uz.webbrain.appgreenshop.entity.Incoming;
import uz.webbrain.appgreenshop.entity.ShoppingCart;
import uz.webbrain.appgreenshop.entity.User;
import uz.webbrain.appgreenshop.repository.IncomingRepository;
import uz.webbrain.appgreenshop.repository.ShoppingCartRepository;
import uz.webbrain.appgreenshop.repository.UserRepository;
import uz.webbrain.appgreenshop.service.ShoppingCartService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {

    private final ShoppingCartRepository shoppingCartRepository;
    private final UserRepository userRepository;
    private final IncomingRepository incomingRepository;

    public List<Incoming> toIncoming(List<Long> id){
        List<Incoming> incomingList = new ArrayList<>();
        for (Long a : id) {
            Optional<Incoming> byId = incomingRepository.findById(a);
            byId.ifPresent(incomingList::add);
        }
        return incomingList;
    }

    public List<User> toUser(List<Long> id){
        List<User> userList = new ArrayList<>();
        for (Long a: id){
            Optional<User> byId = userRepository.findById(a);
            byId.ifPresent(userList::add);
        }
        return userList;
    }

    public ShoppingCart optionalShoppingCart(Long id){
        Optional<ShoppingCart> byId = shoppingCartRepository.findById(id);
        if (!byId.isPresent())
            throw new RuntimeException("Id not found");

        return byId.get();
    }

    @Override
    public ShoppingCart save(ShoppingCartDto dto) {
        List<Incoming> incomingList = toIncoming(dto.getIncomingList());
        List<User> userList = toUser(dto.getUserList());
        return shoppingCartRepository.save(new ShoppingCart(
                dto.getTotal_price(),
                dto.getDate(),
                userList,
                incomingList,
                dto.getIs_delete()
        ));
    }

    @Override
    public ShoppingCart findById(Long id) {
        return optionalShoppingCart(id);
    }

    @Override
    public ShoppingCart edit(Long id, ShoppingCartDto dto) {

        List<Incoming> incomingList = toIncoming(dto.getIncomingList());
        List<User> userList = toUser(dto.getUserList());
        ShoppingCart shoppingCart = optionalShoppingCart(id);

        if (!shoppingCart.getIs_delete().equals(dto.getIs_delete()))
            shoppingCart.setIs_delete(dto.getIs_delete());

        if (!shoppingCart.getIncomingList().equals(incomingList))
            shoppingCart.setIncomingList(incomingList);

        if (!shoppingCart.getUser_id().equals(userList))
            shoppingCart.setUser_id(userList);

        if (!shoppingCart.getDate().equals(dto.getDate()))
            shoppingCart.setDate(dto.getDate());

        if (!shoppingCart.getTotal_price().equals(dto.getTotal_price()))
            shoppingCart.setTotal_price(dto.getTotal_price());

        return shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public String delete(Long id) {
        ShoppingCart shoppingCart = optionalShoppingCart(id);
        shoppingCartRepository.delete(shoppingCart);
        return "Successfuly delete !!!";
    }

    @Override
    public List<ShoppingCart> findByList(List<Long> list) {
        List<ShoppingCart> shoppingCarts = new ArrayList<>();
        for (Long a : list){
            if (a != null)
            shoppingCarts.add(optionalShoppingCart(a));
        }
        return shoppingCarts;
    }
}
