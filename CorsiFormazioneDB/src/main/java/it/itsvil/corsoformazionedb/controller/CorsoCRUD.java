package it.itsvil.corsoformazionedb.controller;

import it.itsvil.corsoformazionedb.model.CorsoBean;
import it.itsvil.corsoformazionedb.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CorsoCRUD {

    public static CorsoBean selectCorso(int id) throws SQLException{
        CorsoBean corso = new CorsoBean();
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        SelectMYSQL select = new SelectMYSQL(conn);
        String query = "SELECT * FROM corso WHERE id=" + id;
        ResultSet rs = select.select(query);
        while(rs.next()) {
            corso.setId(rs.getInt(1));
            corso.setNome(rs.getString(2));
            corso.setTutor(TutorCRUD.selectTutor(rs.getInt(3)));
            corso.setDurata(rs.getInt(4));
            corso.setStato(rs.getString(5));
        }
        return corso;
    }

    public static List<CorsoBean> selectCorsoAll() throws SQLException{
        List<CorsoBean> corsi = new ArrayList<CorsoBean>();
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        SelectMYSQL select = new SelectMYSQL(conn);
        String query = "SELECT * FROM corso";
        ResultSet rs = select.select(query);
        while(rs.next()) {
            CorsoBean corso = new CorsoBean();
            corso.setId(rs.getInt(1));
            corso.setNome(rs.getString(2));
            corso.setTutor(TutorCRUD.selectTutor(rs.getInt(3)));
            corso.setDurata(rs.getInt(4));
            corso.setStato(rs.getString(5));
            corsi.add(corso);
        }
        conn.close();
        return corsi;
    }

    public static void deleteCorso(int id) throws SQLException{
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        DeleteMYSQL delete = new DeleteMYSQL(conn);
        String query = "DELETE FROM corso WHERE id=" + id;
        delete.delete(query);
        conn.close();
    }

    public static void insertCorso(String nome, int tutor, int durata) throws SQLException{
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        InsertMYSQL insert= new InsertMYSQL(conn);
        String query = "INSERT INTO corso(nome,tutor,durata) VALUES('" + nome + "'," + tutor + "," + durata + ")";
        insert.insert(query);
        conn.close();
    }

    public static void updateCorso(int id, String nome, int tutor, int durata) throws SQLException {
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        UpdateMYSQL update=new UpdateMYSQL(conn);
        String query = "UPDATE corso set nome='" + nome + "', tutor=" + tutor + ", durata=" + durata + " WHERE id=" + id;
        update.update(query);
        conn.close();
    }
}
