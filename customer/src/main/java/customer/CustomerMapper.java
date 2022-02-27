package customer;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;
/**
 * customerテーブルCRUD用　Mapper
 * @author Kousaku Kawamoto
 * @version 1.0.0
 */
@Mapper
public interface CustomerMapper {

	Customer read(@Param("id") int id);
	
	boolean create(@Param("customer") Customer customer);

	boolean update(@Param("customer") Customer customer);

	boolean delete(@Param("id") int id);
	
}