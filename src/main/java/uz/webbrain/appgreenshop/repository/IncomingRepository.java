package uz.webbrain.appgreenshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.webbrain.appgreenshop.entity.Incoming;
@Repository
import uz.webbrain.appgreenshop.entity.Incoming;

public interface IncomingRepository extends JpaRepository<Incoming, Long> {
}
