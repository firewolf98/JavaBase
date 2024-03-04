package it.itsvil.corsoformazionedb.controller;

import it.itsvil.corsoformazionedb.model.TutorBean;
import it.itsvil.corsoformazionedb.sql.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TutorCRUD {

    public static TutorBean selectTutor(int id) throws SQLException {
        TutorBean tutor = new TutorBean();
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        SelectMYSQL select = new SelectMYSQL(conn);
        String query = "SELECT * FROM tutor WHERE id=" + id;
        ResultSet rs = select.select(query);
        while(rs.next()) {
            tutor.setId(rs.getInt(1));
            tutor.setNome(rs.getString(2));
            tutor.setCognome(rs.getString(3));
            tutor.setEmail(rs.getString(4));
            tutor.setTelefono(rs.getString(5));
        }
        return tutor;
    }

    public static List<TutorBean> selectTutorAll() throws SQLException{
        TutorBean tutor = new TutorBean();
        List<TutorBean> tutors = new ArrayList<TutorBean>();
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        SelectMYSQL select = new SelectMYSQL(conn);
        String query = "SELECT * FROM tutor";
        ResultSet rs = select.select(query);
        while(rs.next()) {
            tutor.setId(rs.getInt(1));
            tutor.setNome(rs.getString(2));
            tutor.setCognome(rs.getString(3));
            tutor.setEmail(rs.getString(4));
            tutor.setTelefono(rs.getString(5));
            tutors.add(tutor);
        }
        conn.close();
        return tutors;
    }

    public static void deleteTutor(int id) throws SQLException{
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        DeleteMYSQL delete = new DeleteMYSQL(conn);
        String query = "DELETE FROM tutor WHERE id=" + id;
        delete.delete(query);
        conn.close();
    }

    public static void insertTutor(String nome, String cognome, String email, String telefono) throws SQLException{
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        InsertMYSQL insert= new InsertMYSQL(conn);
        String query = "INSERT INTO tutor(nome,cognome,email,telefono) VALUES('" + nome + "','" + cognome + "','" + email + "','" + telefono + "')";
        insert.insert(query);
        conn.close();
    }

    public static void updateTutor(int id, String nome, String cognome, String email, String telefono) throws SQLException {
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        UpdateMYSQL update=new UpdateMYSQL(conn);
        String query = "UPDATE tutor set nome='" + nome + "', cognome='" + cognome + "', email='" + email + "', telefono='" + telefono + "' WHERE id=" + id;
        update.update(query);
        conn.close();
    }
}
