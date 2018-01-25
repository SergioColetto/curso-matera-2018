package com.matera.profile.cliente;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("PJ")
public class ClientePJ implements Cliente {

	public String getTipo() {
		return "Sou PJ";
	}

}
