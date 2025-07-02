package spring.boot.sefaio.nubank.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ContactsResponseDTO {

    private Long id;
    private String phoneNumber;
    private String email;
    private Long clientId;

}
