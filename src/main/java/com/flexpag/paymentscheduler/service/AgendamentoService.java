package com.flexpag.paymentscheduler.service;

import com.flexpag.paymentscheduler.exception.BadRequestException;
import com.flexpag.paymentscheduler.exception.NotFoundException;
import com.flexpag.paymentscheduler.model.Agendamento;
import com.flexpag.paymentscheduler.repository.AgendamentoRepository;
import com.flexpag.paymentscheduler.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository repository;

    public Agendamento agendarPagamento(Agendamento agendamento) {
        agendamento.setStatus(Status.PENDING);
        return this.repository.save(agendamento);
    }

    public Agendamento obterAgendamento(Long id) {
        Optional<Agendamento> agendamento = this.repository.findById(id);
        return agendamento.orElseThrow(() -> new NotFoundException("Agendamento não encontrado!"));

    }

    public Agendamento realizarPagamento(Long id) {
        Agendamento agendamento = this.obterAgendamento(id);
        agendamento.setStatus(Status.PAID);
        return this.repository.save(agendamento);
    }

        public Agendamento atualizarAgendamento(Long id, Agendamento agendamentoAtualizado) {
        Agendamento agendamento = this.obterAgendamento(id);

        if (agendamento.getStatus() == Status.PAID) throw new BadRequestException("O boleto já foi pago, não pode ser atualizado!");

        agendamento.setUsuario(agendamentoAtualizado.getUsuario());
        agendamento.setHoraAgendamento(agendamentoAtualizado.getHoraAgendamento());
        agendamento.setDataAgendamento(agendamentoAtualizado.getDataAgendamento());
        agendamento.setValor(agendamentoAtualizado.getValor());

        return this.repository.save(agendamento);
    }

    public void deletarAgendamento(Long id) {
        Agendamento agendamento = this.obterAgendamento(id);

        if(agendamento.getStatus() == Status.PAID) throw new BadRequestException("O boleto já foi pago, não pode ser deletado!");

        this.repository.deleteById(id);

    }

    public Status consultarStatus(Long id) {
       Agendamento agendamento = this.obterAgendamento(id);
       return agendamento.getStatus();
    }
}
