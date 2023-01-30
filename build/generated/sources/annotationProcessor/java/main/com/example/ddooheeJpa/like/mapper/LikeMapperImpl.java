package com.example.ddooheeJpa.like.mapper;

import com.example.ddooheeJpa.like.dto.LikeDto;
import com.example.ddooheeJpa.like.dto.LikeDto.LikeDtoBuilder;
import com.example.ddooheeJpa.like.entity.UserLikes;
import com.example.ddooheeJpa.like.entity.UserLikes.UserLikesBuilder;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-01-31T01:25:21+0900",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class LikeMapperImpl implements LikeMapper {

    @Override
    public UserLikes dtoToEntity(LikeDto dto) {
        if ( dto == null ) {
            return null;
        }

        UserLikesBuilder userLikes = UserLikes.builder();

        userLikes.id( dto.getId() );

        return userLikes.build();
    }

    @Override
    public LikeDto entityToDto(UserLikes entity) {
        if ( entity == null ) {
            return null;
        }

        LikeDtoBuilder likeDto = LikeDto.builder();

        if ( entity.getId() != null ) {
            likeDto.id( entity.getId() );
        }

        return likeDto.build();
    }
}
