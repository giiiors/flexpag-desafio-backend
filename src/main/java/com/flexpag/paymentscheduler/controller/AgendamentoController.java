package com.flexpag.paymentscheduler.controller;

import com.flexpag.paymentscheduler.model.Agendamento;
import com.flexpag.paymentscheduler.service.AgendamentoService;
import com.flexpag.paymentscheduler.utils.Status;
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

    @PostMapping("/agendamento")
    public ResponseEntity<Agendamento> agendarPagamento(@RequestBody Agendamento agendamento) {
        Agendamento novoAgendamento = this.service.agendarPagamento(agendamento);
        return new ResponseEntity<>(novoAgendamento, HttpStatus.CREATED);
    }

    @PatchMapping("/pagamento/{id}")
    public ResponseEntity<Agendamento> realizarPagamento(@PathVariable Long id) {
        Agendamento boletoPago = this.service.realizarPagamento(id);
        return new ResponseEntity<>(boletoPago, HttpStatus.OK);
    }

    @PutMapping("/agendamento/{id}")
    public ResponseEntity<Agendamento> atualizarAgendamento(@PathVariable Long id, @RequestBody Agendamento agendamento) {
        Agendamento agendamentoAtualizado = this.service.atualizarAgendamento(id, agendamento);
        return new ResponseEntity<>(agendamentoAtualizado, HttpStatus.OK);
    }

    @DeleteMapping("/agendamento/{id}")
    public ResponseEntity<Object> deletarAgendamento(@PathVariable Long id) {
        this.service.deletarAgendamento(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/status/{id}")
    public ResponseEntity<Status> consultarStatus(@PathVariable Long id) {
        Status statusAgendamento = this.service.consultarStatus(id);
        return new ResponseEntity<>(statusAgendamento, HttpStatus.OK);
    }
}
