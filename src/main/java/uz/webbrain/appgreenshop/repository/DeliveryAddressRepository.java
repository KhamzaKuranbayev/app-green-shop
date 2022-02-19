package uz.webbrain.appgreenshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.webbrain.appgreenshop.entity.DeliveryAddress;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Long> {
}
