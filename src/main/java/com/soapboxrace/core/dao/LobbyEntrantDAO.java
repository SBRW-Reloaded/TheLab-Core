/*
 * This file is part of the Soapbox Race World core source code.
 * If you use any of this code for third-party purposes, please provide attribution.
 * Copyright (c) 2020.
 */

package com.soapboxrace.core.dao;

import com.soapboxrace.core.dao.util.LongKeyedDAO;
import com.soapboxrace.core.jpa.LobbyEntity;
import com.soapboxrace.core.jpa.LobbyEntrantEntity;
import com.soapboxrace.core.jpa.PersonaEntity;

import javax.ejb.Stateless;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class LobbyEntrantDAO extends LongKeyedDAO<LobbyEntrantEntity> {

    public LobbyEntrantDAO() {
        super(LobbyEntrantEntity.class);
    }

    public void deleteByPersona(PersonaEntity personaEntity) {
        Query query = entityManager.createNamedQuery("LobbyEntrantEntity.deleteByPersona");
        query.setParameter("persona", personaEntity);
        query.executeUpdate();
    }

    public void deleteByPersonaAndLobby(PersonaEntity personaEntity, LobbyEntity lobbyEntity) {
        Query query = entityManager.createNamedQuery("LobbyEntrantEntity.deleteByPersonaAndLobby");
        query.setParameter("persona", personaEntity);
        query.setParameter("lobby", lobbyEntity);
        query.executeUpdate();
    }

    public void updateVoteByPersonaAndLobby(PersonaEntity personaEntity, LobbyEntity lobbyEntity) {
        Query query = entityManager.createNamedQuery("LobbyEntrantEntity.updateByPersonaAndLobby");
        query.setParameter("persona", personaEntity);
        query.setParameter("lobby", lobbyEntity);
        query.executeUpdate();
    }

    public List<LobbyEntrantEntity> getVotes(Long lobbyId) {
        TypedQuery<LobbyEntrantEntity> query = entityManager.createNamedQuery("LobbyEntrantEntity.getVotes", LobbyEntrantEntity.class);
        query.setParameter("lobbyId", lobbyId);

        List<LobbyEntrantEntity> resultList = query.getResultList();
        return !resultList.isEmpty() ? resultList : null;
    }
}
