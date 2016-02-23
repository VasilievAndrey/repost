package ru.vav.repost.service;

import java.util.Collection;

import ru.vav.repost.entity.Order;
import ru.vav.repost.repository.RepositoryException;

public interface IOrderService {

    /**
     * Save order
     *
     * @param order order
     * @return order after insert
     */
    Order insert(Order order);

    /**
     * Save or update order
     *
     * @param order order
     * @return order after insert or update
     */
    Order saveOrUpdate(Order order);

    /**
     * Get all orders
     *
     * @return collection
     * @throws RepositoryException
     */
    Collection<Order> getAllOrders();

    /**
     * Find order by id
     *
     * @param id order id to find
     * @return order with given id
     */
    Order findById(Integer id);
}