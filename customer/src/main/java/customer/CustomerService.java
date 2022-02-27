package customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * customerテーブルCRUD用　Service
 * @author Kousaku Kawamoto
 * @version 1.0.0
 */
@Service
public class CustomerService {
	
	@Autowired
	CustomerMapper customerMapper;
	
	public Customer read(int id) {
		return customerMapper.read(id);
	}
	
	public boolean create(Customer customer) {
		return customerMapper.create(customer);
	}
	
	public boolean update(Customer customer) {
		return customerMapper.update(customer);
	}
	
	public boolean delete(int id) {
		return customerMapper.delete(id);
	}
	
}
