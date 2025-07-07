package spring.boot.sefaio.nubank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.sefaio.nubank.dto.ContactDTO;
import spring.boot.sefaio.nubank.model.Clients;
import spring.boot.sefaio.nubank.model.Contacts;
import spring.boot.sefaio.nubank.repository.ClientRepository;
import spring.boot.sefaio.nubank.repository.ContactsRepository;

import java.util.Optional;

@RestController
@RequestMapping("/contacts")
public class ContacController {

    @Autowired
    private ContactsRepository contactsRepository;

    @Autowired
    private ClientRepository clientRepository;

    @PostMapping()
    public ResponseEntity<?> createContact(@RequestBody ContactDTO dto){

        Optional<Clients> clientsOptional = clientRepository.findById(dto.getClientId());

        if(clientsOptional.isEmpty()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Client not found");
        }

        Contacts contact = new Contacts();

        contact.setClients(clientsOptional.get());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setEmail(dto.getEmail());

        contactsRepository.save(contact);
        return ResponseEntity.status(HttpStatus.CREATED).body(contact);
    }

}
