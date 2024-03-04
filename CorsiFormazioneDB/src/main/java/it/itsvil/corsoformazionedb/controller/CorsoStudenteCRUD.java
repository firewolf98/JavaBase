package it.itsvil.corsoformazionedb.controller;

import it.itsvil.corsoformazionedb.model.CorsoBean;
import it.itsvil.corsoformazionedb.model.CorsoStudenteBean;
import it.itsvil.corsoformazionedb.model.StudenteBean;
import it.itsvil.corsoformazionedb.sql.Connessione;
import it.itsvil.corsoformazionedb.sql.DeleteMYSQL;
import it.itsvil.corsoformazionedb.sql.InsertMYSQL;
import it.itsvil.corsoformazionedb.sql.SelectMYSQL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CorsoStudenteCRUD {

    public static CorsoStudenteBean selectCorsoStudente(int corso, int studente) throws SQLException {
        CorsoStudenteBean corsoStudente = new CorsoStudenteBean();
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        SelectMYSQL select = new SelectMYSQL(conn);
        String query = "SELECT * FROM corsostudente WHERE corso=" + corso + "AND studente=" + studente;
        ResultSet rs = select.select(query);
        while(rs.next()) {
            corsoStudente.setCorso(CorsoCRUD.selectCorso(rs.getInt(1)));
            corsoStudente.setStudente(StudenteCRUD.selectStudente(rs.getInt(2)));
        }
        return corsoStudente;
    }

    public static List<CorsoStudenteBean> selectTutorAll() throws SQLException{
        CorsoStudenteBean corsoStudente = new CorsoStudenteBean();
        List<CorsoStudenteBean> corsoStudenti = new ArrayList<CorsoStudenteBean>();
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        SelectMYSQL select = new SelectMYSQL(conn);
        String query = "SELECT * FROM corsostudente";
        ResultSet rs = select.select(query);
        while(rs.next()) {
            corsoStudente.setCorso(CorsoCRUD.selectCorso(rs.getInt(1)));
            corsoStudente.setStudente(StudenteCRUD.selectStudente(rs.getInt(2)));
            corsoStudenti.add(corsoStudente);
        }
        conn.close();
        return corsoStudenti;
    }

    public static void deleteCorsoStudente(int corso, int studente) throws SQLException{
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        DeleteMYSQL delete = new DeleteMYSQL(conn);
        String query = "DELETE FROM corsostudente WHERE corso=" + corso + "AND studente=" + studente;
        delete.delete(query);
        conn.close();
    }

    public static void insertCorsoStudente(int corso, int studente) throws SQLException{
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        InsertMYSQL insert= new InsertMYSQL(conn);
        String query = "INSERT INTO corsostudente(corso, studente) VALUES(" + corso + "," + studente + ")";
        insert.insert(query);
        conn.close();
    }

    public static List<CorsoBean> selectCorsiStudente(int studente) throws SQLException{
        CorsoBean corso;
        List<CorsoBean> corsi = new ArrayList<CorsoBean>();
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        SelectMYSQL select = new SelectMYSQL(conn);
        String query = "SELECT corso" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                " FROM corsostudente WHERE studente=" + studente;
        ResultSet rs = select.select(query);
        while(rs.next()) {
            corso = CorsoCRUD.selectCorso(rs.getInt(1));
            corsi.add(corso);
        }
        return corsi;
    }

    public static List<StudenteBean> selectStudentiCorso(int corso) throws SQLException{
        StudenteBean studente;
        List<StudenteBean> studenti = new ArrayList<StudenteBean>();
        Connessione c = new Connessione();
        Connection conn = c.connessione();
        SelectMYSQL select = new SelectMYSQL(conn);
        String query = "SELECT studente FROM corsostudente WHERE corso=" + corso;
        ResultSet rs = select.select(query);
        while(rs.next()) {
            studente = StudenteCRUD.selectStudente(rs.getInt(1));
            studenti.add(studente);
        }
        return studenti;
    }
}
