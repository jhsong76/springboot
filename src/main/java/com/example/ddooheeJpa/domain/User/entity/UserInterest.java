package com.example.ddooheeJpa.domain.User.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "userInterest")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserInterest {
    @Id
    @Column(name ="userInterestId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Interest")
    private String Interest;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public UserInterest(final String interest, final User user) {
        this.Interest = interest;
        this.user = user;
    }
}
