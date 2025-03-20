package org.example.Model.DAOInterfaces;

import org.example.Model.ModelClasses.Attore;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public interface AttoreInterface {
    public Attore selectActorById(int actorId) throws SQLException;

    public boolean deleteActorById(int actorId) throws SQLException;

    public boolean insertActor(Attore a) throws SQLException;

    public boolean updateActor(short idToModify, HashMap<String, String> whatToModify) throws SQLException;

    public List<Attore> getActorsByName(String firstName) throws SQLException;
}

