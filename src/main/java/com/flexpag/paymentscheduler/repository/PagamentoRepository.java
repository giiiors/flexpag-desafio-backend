package com.flexpag.paymentscheduler.repository;

import com.flexpag.paymentscheduler.model.PagamentoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<PagamentoModel, Long>{
}
