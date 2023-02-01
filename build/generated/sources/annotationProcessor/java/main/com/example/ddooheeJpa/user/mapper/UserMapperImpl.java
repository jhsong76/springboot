package com.example.ddooheeJpa.user.mapper;

import com.example.ddooheeJpa.filter.dto.UserFilterDto;
import com.example.ddooheeJpa.filter.dto.UserFilterDto.UserFilterDtoBuilder;
import com.example.ddooheeJpa.filter.entity.UserGenderForFilter;
import com.example.ddooheeJpa.filter.entity.UserGradeForFilter;
import com.example.ddooheeJpa.filter.entity.UserMajorForFilter;
import com.example.ddooheeJpa.filter.entity.UserMbtiForFilter;
import com.example.ddooheeJpa.user.dto.UserDetailDto;
import com.example.ddooheeJpa.user.dto.UserDetailDto.UserDetailDtoBuilder;
import com.example.ddooheeJpa.user.dto.UserDto;
import com.example.ddooheeJpa.user.dto.UserDto.UserDtoBuilder;
import com.example.ddooheeJpa.user.dto.UserListDto;
import com.example.ddooheeJpa.user.dto.UserListDto.UserListDtoBuilder;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.entity.UserInterest;
import com.example.ddooheeJpa.user.entity.UserPersonality;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-02-01T20:23:03+0900",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User dtoToEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User user = new User();

        if ( user.getUserInterests() != null ) {
            List<UserInterest> list = dto.getUserInterests();
            if ( list != null ) {
                user.getUserInterests().addAll( list );
            }
        }
        if ( user.getUserPersonalities() != null ) {
            List<UserPersonality> list1 = dto.getUserPersonalities();
            if ( list1 != null ) {
                user.getUserPersonalities().addAll( list1 );
            }
        }

        return user;
    }

    @Override
    public UserDto entityToDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDtoBuilder userDto = UserDto.builder();

        userDto.userId( entity.getUserId() );
        userDto.userNickName( entity.getUserNickName() );
        userDto.userMajorName( entity.getUserMajorName() );
        userDto.userStudentNum( entity.getUserStudentNum() );
        userDto.userBirth( entity.getUserBirth() );
        if ( entity.getUserGender() != null ) {
            userDto.userGender( Integer.parseInt( entity.getUserGender() ) );
        }
        userDto.userInfo( entity.getUserInfo() );
        userDto.userProfileImg( entity.getUserProfileImg() );
        userDto.userMbti( entity.getUserMbti() );
        List<UserInterest> list = entity.getUserInterests();
        if ( list != null ) {
            userDto.userInterests( new ArrayList<UserInterest>( list ) );
        }
        List<UserPersonality> list1 = entity.getUserPersonalities();
        if ( list1 != null ) {
            userDto.userPersonalities( new ArrayList<UserPersonality>( list1 ) );
        }

        return userDto.build();
    }

    @Override
    public List<UserListDto> entityToDtoList(List<User> entity) {
        if ( entity == null ) {
            return null;
        }

        List<UserListDto> list = new ArrayList<UserListDto>( entity.size() );
        for ( User user : entity ) {
            list.add( userToUserListDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> dtoToEntityList(List<UserListDto> dto) {
        if ( dto == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( dto.size() );
        for ( UserListDto userListDto : dto ) {
            list.add( userListDtoToUser( userListDto ) );
        }

        return list;
    }

    @Override
    public UserDetailDto UserdetaildtoToEntity(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDetailDtoBuilder userDetailDto = UserDetailDto.builder();

        userDetailDto.userId( entity.getUserId() );
        userDetailDto.userNickName( entity.getUserNickName() );
        userDetailDto.userMajorName( entity.getUserMajorName() );
        userDetailDto.userStudentNum( entity.getUserStudentNum() );
        userDetailDto.userBirth( entity.getUserBirth() );
        if ( entity.getUserGender() != null ) {
            userDetailDto.userGender( Integer.parseInt( entity.getUserGender() ) );
        }
        userDetailDto.userInfo( entity.getUserInfo() );
        userDetailDto.userProfileImg( entity.getUserProfileImg() );
        userDetailDto.userMbti( entity.getUserMbti() );
        List<UserInterest> list = entity.getUserInterests();
        if ( list != null ) {
            userDetailDto.userInterests( new ArrayList<UserInterest>( list ) );
        }
        List<UserPersonality> list1 = entity.getUserPersonalities();
        if ( list1 != null ) {
            userDetailDto.userPersonalities( new ArrayList<UserPersonality>( list1 ) );
        }
        userDetailDto.userLikeCount( entity.getUserLikeCount() );

        return userDetailDto.build();
    }

    @Override
    public List<User> toInterestListDto(List<UserInterest> userInterests) {
        if ( userInterests == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userInterests.size() );
        for ( UserInterest userInterest : userInterests ) {
            list.add( userInterestToUser( userInterest ) );
        }

        return list;
    }

    @Override
    public List<User> toPersonalityListDto(List<UserPersonality> userPersonalities) {
        if ( userPersonalities == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( userPersonalities.size() );
        for ( UserPersonality userPersonality : userPersonalities ) {
            list.add( userPersonalityToUser( userPersonality ) );
        }

        return list;
    }

    @Override
    public UserFilterDto entityToFilterDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserFilterDtoBuilder userFilterDto = UserFilterDto.builder();

        List<UserGenderForFilter> list = entity.getUserGenderForFilters();
        if ( list != null ) {
            userFilterDto.userGenderForFilters( new ArrayList<UserGenderForFilter>( list ) );
        }
        List<UserGradeForFilter> list1 = entity.getUserGradeForFilters();
        if ( list1 != null ) {
            userFilterDto.userGradeForFilters( new ArrayList<UserGradeForFilter>( list1 ) );
        }
        List<UserMajorForFilter> list2 = entity.getUserMajorForFilters();
        if ( list2 != null ) {
            userFilterDto.userMajorForFilters( new ArrayList<UserMajorForFilter>( list2 ) );
        }
        List<UserMbtiForFilter> list3 = entity.getUserMbtiForFilters();
        if ( list3 != null ) {
            userFilterDto.userMbtiForFilters( new ArrayList<UserMbtiForFilter>( list3 ) );
        }

        return userFilterDto.build();
    }

    protected UserListDto userToUserListDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserListDtoBuilder userListDto = UserListDto.builder();

        userListDto.userNickName( user.getUserNickName() );
        userListDto.userMajorName( user.getUserMajorName() );
        userListDto.userStudentNum( user.getUserStudentNum() );
        userListDto.userProfileImg( user.getUserProfileImg() );
        userListDto.userLikeCount( user.getUserLikeCount() );
        List<UserInterest> list = user.getUserInterests();
        if ( list != null ) {
            userListDto.userInterests( new ArrayList<UserInterest>( list ) );
        }

        return userListDto.build();
    }

    protected User userListDtoToUser(UserListDto userListDto) {
        if ( userListDto == null ) {
            return null;
        }

        User user = new User();

        if ( user.getUserInterests() != null ) {
            List<UserInterest> list = userListDto.getUserInterests();
            if ( list != null ) {
                user.getUserInterests().addAll( list );
            }
        }

        return user;
    }

    protected User userInterestToUser(UserInterest userInterest) {
        if ( userInterest == null ) {
            return null;
        }

        User user = new User();

        return user;
    }

    protected User userPersonalityToUser(UserPersonality userPersonality) {
        if ( userPersonality == null ) {
            return null;
        }

        User user = new User();

        return user;
    }
}
