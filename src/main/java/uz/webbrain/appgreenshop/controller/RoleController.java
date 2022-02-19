package uz.webbrain.appgreenshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import uz.webbrain.appgreenshop.dto.RoleCreateDto;
import uz.webbrain.appgreenshop.entity.Role;
import uz.webbrain.appgreenshop.rest.responses.Response;
import uz.webbrain.appgreenshop.service.RoleService;
import uz.webbrain.appgreenshop.utils.ApiPageable;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/roles")
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    public Role save(@RequestBody RoleCreateDto dto) {
        return roleService.saveRole(dto);
    }


    @ApiPageable
    @GetMapping("/page/list")
    public HttpEntity<?> findAllPageable(@ApiIgnore Pageable pageable) {
        Response response = roleService.findAllPageable(pageable);
        return ResponseEntity.status(response.isSuccess() ? 200 : 500).body(response);
    }

    @GetMapping("/{role_id}")
    public Role findById(@PathVariable("role_id") Long roleId) {
        return roleService.findById(roleId);
    }

    @PutMapping("/{role_id}")
    public Role edit(@PathVariable("role_id") Long roleId,
                     @RequestBody RoleCreateDto dto) {
        return roleService.updateRole(roleId, dto);
    }

    @DeleteMapping("/{role_id}")
    public String remove(@PathVariable("role_id") Long roleId) {
        return roleService.removeRoleById(roleId);
    }

}
