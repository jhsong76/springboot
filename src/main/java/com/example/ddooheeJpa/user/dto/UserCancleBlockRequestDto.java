package com.example.ddooheeJpa.user.dto;

import com.example.ddooheeJpa.block.entity.UserBlock;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserCancleBlockRequestDto {

    private List<Long> blockId;
}
