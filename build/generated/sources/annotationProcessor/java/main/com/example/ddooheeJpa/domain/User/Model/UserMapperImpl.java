package com.example.ddooheeJpa.domain.User.Model;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-13T02:29:16+0900",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDTO dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        user.setUserPhoneNum( dto.getUserPhoneNum() );
        user.setUserNickName( dto.getUserNickName() );
        user.setUserBirth( dto.getUserBirth() );
        user.setSchoolName( dto.getSchoolName() );
        user.setUserMajorName( dto.getUserMajorName() );
        user.setUserStudentNum( dto.getUserStudentNum() );
        user.setUserGender( dto.getUserGender() );
        user.setUserMbti( dto.getUserMbti() );
        user.setUserPersonality( dto.getUserPersonality() );
        user.setUserInterest( dto.getUserInterest() );
        user.setUserInfo( dto.getUserInfo() );
        user.setUserProfileImg( dto.getUserProfileImg() );

        return user;
    }

    @Override
    public UserDTO toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.setUserPhoneNum( entity.getUserPhoneNum() );
        userDTO.setUserNickName( entity.getUserNickName() );
        userDTO.setUserBirth( entity.getUserBirth() );
        userDTO.setSchoolName( entity.getSchoolName() );
        userDTO.setUserMajorName( entity.getUserMajorName() );
        userDTO.setUserStudentNum( entity.getUserStudentNum() );
        userDTO.setUserGender( entity.getUserGender() );
        userDTO.setUserMbti( entity.getUserMbti() );
        userDTO.setUserPersonality( entity.getUserPersonality() );
        userDTO.setUserInterest( entity.getUserInterest() );
        userDTO.setUserInfo( entity.getUserInfo() );
        userDTO.setUserProfileImg( entity.getUserProfileImg() );

        return userDTO;
    }
}
