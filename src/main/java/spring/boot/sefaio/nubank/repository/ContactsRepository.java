package spring.boot.sefaio.nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.sefaio.nubank.model.Contacts;

public interface ContactsRepository extends JpaRepository<Contacts, Long> {

}
