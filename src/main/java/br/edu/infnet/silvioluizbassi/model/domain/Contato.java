package br.edu.infnet.silvioluizbassi.model.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Contato {
    private String email;
    private String whatsApp;

    @Override
    public String toString() {
        return String.format("Contato{email='%s', whatsapp='%s'}", email, whatsApp);
    }
}
