package org.ang.projet_abonnement_saas.serviceAbonnemet.openfeign;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String clientid;
    private String lastname;
    private String email;

}
