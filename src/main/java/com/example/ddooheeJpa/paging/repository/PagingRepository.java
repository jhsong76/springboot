package com.example.ddooheeJpa.paging.repository;

import com.example.ddooheeJpa.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor

public class PagingRepository {
    private final EntityManager em;

    public List<User> findAllByGradStatusTrue(int offset, int limit){
        return em.createQuery(
                "select u from User u where u.gradStatus = true", User.class)
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();
    }
}
