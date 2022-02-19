package uz.webbrain.appgreenshop.service;

import org.springframework.data.domain.Pageable;
import uz.webbrain.appgreenshop.dto.RoleCreateDto;
import uz.webbrain.appgreenshop.entity.Role;
import uz.webbrain.appgreenshop.rest.responses.Response;


public interface RoleService {
    Role saveRole(RoleCreateDto dto);

    Response findAllPageable(Pageable pageable);

    Role findById(Long roleId);

    Role updateRole(Long roleId, RoleCreateDto dto);

    String removeRoleById(Long roleId);

}
