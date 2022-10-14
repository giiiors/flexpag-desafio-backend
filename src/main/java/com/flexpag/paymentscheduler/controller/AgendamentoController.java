package com.flexpag.paymentscheduler.controller;

import com.flexpag.paymentscheduler.model.Agendamento;
import com.flexpag.paymentscheduler.service.AgendamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = "*")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @PostMapping("/agendarPagamento")
    public ResponseEntity<Agendamento> agendarPagamento(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = this.service.agendarPagamento(agendamento);
        return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
    }

    @GetMapping("/realizarPagamento/{id}")
    public ResponseEntity<Agendamento> realizarPagamento(@PathVariable Long id) {
         Agendamento boletoPago = this.service.realizarPagamento(id);
         return new ResponseEntity<>(boletoPago, HttpStatus.OK);
    }

}
