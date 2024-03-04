package it.itsvil.corsoformazionedb.controller;

import it.itsvil.corsoformazionedb.model.StudenteBean;
import it.itsvil.corsoformazionedb.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudenteCRUD {
    public static StudenteBean selectStudente(int id) throws SQLException {
        StudenteBean studente = new StudenteBean();
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        SelectMYSQL select = new SelectMYSQL(conn);
        String query = "SELECT * FROM studente WHERE id=" + id;
        ResultSet rs = select.select(query);
        while(rs.next()) {
            studente.setId(rs.getInt(1));
            studente.setNome(rs.getString(2));
            studente.setCognome(rs.getString(3));
        }
        return studente;
    }

    public static List<StudenteBean> selectStudenteAll() throws SQLException{
        List<StudenteBean> studenti = new ArrayList<StudenteBean>();
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        SelectMYSQL select = new SelectMYSQL(conn);
        String query = "SELECT * FROM studente";
        ResultSet rs = select.select(query);
        while(rs.next()) {
            StudenteBean studente = new StudenteBean();
            studente.setId(rs.getInt(1));
            studente.setNome(rs.getString(2));
            studente.setCognome(rs.getString(3));
            studenti.add(studente);
        }
        conn.close();
        return studenti;
    }

    public static void deleteStudente(int id) throws SQLException{
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        DeleteMYSQL delete = new DeleteMYSQL(conn);
        String query = "DELETE FROM studente WHERE id=" + id;
        delete.delete(query);
        conn.close();
    }

    public static void insertStudente(String nome, String cognome) throws SQLException{
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        InsertMYSQL insert= new InsertMYSQL(conn);
        String query = "INSERT INTO studente(nome,cognome) VALUES('" + nome + "','" + cognome + "')";
        insert.insert(query);
        conn.close();
    }

    public static void updateTutor(int id, String nome, String cognome) throws SQLException {
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        UpdateMYSQL update=new UpdateMYSQL(conn);
        String query = "UPDATE studente set nome='" + nome + "', cognome='" + cognome + "' WHERE id=" + id;
        update.update(query);
        conn.close();
    }

}
