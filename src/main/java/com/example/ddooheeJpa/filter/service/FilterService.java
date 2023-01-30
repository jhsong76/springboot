package com.example.ddooheeJpa.filter.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.ddooheeJpa.common.exception.LInkyBussinessException;
import com.example.ddooheeJpa.filter.converter.UserFilterConverter;
import com.example.ddooheeJpa.filter.dto.UserFilterDto;
import com.example.ddooheeJpa.filter.dto.UserFilterRequestDto;
import com.example.ddooheeJpa.filter.entity.UserGenderForFilter;
import com.example.ddooheeJpa.filter.entity.UserGradeForFilter;
import com.example.ddooheeJpa.filter.entity.UserMajorForFilter;
import com.example.ddooheeJpa.filter.entity.UserMbtiForFilter;
import com.example.ddooheeJpa.filter.repository.UserGenderForFilterRepository;
import com.example.ddooheeJpa.filter.repository.UserGradeForFilterRepository;
import com.example.ddooheeJpa.filter.repository.UserMajorForFilterRepository;
import com.example.ddooheeJpa.filter.repository.UserMbtiForFilterRepository;
import com.example.ddooheeJpa.user.dto.UserListDto;
import com.example.ddooheeJpa.user.entity.User;
import com.example.ddooheeJpa.user.mapper.UserMapper;
import com.example.ddooheeJpa.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class FilterService {

    private final UserGenderForFilterRepository userGenderForFilterRepository;
    private final UserFilterConverter filterConverter;
    private final UserRepository userRepository;

    private final UserGradeForFilterRepository gradeForFilterRepository;
    private final UserMajorForFilterRepository majorForFilterRepository;
    private final UserMbtiForFilterRepository mbtiForFilterRepository;

    @Autowired
    private ObjectMapper mapper;

    // 기존에 지정한 필터 값 조회
    // 수정 필요
    public UserFilterDto selectFilter(long userId) {
        User userFilter = userRepository.findById(userId)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다.", HttpStatus.BAD_REQUEST));

        UserFilterDto dto = UserMapper.INSTANCE.entityToFilterDto(userFilter);
        return dto;

    }

    // 필터 저장 후 필터 적용된 재학생 리스트 반환
    @Transactional
    public List<UserListDto> TrueList(long userId, UserFilterRequestDto dto) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new LInkyBussinessException("해당 유저가 존재하지 않습니다. ", HttpStatus.BAD_REQUEST));

        // 기존에 설정한 필터가 있다면 삭제 후 새로운 필터 적용
        if (!userGenderForFilterRepository.findAllByUser(userId).isEmpty()) {
            userGenderForFilterRepository.deleteAllByUserId(userId);
        }
        List<UserGenderForFilter> genderList = dto.getGender();
        for (UserGenderForFilter n : genderList)
            userGenderForFilterRepository.save(filterConverter.filterSave(user, n));

        if (!mbtiForFilterRepository.findAllByUser(userId).isEmpty()) {
            mbtiForFilterRepository.deleteAllByUserId(userId);
        }
        List<UserMbtiForFilter> mbtiBlockedList = dto.getBlockedMbti();
        for (UserMbtiForFilter i : mbtiBlockedList)
            mbtiForFilterRepository.save(filterConverter.mbtiFiltersave(user, i));

        if (!majorForFilterRepository.findAllByUser(userId).isEmpty()) {
            majorForFilterRepository.deleteAllByUserId(userId);
        }
        List<UserMajorForFilter> majorBlockedList = dto.getBlockedMajor();
        for (UserMajorForFilter j : majorBlockedList)
            majorForFilterRepository.save(filterConverter.majorFiltersave(user, j));

        if (!gradeForFilterRepository.findAllByUser(userId).isEmpty()) {
            gradeForFilterRepository.deleteAllByUserId(userId);
        }
        List<UserGradeForFilter> gradeBlockedList = dto.getGrade();
        for (UserGradeForFilter k : gradeBlockedList)
            gradeForFilterRepository.save(filterConverter.gradeFiltersave(user, k));

        List<User> userList = userRepository.findTrueStudentByFilter(userId);
        List<UserListDto> listdto = UserMapper.INSTANCE.entityToDtoList(userList);

        return listdto;

    }


    // 필터 저장 후 필터 적용된 졸업생 리스트 반환
    public List<UserListDto> FalseList(long userId) {

        List<User> userList = userRepository.findFalseStudentByFilter(userId);
        List<UserListDto> listdto = UserMapper.INSTANCE.entityToDtoList(userList);

        return listdto;
    }
}
