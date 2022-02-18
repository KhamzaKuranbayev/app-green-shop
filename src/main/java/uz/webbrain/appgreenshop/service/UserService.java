package uz.webbrain.appgreenshop.service;

import org.springframework.data.domain.Sort;
import uz.webbrain.appgreenshop.dto.UserCreateDto;
import uz.webbrain.appgreenshop.entity.User;
import uz.webbrain.appgreenshop.rest.responses.Response;

import java.util.List;

public interface UserService {

    User findUserById(Long userId);

    User updateUser(Long userId, UserCreateDto dto);

    User saveUser(UserCreateDto dto);

    String removeUser(Long userId);

    Response findAllPages(Integer page, Integer size, Sort sort);
}
