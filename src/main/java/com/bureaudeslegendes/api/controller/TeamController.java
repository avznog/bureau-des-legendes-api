package com.bureaudeslegendes.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bureaudeslegendes.api.dto.Team.TeamCreationDTO;
import com.bureaudeslegendes.api.model.Team;
import com.bureaudeslegendes.api.service.TeamService;

@CrossOrigin(origins = {"http://localhost:3000", "https://bureau-des-legendes.juniorisep.com"})
@RequestMapping("/teams")
@RestController
public class TeamController {
    @Autowired
    private TeamService teamService;

    @GetMapping
    public List<Team> getTeams() {
        return teamService.getTeams();
    }

    @GetMapping("/{id}")
    public Team getTeam(@PathVariable Long id) {
        return teamService.getTeam(id);
    }

    @PostMapping
    public Team createTeam(@RequestBody TeamCreationDTO teamCreationDTO) {
        return teamService.createTeam(teamCreationDTO);
    }

    @PutMapping("/{id}")
    public Team updateTeam(@PathVariable Long id, @RequestBody TeamCreationDTO teamCreationDTO) {
        return teamService.updateTeam(id, teamCreationDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTeam(@PathVariable Long id) {
        teamService.deleteTeam(id);
    }

    @GetMapping("/by-member-id/{membersId}")
    public Team findByMembersId(@PathVariable Long membersId) {
        return teamService.findByMembersId(membersId);
    }
}