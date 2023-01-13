package com.example.ddooheeJpa.domain.User.Model;

import com.example.ddooheeJpa.domain.MapStructTest.EntityMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDTO, User> {
}