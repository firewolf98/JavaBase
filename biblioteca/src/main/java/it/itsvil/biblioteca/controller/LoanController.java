package it.itsvil.biblioteca.controller;

import it.itsvil.biblioteca.entity.Loan;
import it.itsvil.biblioteca.service.interf.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @PostMapping("/saveloan")
    public ResponseEntity<Loan> saveLoan(@Validated @RequestBody Loan request) {
        Loan savedLoan = loanService.saveLoan(request);
        return ResponseEntity.ok(savedLoan);
    }

    @GetMapping("/getloanbyid")
    public ResponseEntity<Loan> getLoanById(@RequestParam Long id) {
        try {
            Loan loan = loanService.getLoanById(id);
            return ResponseEntity.ok(loan);
        } catch (NoSuchElementException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/getloansbyuserid")
    public ResponseEntity<List<Loan>> getLoansByUserId(@RequestParam Long userId) {
        List<Loan> loans = loanService.getLoansByUserId(userId);
        return ResponseEntity.ok(loans);
    }

    @GetMapping("/getloansbybookid")
    public ResponseEntity<List<Loan>> getLoansByBookId(@RequestParam Long bookId) {
        List<Loan> loans = loanService.getLoansByBookId(bookId);
        return ResponseEntity.ok(loans);
    }

    @DeleteMapping("/deleteloan")
    public ResponseEntity<String> deleteLoan(@RequestParam Long id) {
        loanService.deleteLoan(id);
        return ResponseEntity.ok("Prestito eliminato con successo");
    }

}