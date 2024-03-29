package uz.webbrain.appgreenshop.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.webbrain.appgreenshop.entity.template.AbcEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbcEntity {

    @Column(nullable = false, unique = true)
    private String name;

}
