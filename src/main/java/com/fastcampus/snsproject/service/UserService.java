package com.fastcampus.snsproject.service;

import com.fastcampus.snsproject.exception.ErrorCode;
import com.fastcampus.snsproject.exception.SnsApplicationException;
import com.fastcampus.snsproject.model.User;
import com.fastcampus.snsproject.model.entity.UserEntity;
import com.fastcampus.snsproject.repository.UserEntityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserEntityRepository userRepository;

    public User join(String userName, String password) {

        // 회원가입하려는 userName으로 회원가입된 user가 있는지 check
        userRepository.findByUserName(userName).ifPresent(it -> {
            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, String.format("% is duplicated", userName));
        });

        // 회원가입 진행 = user 등록
        UserEntity userEntity = userRepository.save(UserEntity.of(userName, password));

        return User.fromEntity(userEntity);
    }

    //TODO : implement
    public String login(String userName, String password) {
        // 회원가입 여부 check
        UserEntity userEntity = userRepository.findByUserName(userName).orElseThrow(() -> new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, ""));

        // 비밀번호 check
        if(!userEntity.getPassword().equals(password)) {
            throw new SnsApplicationException(ErrorCode.DUPLICATED_USER_NAME, "");
        }

        //토큰 생성
        return "";
    }
}
