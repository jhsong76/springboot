package com.example.ddooheeJpa.domain.Match;

import com.example.ddooheeJpa.domain.Match.Model.Dto.get.getMatchListRes;
import com.example.ddooheeJpa.domain.Match.Model.Match;
import com.example.ddooheeJpa.domain.Match.Model.MatchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;

    /*@PostMapping("")
    public ResponseEntity<Match> postMatch(@RequestBody MatchDTO dto) {
        Match match = matchService.match(dto);

        return new ResponseEntity<>(match, HttpStatus.OK);
    }
/*
    @GetMapping("/{userGetMatched}")
    public ResponseEntity<List<Match>> MatchList(@PathVariable("userGetMatched")Long userGetMatched) {

        List<Match> matches = matchService.getMatchList(userGetMatched);
        return new ResponseEntity<List<Match>>(matches, HttpStatus.OK);
    }*/

    @GetMapping("/{user_id}")
    public ResponseEntity<List<Match>> getMatchList(@PathVariable("user_id")Long user_id) {
        List<Match> matchList = matchService.matchList(user_id);
        return new ResponseEntity<List<Match>>(matchList, HttpStatus.OK);
    }
}
