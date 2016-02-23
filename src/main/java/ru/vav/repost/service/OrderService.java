package ru.vav.repost.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.vav.repost.entity.Order;
import ru.vav.repost.repository.IOrderRepository;
import ru.vav.repost.repository.RepositoryException;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private IOrderRepository orderDao;

    @Override
    public Order insert(Order or) {
        try {
            return this.orderDao.insert(or);
        } catch (RepositoryException e) {
            //TODO log
            return null;
        }
    }

    @Override
    public Order saveOrUpdate(Order order) {
        try {
            if (order.isNew()) {
                return orderDao.insert(order);
            } else {
                orderDao.update(order);
                return order;
            }
        } catch (RepositoryException e) {
            //TODO log
            return null;
        }
    }

    @Override
    public Collection<Order> getAllOrders() {
        try {
            return orderDao.getAllOrders();
        } catch (RepositoryException e) {
            //TODO log
            return null;
        }
    }

    @Override
    public Order findById(Integer id) {
        try {
            return orderDao.findById(id);
        } catch (RepositoryException e) {
            //TODO log
        }
        return null;
    }
}
