package org.example.Controller;

import org.example.Model.DAOImplementations.AttoreImpl;
import org.example.Model.ModelClasses.Attore;

import java.sql.SQLException;

public class AttoreServlet {

        public boolean insertActor(String name, String surname){
            AttoreImpl attoreDao = new AttoreImpl();
            try{
                return attoreDao.insertActor(new Attore(name, surname));
            } catch (SQLException e){
                e.printStackTrace();
            }
            return false;
        }


/*
    public boolean insertActorCattivo(String name, String surname){
        AttoreImpl attoreDao = new AttoreImpl();
        return attoreDao.addActor(new Attore(name, surname));
        return false;
    }*/

}
