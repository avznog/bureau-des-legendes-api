package com.bureaudeslegendes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaudeslegendes.api.model.Team;
import com.bureaudeslegendes.api.repository.TeamRepository;

@RequestMapping("/teams")
@RestController
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping
    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id) {
        return teamRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public Team createTeam(@RequestBody Team team) {
        return teamRepository.save(team);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody Team team) {
        Team updateTeam = teamRepository.findById(id).orElseThrow(RuntimeException::new);
        updateTeam.setName(team.getName());
        updateTeam.setManager(team.getManager());
        updateTeam.setRh(team.getRh());
        updateTeam.setMembers(team.getMembers());

        return teamRepository.save(updateTeam);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamRepository.deleteById(id);
    }
}