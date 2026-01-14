package org.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {

    private final TransactionRepository repository;
    private final TransactionService generator;

    public TransactionController(TransactionRepository repository, TransactionService generator) {
        this.repository = repository;
        this.generator = generator;
    }

    // Generate 1 transaction
    @PostMapping("/generate")
    public Transaction generateOne() {
        Transaction t = generator.generateTransaction();
        return repository.save(t);
    }

    // Generate N transactions
    @PostMapping("/generate/{count}")
    public List<Transaction> generateMany(@PathVariable int count) {
        List<Transaction> list = generator.generateMultiple(count);
        return repository.saveAll(list);
    }

    // Fetch ALL transactions
    @GetMapping("/all")
    public List<Transaction> getAll() {
        return repository.findAll();
    }

    // Fetch by ID
    @GetMapping("/{id}")
    public Transaction getById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    // Fetch by sender account
    @GetMapping("/sender/{sender}")
    public List<Transaction> getBySender(@PathVariable String sender) {
        return repository.findBySender(sender);
    }

    // Fetch by status (SUCCESS/FAILED)
    @GetMapping("/status/{status}")
    public List<Transaction> getByStatus(@PathVariable String status) {
        return repository.findByStatus(status);
    }
}
