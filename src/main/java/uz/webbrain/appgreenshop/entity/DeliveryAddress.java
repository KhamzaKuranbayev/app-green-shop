package uz.webbrain.appgreenshop.entity;

import lombok.*;
import uz.webbrain.appgreenshop.entity.template.AbcEntity;

import javax.persistence.*;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "delivery_address")
public class DeliveryAddress extends AbcEntity {

    @OneToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "street_address")
    private String street_address;

    @Column(name = "zip")
    private String zip;

    @Column(name = "phone_number")
    private String phone;

    private Long region_id;

    private Long street_id;




}
