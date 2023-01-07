package com.example.ddooheeJpa.domain.repository;

import com.example.ddooheeJpa.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    // jpa 엔티티 매니저 주입해줌 @PersistenceContext
    private final EntityManager em;

    /* 엔티티 매니저 팩토리를 직접 주입하고 싶다면,
    @PersistenceUnit
    private EntityManagerFactory em;
    */

    public void save(Member member) {
        em.persist(member);
    }

    // 단건 조회
    public Member findOne(Long id) {
        return em.find(Member.class, id); // 1. 타입 2. pk
    }

    public List<Member> findAll() {
        return em.createQuery("select m from Member m", Member.class)
                                // sql과 jql은 살짝 다르지만, 기능적으로는 동일
                                // sql 은 테이블 대상으로 쿼리, jql은 객체를 대상으로

                .getResultList();
    }

    public List<Member> findByName(String name) {
        return em.createQuery("select m from Member m where m.name = :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
