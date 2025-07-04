package spring.boot.sefaio.nubank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientsDTO {

    private String name;
    private List<ContactDTO> contacts;

}
