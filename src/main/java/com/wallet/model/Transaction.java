package com.wallet.model;
import java.util.List;

/**
 * @author Sanghamitra
 * Model object for Account object
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.wallet.constant.AccountType;
import com.wallet.constant.TransactionType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Builder
@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Transaction", uniqueConstraints=@UniqueConstraint(columnNames={"unique_transaction_id"}))
public class Transaction {

	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "type", nullable = false)
	private TransactionType type;
	
	@ManyToOne
	@JoinColumn(name="account_id")
	private Account account;
	
	@Column(name="unique_transaction_id")
	private String uniqueTransactionId;
	
	@Column(name="transaction_amount")
	private Double transactionAmount;

}
