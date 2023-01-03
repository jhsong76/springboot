package com.example.ddooheeJpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;


    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findOne(id);
        // memberRepository에서 찾아온거임.
        member.setName(name);
    }
}
