package com.wallet.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.wallet.constant.TransactionType;

import lombok.Data;

@Data
@Entity
@Table(name = "Transaction")
public class Transaction {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TransactionType type;

//	public Transaction() {
//
//	}
//
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getType() {
//		return type;
//	}
//
//	public void setType(String type) {
//		this.type = type;
//	}
//
//	@Override
//	public String toString() {
//		return "Transaction [type=" + type;
//	}
//
//	public Transaction(String type) {
//
//	}

}
