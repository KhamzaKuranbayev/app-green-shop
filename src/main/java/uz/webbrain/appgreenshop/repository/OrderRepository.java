package uz.webbrain.appgreenshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.webbrain.appgreenshop.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
