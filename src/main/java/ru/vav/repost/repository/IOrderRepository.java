package ru.vav.repost.repository;

import java.util.Collection;

import ru.vav.repost.entity.Order;

public interface IOrderRepository {

    /**
     * Save order
     *
     * @param order
     * @return order after insert
     * @throws RepositoryException
     */
    Order insert(Order order) throws RepositoryException;

    /**
     * Get all orders
     *
     * @return collection of all orders
     * @throws RepositoryException
     */
    Collection<Order> getAllOrders() throws RepositoryException;

    /**
     * Update order
     *
     * @param order order to update
     * @throws RepositoryException
     */
    void update(Order order) throws RepositoryException;

    /**
     * Find order by id
     *
     * @param id order id
     * @return order
     * @throws RepositoryException
     */
    Order findById(Integer id) throws RepositoryException;
}