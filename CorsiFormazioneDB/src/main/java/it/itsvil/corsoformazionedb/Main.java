package it.itsvil.corsoformazionedb;

import it.itsvil.corsoformazionedb.controller.CorsoCRUD;
import it.itsvil.corsoformazionedb.controller.CorsoStudenteCRUD;
import it.itsvil.corsoformazionedb.controller.StudenteCRUD;
import it.itsvil.corsoformazionedb.controller.TutorCRUD;
import it.itsvil.corsoformazionedb.model.CorsoBean;
import it.itsvil.corsoformazionedb.model.CorsoStudenteBean;
import it.itsvil.corsoformazionedb.model.StudenteBean;
import it.itsvil.corsoformazionedb.model.TutorBean;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        boolean flag = true;
        Scanner scanner = new Scanner(System.in);

        while(flag) {
            int scelta = menu(scanner);
            switch (scelta) {
                case 0:
                    List<CorsoBean> corsi = CorsoCRUD.selectCorsoAll();
                    for(CorsoBean corso: corsi) {
                        System.out.println(corso);
                    }
                    break;
                case 1:
                    System.out.println("Inserisci il nome del corso:");
                    scanner.nextLine();
                    String nomeCorso = scanner.nextLine();
                    System.out.println("Inserisci l'id del tutor del corso:");
                    int idTutor = scanner.nextInt();
                    System.out.println("Inserisci la durata del corso:");
                    int durata = scanner.nextInt();
                    CorsoCRUD.insertCorso(nomeCorso,idTutor,durata);
                    break;
                case 2:
                    System.out.println("Inserisci l'id del corso che vuoi visualizzare:");
                    CorsoBean corso = CorsoCRUD.selectCorso(scanner.nextInt());
                    System.out.println(corso);
                    break;
                case 3:
                    List<TutorBean> tutors = TutorCRUD.selectTutorAll();
                    for(TutorBean tutor: tutors) {
                        System.out.println(tutor);
                    }
                    break;
                case 4:
                    System.out.println("Inserisci il nome del tutor:");
                    scanner.nextLine();
                    String nomeTutor = scanner.nextLine();
                    System.out.println("Inserisci il cognome del tutor:");
                    String cognomeTutor = scanner.nextLine();
                    System.out.println("Inserisci l'email del tutor:");
                    String emailTutor = scanner.nextLine();
                    System.out.println("Inserisci il telefono del tutor:");
                    String telefonoTutor = scanner.nextLine();
                    TutorCRUD.insertTutor(nomeTutor,cognomeTutor,emailTutor,telefonoTutor);
                    break;
                case 5:
                    List<StudenteBean> students = StudenteCRUD.selectStudenteAll();
                    for(StudenteBean student: students) {
                        System.out.println(student);
                    }
                    break;
                case 6:
                    System.out.println("Inserisci il nome dello studente:");
                    scanner.nextLine();
                    String nomeStudente = scanner.nextLine();
                    System.out.println("Inserisci il cognome dello studente:");
                    String cognomeStudente = scanner.nextLine();
                    StudenteCRUD.insertStudente(nomeStudente,cognomeStudente);
                    break;
                case 7:
                    System.out.println("Inserisci l'id del corso a cui iscrivere lo studente:");
                    int idCorso = scanner.nextInt();
                    System.out.println("Inserisci l'id dello studente da iscrivere:");
                    int idStudente = scanner.nextInt();
                    CorsoStudenteCRUD.insertCorsoStudente(idCorso,idStudente);
                    break;
                case 8:
                    System.out.println("Inserisci l'id dello studente:");
                    int idStudenteCorsi = scanner.nextInt();
                    List<CorsoBean> corsiStudente = CorsoStudenteCRUD.selectCorsiStudente(idStudenteCorsi);
                    for(CorsoBean corsoStudente: corsiStudente) {
                        System.out.println(corsoStudente);
                    }
                    break;
                case 9:
                    System.out.println("Inserisci l'id del corso:");
                    int idCorsoStudenti = scanner.nextInt();
                    List<StudenteBean> studentiCorso = CorsoStudenteCRUD.selectStudentiCorso(idCorsoStudenti);
                    for(StudenteBean studenteCorsi: studentiCorso) {
                        System.out.println(studenteCorsi);
                    }
                    break;
                case 10:
                    flag = false;
                    break;
                default:
                    System.out.println("Scelta non valida!\n");
                    break;
            }
        }
    }

    private static int menu(Scanner scanner) {
        System.out.println("""
                    Cosa vuoi fare?
                     0- Visualizzare i corsi disponibili
                     1- Inserire un nuovo corso
                     2- Visualizzare un corso specifico
                     3- Visualizzare i tutors
                     4- Aggiungere un nuovo tutor
                     5- Visualizzare gli studenti
                     6- Aggiungere un nuovo studente
                     7- Iscrivere uno studente ad un corso
                     8- Visualizza corsi di uno studente
                     9- Visualizza studenti iscritti a un corso
                     10- Termina""");
        return scanner.nextInt();
    }
}