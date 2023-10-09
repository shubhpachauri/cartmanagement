package com.example.CaseStudyCart.CartManagement.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="Cart")
@SequenceGenerator(name="MySequence",sequenceName="cart_sequence",initialValue=50,allocationSize=1)
public class CartItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="MySequence")
	@Column(name="ID")
	private int id;
	
	@Column(name="ITEM_NAME")
	private String itemName;
	@Column(name="DESCRIPTION")
	private String description;
	@Column(name="PRICE")
	private int price;
	
	
	public CartItem() {}
	public CartItem(int id, String itemName, String desc, int price) {
		super();
		this.id = id;
		this.itemName = itemName;
		this.description = desc;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
}