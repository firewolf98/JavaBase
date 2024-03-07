package it.itsvil.corsihibernate;

import it.itsvil.corsihibernate.model.StudenteBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import it.itsvil.corsihibernate.services.StudenteService;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.scan("it.itsvil.corsihibernate");
        context.refresh();

        StudenteService studenteService = context.getBean(StudenteService.class);

        StudenteBean studente = new StudenteBean();
        studente.setNome("Mario");
        studente.setCognome("Rossi");
        studenteService.save(studente);

        context.close();
    }
}