package th.go.rd.bankaccount.Controller;

import org.springframework.web.bind.annotation.*;
import th.go.rd.bankaccount.Data.BankAccountRepository;
import th.go.rd.bankaccount.Model.BankAccount;

import java.util.List;

@RestController
@RequestMapping("/api/bankaccount")
public class BankAccountRestController {
    private BankAccountRepository repository;

    public BankAccountRestController(BankAccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<BankAccount> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public BankAccount getOne(@PathVariable int id) {
        return repository.findById(id).get();
    }

    @PostMapping
    public BankAccount create(@RequestBody BankAccount bankAccount){
        repository.save(bankAccount);
        return repository.findById(bankAccount.getId()).get();
    }

    @PutMapping("/{id}")
    public BankAccount update(@PathVariable int id,
                              @RequestBody BankAccount bankAccount) {
        BankAccount record = repository.findById(id).get();
        record.setBalance(bankAccount.getBalance());
        repository.save(record);
        return record;
    }

    @GetMapping("/customer/{id}")
    public List<BankAccount> getAllCustomerId(@PathVariable int id) {
        return repository.findByCustomerId(id);
    }

    @DeleteMapping("/{id}")
    public BankAccount delete(@PathVariable int id) {
        BankAccount record = repository.findById(id).get();
        repository.deleteById(id);
        return record;
    }


}
