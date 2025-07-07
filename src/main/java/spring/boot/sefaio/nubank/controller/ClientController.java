package spring.boot.sefaio.nubank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.boot.sefaio.nubank.dto.ClientsDTO;
import spring.boot.sefaio.nubank.dto.ClientsResponseDTO;
import spring.boot.sefaio.nubank.dto.ContactsResponseDTO;
import spring.boot.sefaio.nubank.model.Clients;
import spring.boot.sefaio.nubank.service.ClientsService;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientsService clientsService;


    @PostMapping()
    public ResponseEntity<Clients> createClient(@RequestBody ClientsDTO dto){

        //Send responsability to the service to save the client
        Clients savedClient = clientsService.saveClients(dto);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedClient);
    }

    @GetMapping()
    public ResponseEntity<List<ClientsResponseDTO>> listClients(){
        return ResponseEntity.ok(clientsService.listAllClients());
    }

    @GetMapping("/{id}/contatos")
    public ResponseEntity<List<ContactsResponseDTO>> listClientsById(@PathVariable Long id){
        return ResponseEntity.ok(clientsService.listByClientId(id));
    }
}
