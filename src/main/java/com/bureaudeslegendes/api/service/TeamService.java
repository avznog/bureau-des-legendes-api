package com.bureaudeslegendes.api.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.bureaudeslegendes.api.dto.Team.TeamCreationDTO;
import com.bureaudeslegendes.api.model.Team;
import com.bureaudeslegendes.api.repository.TeamRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TeamService {
    final private ModelMapper mapper;

    // final private PersonService personService;

    final private TeamRepository teamRepository;

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Team getTeam(Long id) {
        return teamRepository.findById(id).orElseThrow();
    }

    public Team createTeam(TeamCreationDTO teamCreationDTO) {
        Team team = mapper.map(teamCreationDTO, Team.class);
        // team.setManager(personService.getPerson(teamCreationDTO.getManager()));
        // team.setRh(personService.getPerson(teamCreationDTO.getRh()));
        return teamRepository.save(team);
    }

    public Team updateTeam(Long id, TeamCreationDTO teamCreationDTO) {
        Team currentTeam = getTeam(id);
        mapper.map(teamCreationDTO, currentTeam);
        return teamRepository.save(currentTeam);
    }

    public void deleteTeam(Long id) {
        teamRepository.deleteById(id);
    }
}
