package com.matera.profile.cliente;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile("PF")
public class ClientePF implements Cliente {

	public String getTipo() {
		return "Sou PF";
	}

}
