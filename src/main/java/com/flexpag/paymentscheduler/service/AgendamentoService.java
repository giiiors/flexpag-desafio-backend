package com.flexpag.paymentscheduler.service;

import com.flexpag.paymentscheduler.model.Agendamento;
import com.flexpag.paymentscheduler.repository.AgendamentoRepository;
import com.flexpag.paymentscheduler.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

@Autowired
private AgendamentoRepository repository;

public Agendamento agendarPagamento(Agendamento agendamento) {
    agendamento.setStatus(Status.PENDING);
    return this.repository.save(agendamento);
}

public Agendamento obterAgendamento(Long id) {
    return this.repository.findById(id).get();
}

public Agendamento realizarPagamento(Long id) {
    Agendamento agendamento = this.obterAgendamento(id);
    agendamento.setStatus(Status.PAID);
    return this.repository.save(agendamento);
}

}
