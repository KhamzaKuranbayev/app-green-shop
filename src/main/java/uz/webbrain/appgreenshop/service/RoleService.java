package uz.webbrain.appgreenshop.service;

import org.springframework.data.domain.Sort;
import uz.webbrain.appgreenshop.dto.RoleCreateDto;
import uz.webbrain.appgreenshop.entity.Role;
import uz.webbrain.appgreenshop.rest.responses.Response;

import java.util.List;

public interface RoleService {
    Role saveRole(RoleCreateDto dto);

    Response findAllPageable(Integer page, Integer size, Sort sort);

    Role findById(Long roleId);

    Role updateRole(Long roleId, RoleCreateDto dto);

    String removeRoleById(Long roleId);

}
