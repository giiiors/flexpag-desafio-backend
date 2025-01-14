package com.flexpag.paymentscheduler.utils;

import com.flexpag.paymentscheduler.exception.BadRequestException;
import com.flexpag.paymentscheduler.model.Agendamento;

import java.time.LocalDate;

public class Validacao {

    public static void validarAgendamento(Agendamento agendamento){

        if(agendamento.getUsuario().length()==0)throw new BadRequestException("O campo de usuário deve ser preenchido");

        if(agendamento.getValor() == null || agendamento.getDataAgendamento() == null || agendamento.getUsuario() == null || agendamento.getHoraAgendamento() == null) throw new BadRequestException("Todos os campos devem estar preenchidos!");

        if(agendamento.getDataAgendamento().isBefore(LocalDate.now())) throw new BadRequestException("A data do pagamento não pode ser menor que a data atual");

        if(agendamento.getValor() <= 0) throw new BadRequestException("O valor do boleto deve ser maior que R$ 0");
    }
}
