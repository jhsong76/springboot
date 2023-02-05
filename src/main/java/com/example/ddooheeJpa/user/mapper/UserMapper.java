package com.example.ddooheeJpa.user.mapper;

import com.example.ddooheeJpa.filter.dto.UserFilterDto;
import com.example.ddooheeJpa.user.dto.UserDetailDto;
import com.example.ddooheeJpa.user.dto.UserDto;

import com.example.ddooheeJpa.user.dto.UserListDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.entity.UserInterest;
import com.example.ddooheeJpa.user.entity.UserPersonality;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    User dtoToEntity(UserDto dto);

    UserDto entityToDto(User entity);

    List<UserListDto> entityToDtoList(List<User> entity);

    UserDetailDto UserdetaildtoToEntity(User entity);

    UserFilterDto entityToFilterDto(User entity);

}
