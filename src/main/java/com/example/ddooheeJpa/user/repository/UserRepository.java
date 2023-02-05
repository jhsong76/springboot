package com.example.ddooheeJpa.user.repository;

import com.example.ddooheeJpa.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT u FROM User u JOIN UserMatch m ON m.userMatching.userId = u.userId " +
            "WHERE m.userGetMatched.userId = :userGetMatched AND m.status = 'ACTIVE' AND m.userMatchStatus = 'INACTIVE'")
    List<User> findAllByUserGetMatched(@Param("userGetMatched") Long userGetMatched);

    @Query(value = "SELECT u FROM User u JOIN UserMatch m ON m.userGetMatched.userId = u.userId " +
            "WHERE m.userMatching.userId = :userMatching AND m.status = 'ACTIVE' AND m.userMatchStatus = 'INACTIVE'")
    List<User> findAllByUserMatching(@Param("userMatching") long userMatching);

    @Query(value = "SELECT u FROM User u JOIN UserBlock b ON b.userGetBlocked.userId = u.userId " +
            "WHERE b.userGiveBlock.userId = :userGiveBlock AND b.blockStatus = 'ACTIVE'")
    List<User> findAllByUserGiveBlock(@Param("userGiveBlock") long userGiveBlock);

    @Query(value = "SELECT * FROM user u WHERE user_major_name NOT IN (SELECT umff.blocked_major FROM user_major_for_filter umff WHERE umff.user_id = ?)\n" +
            "                       AND user_student_num IN (SELECT ugff.grade FROM user_grade_for_filter ugff )\n" +
            "                       AND user_mbti NOT IN(SELECT umff2.blocked_mbti FROM user_mbti_for_filter umff2)\n" +
            "                       AND user_gender IN (SELECT uf.gender FROM user_gender_for_filter uf)\n" +
            "                       AND u.grad_status = '재학생'", nativeQuery = true)
    List<User> findTrueStudentByFilter(@Param("userId") long userId);

    @Query(value = "SELECT * FROM user u WHERE user_major_name NOT IN (SELECT umff.blocked_major FROM user_major_for_filter umff WHERE umff.user_id = ?)\n" +
            "                       AND user_student_num IN (SELECT ugff.grade FROM user_grade_for_filter ugff )\n" +
            "                       AND user_mbti NOT IN(SELECT umff2.blocked_mbti FROM user_mbti_for_filter umff2)\n" +
            "                       AND user_gender IN (SELECT uf.gender FROM user_gender_for_filter uf)\n" +
            "                       AND u.grad_status = '졸업생'", nativeQuery = true)
    List<User> findFalseStudentByFilter(@Param("userId") long userId);

    @Query(value = "select u from User u where u.userId = :userId")
    User findByuserId(@Param("userId")long userId);

    @Query(value = "SELECT u FROM User u JOIN UserMatch m ON m.userMatching.userId = u.userId " +
            "WHERE m.userGetMatched.userId = :userId AND m.status = 'ACTIVE' AND m.userMatchStatus = 'INACTIVE'")
    List<User> findTop4ByUserGetMatched(@Param("userId") Long userId);

    @Query(value = "SELECT u FROM User u JOIN UserMatch m ON m.userGetMatched.userId = u.userId " +
            "WHERE m.userMatching.userId = :userId AND m.status = 'ACTIVE' AND m.userMatchStatus = 'INACTIVE'")
    List<User> findTop4ByUserMatching(@Param("userId") long userId);

    List<User> findByuserNickNameContaining(String nickName);

}
