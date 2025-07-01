package spring.boot.sefaio.nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.sefaio.nubank.model.contacts;

public interface contactsRepository extends JpaRepository<contacts, Long> {

}
