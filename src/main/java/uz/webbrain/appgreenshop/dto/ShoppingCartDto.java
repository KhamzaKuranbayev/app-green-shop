package uz.webbrain.appgreenshop.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCartDto {

    private Long id;
    private List<Long> userList;
    private Double total_price;
    private LocalDate date;
    private Boolean is_delete;
    private List<Long> incomingList;
}
