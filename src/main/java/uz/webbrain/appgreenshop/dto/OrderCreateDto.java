package uz.webbrain.appgreenshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.webbrain.appgreenshop.enums.OrderStatus;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateDto {

    private Double totalPrice;
    private LocalDateTime date;
    private Long userId;
    private OrderStatus status;
    private Long deliveryAddressId;

}
