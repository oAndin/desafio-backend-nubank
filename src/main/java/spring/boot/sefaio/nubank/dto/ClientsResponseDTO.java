package spring.boot.sefaio.nubank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientsResponseDTO {

    private Long id;
    private String name;
    private List<ContactsResponseDTO> contacts;
}
