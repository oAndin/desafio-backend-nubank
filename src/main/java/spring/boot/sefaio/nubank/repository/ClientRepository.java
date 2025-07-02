package spring.boot.sefaio.nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.sefaio.nubank.model.Clients;

public interface ClientRepository extends JpaRepository<Clients, Long> {



}
