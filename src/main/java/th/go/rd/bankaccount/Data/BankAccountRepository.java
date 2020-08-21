package th.go.rd.bankaccount.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.go.rd.bankaccount.Model.BankAccount;

@Repository
public interface BankAccountRepository extends JpaRepository<BankAccount,Integer> {

}
