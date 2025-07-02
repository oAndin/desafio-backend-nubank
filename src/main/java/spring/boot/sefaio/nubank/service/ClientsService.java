package spring.boot.sefaio.nubank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.sefaio.nubank.repository.ClientRepository;
import spring.boot.sefaio.nubank.dto.ClientsDTO;
import spring.boot.sefaio.nubank.model.Clients;
import spring.boot.sefaio.nubank.model.Contacts;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ClientsService {

    @Autowired
    private ClientRepository clientRepository;

    public Clients saveClients(ClientsDTO dto){

        // Instanciacao do objeto client
        Clients client = new Clients();
        // Pegar nome pelo dto
        client.setName(dto.getName());

        // Verifica se existem contatos no DTO
        if(dto.getContacts() != null && dto.getContacts().size() > 0){

            List<Contacts> contacts = dto.getContacts().stream().map(c -> {

                Contacts contact = new Contacts();

                contact.setPhoneNumber(c.getPhoneNumber());

                contact.setEmail(c.getEmail());

                contact.setClients(client);

                return contact;

            }).collect(Collectors.toList());

            client.setContacts(contacts);
        }


        return clientRepository.save(client);
    }

}
