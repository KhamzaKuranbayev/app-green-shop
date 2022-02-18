package uz.webbrain.appgreenshop.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.webbrain.appgreenshop.entity.template.AbcEntity;
import uz.webbrain.appgreenshop.enums.OrderStatus;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order extends AbcEntity {

    @Column(nullable = false)
    private Double totalPrice;

    @Column(nullable = false)
    private LocalDateTime date;

    @ManyToOne
    private Long userId;

    @Column(nullable = false)
    private OrderStatus status;

    @ManyToOne
    private Long deliveryAddressId;

}
