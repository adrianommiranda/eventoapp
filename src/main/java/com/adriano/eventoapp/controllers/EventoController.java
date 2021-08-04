package com.adriano.eventoapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.adriano.eventoapp.model.Evento;
import com.adriano.eventoapp.repository.EventoRepository;

@Controller
public class EventoController {

	@Autowired
	private EventoRepository eventoRepository;
	
	//Mostrar o formulario de cadastramento
	@RequestMapping(value="/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "evento/formEvento";
	}
	
	//Quando clica no botao salvar(pos), salva no banco e redireciona para o cadastrarEvento Get
	@RequestMapping(value="/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {//Recebe um model-obj
		
		//persistindo no banco de dados
		eventoRepository.save(evento);
		return "redirect:/cadastrarEvento";
	}
	
	//Retornando uma lista de eventos
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() { 
		
		/*Vamos recever um obj do tipo ModelAndView e vamos passar para ele qual a pagina que ele vai 
		renderizar de acordo com os dados do evento, no caso é o index */
		ModelAndView mv = new ModelAndView("index"); 
		
		/*Fazendo uma busca no banco de dados. Vamos criar um obj Eevento do tipo Iterable, porque ele é uma lista de eventos*/
		Iterable<Evento> eventos = eventoRepository.findAll();
		
		/*Passando a lista de eventos para a view*/
		mv.addObject("eventos", eventos);
		
		return mv;
	}
}
