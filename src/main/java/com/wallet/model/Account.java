package com.wallet.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.wallet.constant.AccountType;

import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Table(name="Account")
@Builder
public class Account {

	@Id
	@Column(name="id", nullable=false)
	@GeneratedValue
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name="name", nullable=false)
	private AccountType accountType;
	
	@OneToOne
	@JoinColumn(name="player_id")
	private Player player;
	
	@Column(name="balance", nullable=false)
	private Double balance;
	
	@OneToMany(mappedBy="account")
	private List<Transaction> transction;
	
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Player getPlayerId() {
//		return player;
//	}
//
//	public void setPlayerId(Player player) {
//		this.player = player;
//	}
//
//	public Double getBalance() {
//		return balance;
//	}
//
//	public void setBalance(Double balance) {
//		this.balance = balance;
//	}
//	public Account(Player player, Double balance) {
//		this.player = player;
//		this.balance = balance;
//	}
//
//	@Override
//	public String toString() {
//		return "Account [id=" + id + ", player=" + player + ", balance=" + balance + "]";
//	}	

}
