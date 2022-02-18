package uz.webbrain.appgreenshop.entity;


import lombok.*;
import org.hibernate.Hibernate;
import uz.webbrain.appgreenshop.entity.template.AbcEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Role extends AbcEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Role role = (Role) o;
        return getId() != null && Objects.equals(getId(), role.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
