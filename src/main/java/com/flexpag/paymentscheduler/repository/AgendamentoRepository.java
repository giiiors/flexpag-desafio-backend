package com.flexpag.paymentscheduler.repository;

import com.flexpag.paymentscheduler.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long>{
}
