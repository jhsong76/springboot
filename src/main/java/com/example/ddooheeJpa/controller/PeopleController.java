package com.example.ddooheeJpa.controller;

import com.example.ddooheeJpa.domain.MapStructTest.People;
import com.example.ddooheeJpa.domain.MapStructTest.PeopleDTO;
import com.example.ddooheeJpa.service.PeopleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@Controller
@RequiredArgsConstructor
public class PeopleController {
    private final PeopleService peopleService;

    @GetMapping("/people")
    public String getPeople(){
        return "hello";
    }

    @PostMapping("/people/save")
    public ResponseEntity<People> postPeople(@RequestBody PeopleDTO peopleDTO) {
        People people = peopleService.save(peopleDTO);

        return new ResponseEntity<>(people, HttpStatus.OK);
    }

    @GetMapping("/people/List")
    public ResponseEntity<List<People>> getPeoples() {
        List<People> peoples = peopleService.getPeoples();
        return new ResponseEntity<List<People>>(peoples, HttpStatus.OK);
    }
}
