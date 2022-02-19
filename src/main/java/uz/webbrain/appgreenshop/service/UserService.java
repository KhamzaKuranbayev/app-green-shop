package uz.webbrain.appgreenshop.service;

import org.springframework.data.domain.Pageable;
import uz.webbrain.appgreenshop.dto.UserCreateDto;
import uz.webbrain.appgreenshop.entity.User;
import uz.webbrain.appgreenshop.rest.responses.Response;


public interface UserService {

    User findUserById(Long userId);

    User updateUser(Long userId, UserCreateDto dto);

    User saveUser(UserCreateDto dto);

    String removeUser(Long userId);

    Response findAllPages(Pageable pageable);
}
