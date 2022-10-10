package org.sid.ebankservice.web;

import org.sid.ebankservice.entities.BankAccount;
import org.sid.ebankservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class BankAccountRestController {

   private BankAccountRepository bankAccountRepository;

   public BankAccountRestController(BankAccountRepository bankAccountRepository){
       this.bankAccountRepository=bankAccountRepository;
   }
    // methode qui retourne la liste des comptes sous format json
   @GetMapping("/bankAccounts")
   public List<BankAccount> bankAccounts(){
       return bankAccountRepository.findAll();
   }
    // methode qui permet de consulter le compte à partir de l'id
    @GetMapping("/bankAccounts/{id}")
    public BankAccount getAccount(@PathVariable String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException("Account not found"));
    }
    // methode qui permet d'ajouter un compte
    @PostMapping("/bankAccounts")
    public BankAccount save(BankAccount bankAccount){
       bankAccount.setId(UUID.randomUUID().toString());
       return bankAccountRepository.save(bankAccount);
    }
    // methode qui permet de mettre a jour un compte
    @PutMapping ("/bankAccounts/{id}")
    public BankAccount update(@RequestBody BankAccount bankAccount, @PathVariable String id){
        bankAccount.setId(id);
        return bankAccountRepository.save(bankAccount);
    }
    // methode qui permet de supprimer un compte
    @DeleteMapping  ("/bankAccounts/{id}")
    public void delete (@PathVariable String id){
        bankAccountRepository.deleteById(id);
    }
}
