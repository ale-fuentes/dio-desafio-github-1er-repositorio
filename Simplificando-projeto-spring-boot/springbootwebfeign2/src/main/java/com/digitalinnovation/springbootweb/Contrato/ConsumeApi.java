package com.digitalinnovation.springbootweb.Contrato;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.digitalinnovation.springbootweb.entidad.Contato;

@FeignClient(name="agenda", url="http://localhost:8080/contato")
public interface ConsumeApi {
	
	@RequestMapping(method= RequestMethod.GET, value="/")
	Contato retornaContato();

}
