package org.example.Controller;

import org.example.Model.DAOImplementations.AttoreImpl;
import org.example.Model.ModelClasses.Attore;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Optional;

public class AttoreServlet {
            /*
        public boolean insertActorCattivo(String name, String surname){
            AttoreImpl attoreDao = new AttoreImpl();
            return attoreDao.addActor(new Attore(name, surname));
            return false;
        }*/

        public boolean insertActor(String name, String surname){
            AttoreImpl attoreDao = new AttoreImpl();
            try{
                return attoreDao.insertActor(new Attore(name.toUpperCase(), surname.toUpperCase()));
            } catch (SQLException e){
                e.printStackTrace();
            }
            return false;
        }

        public Optional<Attore> selectActorById(int actorId){
            AttoreImpl attoreDao = new AttoreImpl();
            Attore a = new Attore();
            try{
                a = attoreDao.selectActorById(actorId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return Optional.of(a);
        }

        public boolean deleteActorById(int actorId){
            AttoreImpl attoreDao = new AttoreImpl();
            boolean esito = false;
            try{
                esito = attoreDao.deleteActorById(actorId);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return esito;
        }

        public boolean updateActorById(int actorId, HashMap<String, String> whatToModify){
            AttoreImpl attoreDao = new AttoreImpl();
            boolean esito = false;
            try{
                esito = attoreDao.updateActor(actorId, whatToModify);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return esito;
        }
}
