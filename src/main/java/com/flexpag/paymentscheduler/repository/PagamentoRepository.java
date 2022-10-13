package com.flexpag.paymentscheduler.repository;

import com.flexpag.paymentscheduler.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long>{
}
