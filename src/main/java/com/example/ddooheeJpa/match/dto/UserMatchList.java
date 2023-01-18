package com.example.ddooheeJpa.match.dto;

import com.example.ddooheeJpa.user.entity.UserInterest;
import lombok.*;

import java.util.List;

public interface UserMatchList {


    List<UserInterest> getUserInterests();
    int getUserLikes();

}
