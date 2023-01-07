package com.example.ddooheeJpa.service;

import com.example.ddooheeJpa.domain.Member;
import com.example.ddooheeJpa.domain.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
// 조회에서 어노테이션 추가하면 조회 api 에서 최적화 도입, 읽기에선 readOnly = True 필수
// 읽기가 아닌 것은 넣으면 안됨 (== 데이터 변경이 안되기 때문)
@RequiredArgsConstructor
// 생성자 하나만 있는 경우 자동으로 인젭션 해줌
public class MemberService {

    // 변경할 일이 없기 때문 final 권장
    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(Member member){

        validateDuplicatedMember(member); // 중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicatedMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다. ");
        }
    }

    // 회원 전체 조회
    @Transactional(readOnly = true)
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    // 단건 조회
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
