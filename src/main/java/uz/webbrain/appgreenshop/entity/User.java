package uz.webbrain.appgreenshop.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.webbrain.appgreenshop.entity.template.AbcEntity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "users")
public class User extends AbcEntity {

    @Column(nullable = false)
    private String firstname;

    @Column
    private String lastname;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.LAZY)
    private Set<Role> roles = new HashSet<>();

    public User(Set<Role> roles) {
        this.roles = roles;
    }

    /**
     * Hozir shopping_cartda malumotlar bormi
     * yo`'q buni CRUD ini siz qilishingiz kerak to'g'rimi?
     * ha uni 1marta yozdim unchalik qiyin mas yana yozvolaman en muhimi shungacha yetib keldik
     */
}
