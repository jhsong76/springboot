package com.example.ddooheeJpa.domain.Match;

import com.example.ddooheeJpa.domain.Match.Model.Match;
import com.example.ddooheeJpa.domain.Match.Model.MatchDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequiredArgsConstructor
@RequestMapping("/match")
public class MatchController {
    private final MatchService matchService;

    @PostMapping("")
    public ResponseEntity<Match> postMatch(@RequestBody MatchDTO dto) {
        Match match = matchService.match(dto);

        return new ResponseEntity<>(match, HttpStatus.OK);
    }
}
