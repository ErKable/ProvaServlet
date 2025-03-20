package org.example.Model.DAOImplementations;

import org.example.ConnessioneDB.ConnessioneDB;
import org.example.Model.DAOInterfaces.AttoreInterface;
import org.example.Model.ModelClasses.Attore;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttoreImpl implements AttoreInterface {
    @Override
    public Attore selectActorById(int actorId) throws SQLException {
        Connection c = ConnessioneDB.getConnection();
        Statement stm = c.createStatement();
        String query = "SELECT * FROM actor WHERE actor_id = " +actorId;
        ResultSet response = stm.executeQuery(query);
        String firstName = "";
        String lastName = "";
        while(response.next()){
            firstName = response.getString("first_name");
            lastName = response.getString("last_name");
        }
        return new Attore(actorId, firstName, lastName);
    }
    @Override
    public boolean deleteActorById(int actorId) throws SQLException{
        Connection c = ConnessioneDB.getConnection();
        Statement stm = c.createStatement();
        String query = "DELETE FROM actor WHERE actor_id = "+actorId;
        if(stm.executeUpdate(query) > 0){
            return true;
        }
        return false;
    }
    @Override
    public boolean insertActor(Attore a) throws SQLException{
        boolean esito = false;
        try (Connection c = ConnessioneDB.getConnection()){
            if (c == null)
                throw new SQLException("Connection failed");
            Statement stm = c.createStatement();
            String query = "INSERT INTO actor(first_name, last_name) VALUES(\"" + a.getFirstName() + "\", " +
                    "\"" + a.getLastName() + ")\";";
            if (stm.executeUpdate(query) > 0) {
                esito = true;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return esito;
    }

    @Override
    public boolean updateActor(short idToModify, HashMap<String, String> whatToModify) throws SQLException{
        Attore a = selectActorById(idToModify);
        Connection c = ConnessioneDB.getConnection();


        ArrayList<String> columns = new ArrayList<>();
        ArrayList<String> values = new ArrayList<>();

        whatToModify.forEach((colonna, valore) -> {
            columns.add(colonna);
            values.add(valore);
        });

        String query = "UPDATE actor SET ";
        //devo ficcare la virgola tra i values
        for(int i = 0; i < columns.size(); i++){
            if(columns.get(i) == "first_name"){
                a.setFirstName(values.get(i));
                query = query + "first_name = \'"+a.getFirstName()+"\' ";
            } else {
                a.setLastName(values.get(i));
                query = query + "last_name = \'"+a.getLastName()+"\' ";
            }
            //devo capire quanti value mancano... come???
            //cosi
            if(i+1 < columns.size()){
                query = query + ", ";
            }
        }
        query = query + "WHERE actor_id = "+idToModify;
        //System.out.println("Nome dopo: "+ a.getFirstName());
        System.out.println(query);
        Statement stm = c.createStatement();
        if (stm.executeUpdate(query) > 0)
            return true;
        return false;
    }

    public List<Attore> getActorsByName(String firstName) throws SQLException{
        List<Attore> la = new ArrayList<>();
        Connection c = ConnessioneDB.getConnection();
        Statement s = c.createStatement();
        String query = "SELECT * FROM actor WHERE first_name = \""+firstName+"\";";
        ResultSet response = s.executeQuery(query);
        while(response.next()){
            la.add(new Attore(response.getInt("actor_id"),
                            response.getString("first_name"),
                            response.getString("last_name")
                    )
            );
        }
        return la;
    }


}
