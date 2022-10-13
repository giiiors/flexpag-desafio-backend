package com.flexpag.paymentscheduler.service;

import com.flexpag.paymentscheduler.model.Pagamento;
import com.flexpag.paymentscheduler.repository.PagamentoRepository;
import com.flexpag.paymentscheduler.utils.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PagamentoService {

@Autowired
private PagamentoRepository repository;

public Pagamento agendarPagamento(Pagamento pagamento) {
    pagamento.setStatus(Status.PENDING);
    return this.repository.save(pagamento);
}

public Pagamento pagamentoRealizado(Long id){
    Pagamento pagamento = this.repository.findById(id).get();

    pagamento.setStatus(Status.PAID);

    return this.repository.save(pagamento);
}

}
