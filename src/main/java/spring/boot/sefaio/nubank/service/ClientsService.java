package spring.boot.sefaio.nubank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.boot.sefaio.nubank.dto.ClientsResponseDTO;
import spring.boot.sefaio.nubank.dto.ContactsResponseDTO;
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

    public List<ClientsResponseDTO> listAllClients(){
        return clientRepository
                .findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<ContactsResponseDTO> listByClientId(Long clientId){
      Clients client = clientRepository.findById(clientId)
              .orElseThrow(()-> new RuntimeException("Client not found"));

      return client.getContacts().stream().map(c -> {
          ContactsResponseDTO dto = new ContactsResponseDTO();
          dto.setId(c.getId());
          dto.setPhoneNumber(c.getPhoneNumber());
          dto.setEmail(c.getEmail());
          return dto;
      }).collect(Collectors.toList());
    };


    private ClientsResponseDTO toDTO(Clients client){
        ClientsResponseDTO dto = new ClientsResponseDTO();
        dto.setId(client.getId());
        dto.setName(client.getName());

        List<ContactsResponseDTO> contacts = client.getContacts().stream().map(c -> {
            ContactsResponseDTO contactDTO = new ContactsResponseDTO();
            contactDTO.setId(c.getId());
            contactDTO.setPhoneNumber(c.getPhoneNumber());
            contactDTO.setEmail(c.getEmail());
            return contactDTO;
        }).collect(Collectors.toList());
        dto.setContacts(contacts);
        return dto;
    }
}
