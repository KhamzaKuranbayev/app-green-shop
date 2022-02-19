package uz.webbrain.appgreenshop.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uz.webbrain.appgreenshop.dto.DeliveryAddressDto;
import uz.webbrain.appgreenshop.entity.DeliveryAddress;
import uz.webbrain.appgreenshop.entity.User;
import uz.webbrain.appgreenshop.exception.NotFoundException;
import uz.webbrain.appgreenshop.repository.DeliveryAddressRepository;
import uz.webbrain.appgreenshop.repository.UserRepository;
import uz.webbrain.appgreenshop.service.DeliveryAddressService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeliveryAddressServiceImpl implements DeliveryAddressService {

    private final DeliveryAddressRepository deliveryAddressRepository;
    private final UserRepository userRepository;


    @Override
    public DeliveryAddress add(DeliveryAddressDto dto) {

        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        if (!optionalUser.isPresent())
            throw new NotFoundException("This User Id " + dto.getUserId() + " Not Found");
        User user = optionalUser.get();

        DeliveryAddress deliveryAddress = new DeliveryAddress(
                user,
                dto.getFirstname(),
                dto.getLastname(),
                dto.getStreet_address(),
                dto.getZip(),
                dto.getPhone(),
                dto.getRegionId(),
                dto.getStreetId()
        );

        return deliveryAddressRepository.save(deliveryAddress);
    }

    @Override
    public DeliveryAddress findById(Long id) {
        Optional<DeliveryAddress> deliveryAddress = deliveryAddressRepository.findById(id);
        return deliveryAddress.orElse(null);
    }

    @Override
    public List<DeliveryAddress> getAll() {
        return deliveryAddressRepository.findAll();
    }

    @Override
    public String deleteById(Long id) {
        DeliveryAddress deliveryAddress = findById(id);
        if (deliveryAddress == null)
            throw new NotFoundException("Category Not Found with id: {" + id + "}");
        deliveryAddressRepository.delete(deliveryAddress);
        return "Delivery Address was successfully deleted";
    }

    @Override
    public DeliveryAddress updateById(Long id, DeliveryAddressDto dto) {
        DeliveryAddress deliveryAddress = findById(id);
        if (deliveryAddress == null)
            throw new NotFoundException("Category Not Found with id: {" + id + "}");
        Optional<User> optionalUser = userRepository.findById(dto.getUserId());
        optionalUser.ifPresent(deliveryAddress::setUser);
        deliveryAddress.setFirstname(dto.getFirstname());
        deliveryAddress.setLastname(dto.getLastname());
        deliveryAddress.setStreet_address(dto.getStreet_address());
        deliveryAddress.setZip(dto.getZip());
        deliveryAddress.setPhone(dto.getPhone());
        deliveryAddress.setRegion_id(dto.getRegionId());
        deliveryAddress.setStreet_id(dto.getStreetId());

        return deliveryAddressRepository.save(deliveryAddress);
    }


}
