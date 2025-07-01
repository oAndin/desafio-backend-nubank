package spring.boot.sefaio.nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.sefaio.nubank.model.clients;

public interface clientRepository extends JpaRepository<clients, Long> {



}
