package com.example.CaseStudyCart.CartManagement.dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import com.example.CaseStudyCart.CartManagement.Entity.CartItem;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;


@Repository
public class CartItemDAO {
	
	private EntityManager entityManager; //EntityManager
	
	public CartItemDAO(EntityManager theEntityManager) {
		this.entityManager=theEntityManager;
	}

	@Transactional()
	public List<CartItem> findAll() {
		Session currentSession=entityManager.unwrap(Session.class);
		Query theQuery=currentSession.createQuery("from CartItem",CartItem.class);
		
		List<CartItem> cartitems=theQuery.getResultList();
		return cartitems;
	}
	
	@Transactional()
	public CartItem getCartItem(int theId) {
		Session currentSession=entityManager.unwrap(Session.class);
		CartItem cartItem=currentSession.get(CartItem.class,theId);
		return cartItem;
	}

	@Transactional()
	public CartItem addTheCartItem(CartItem theCartItem) {
		// TODO Auto-generated method stub
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theCartItem);
		return theCartItem;
	}

	@Transactional()
	public CartItem updateTheCartItem(CartItem theCartItem) {
		
		Session currentSession=entityManager.unwrap(Session.class);
		currentSession.saveOrUpdate(theCartItem);
		return theCartItem;
	}

	@Transactional()
	public void deleteTheCartItem(int cartItemId) {
		// TODO Auto-generated method stub
		
		Session currentSession=entityManager.unwrap(Session.class);
		Query theQuery=currentSession.createQuery("delete from CartItem where id=:itemId"); //delete query is a parametrized query thats why we didn't write employeeId directly
		theQuery.setParameter("itemId",cartItemId);
		theQuery.executeUpdate();
	}
}
