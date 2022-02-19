package uz.webbrain.appgreenshop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;
import uz.webbrain.appgreenshop.dto.UserCreateDto;
import uz.webbrain.appgreenshop.entity.User;
import uz.webbrain.appgreenshop.rest.responses.Response;
import uz.webbrain.appgreenshop.service.UserService;
import uz.webbrain.appgreenshop.utils.ApiPageable;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public User save(@RequestBody UserCreateDto dto) {
        return userService.saveUser(dto);
    }


    @ApiPageable
    @GetMapping("/page/list")
    public HttpEntity<?> findAllPageable(@ApiIgnore Pageable pageable) {
        Response response = userService.findAllPages(pageable);
        return ResponseEntity.status(response.isSuccess() ? 200 : 500).body(response);

    }


    @GetMapping("/{user_id}")
    public User findById(@PathVariable("user_id") Long userId) {
        return userService.findUserById(userId);
    }

    @PutMapping("/{user_id}")
    public User edit(@PathVariable("user_id") Long userId,
                        @RequestBody UserCreateDto dto) {
        return userService.updateUser(userId, dto);
    }

    @DeleteMapping("/{user_id}")
    public String remove(@PathVariable("user_id") Long userId) {
        return userService.removeUser(userId);
    }


}
