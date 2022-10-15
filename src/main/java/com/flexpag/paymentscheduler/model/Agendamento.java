package com.flexpag.paymentscheduler.model;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.flexpag.paymentscheduler.utils.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="tb_pagamentos")
public class Agendamento {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pagamento_seq")
	@SequenceGenerator(name = "user_seq", allocationSize = 1)
	private Long id;
	
	private String usuario;
	private Double valor;

	@Enumerated(EnumType.STRING)
	private Status status;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate dataAgendamento;

	@JsonFormat(pattern="HH:mm")
	private Date horaAgendamento;
	
}
