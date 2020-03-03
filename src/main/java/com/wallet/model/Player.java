package com.wallet.model;
import java.util.List;

/**
 * @author Sanghamitra
 * Model object for Account object
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.wallet.constant.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Player", uniqueConstraints=@UniqueConstraint(columnNames="code"))
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Player {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;

	@Column(name = "firstName", nullable = false)
	private String firstName;

	@Column(name = "lastName")
	private String lastName;

	@Column(name="code", nullable=false)	
	private String code;
	

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public String getFirstName() {
//		return firstName;
//	}
//
//	public void setFirstName(String firstName) {
//		this.firstName = firstName;
//	}
//
//	public String getLastName() {
//		return lastName;
//	}
//
//	public void setLastName(String lastName) {
//		this.lastName = lastName;
//	}
//
//	public Player() {
//
//	}
//
//	public Player(String firstName, String lastName) {
//		//this.id = id;
//		this.firstName = firstName;
//		this.lastName = lastName;
//	}
//
//
//	@Override
//	public String toString() {
//		return "Player [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + "]";
//	}
//
}
