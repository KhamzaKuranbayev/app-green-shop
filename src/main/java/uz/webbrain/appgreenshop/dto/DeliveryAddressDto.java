package uz.webbrain.appgreenshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeliveryAddressDto {

    private Long userId;

    private String firstname;

    private String lastname;

    private String street_address;

    private String zip;

    private String phone;

    private Long regionId;

    private Long streetId;
}
