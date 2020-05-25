package guru.springframework.services.reposervices;

import guru.springframework.domain.Order;
import guru.springframework.repositories.OrderRepository;
import guru.springframework.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.LinkedList;
import java.util.List;

public class OrderServiceRepoImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public List<Order> listAll() {
        List<Order> list = new LinkedList<Order>();
        orderRepository.findAll().forEach(list::add);
        return list;
    }

    @Override
    public Order getById(Integer id) {
        return orderRepository.findOne(id);
    }

    @Override
    public Order saveOrUpdate(Order domainObject) {
        return orderRepository.save(domainObject);
    }

    @Override
    public void delete(Integer id) {
        orderRepository.delete(id);
    }
}
