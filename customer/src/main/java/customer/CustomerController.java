package customer;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
/**
 * customerテーブルCRUD用　RestController
 * @author Kousaku Kawamoto
 * @version 1.0.0
 */
 
@RestController
@RequestMapping("customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;

	/**
	 * 指定した顧客IDで顧客テーブルを検索し、該当顧客データを返す
	 * @param id 顧客ID
	 * @return 顧客IDに該当する顧客データ。該当する顧客がいないときはnull。
	 */
	@GetMapping("/read")
	public Map<String, Object> read(@RequestParam("id") int id) {
		Customer customer = customerService.read(id);
		Map<String, Object> response = new HashMap<>();
		response.put("data", customer);
		response.put("status", "success");
		return response;
	}
	
	/**
	 * 顧客テーブルに顧客データを登録する
	 * @param customer 顧客データ
	 * @return 登録成功時　data=true、登録失敗時はエラー処理となる。
	 */
	@PostMapping("/create")
	public Map<String, Object> create(@RequestBody Customer customer) {
		boolean isResult = customerService.create(customer);
		Map<String, Object> response = new HashMap<>();
		response.put("data", isResult);
		response.put("status", "success");
		return response;
	}

	/**
	 * 指定した顧客IDで顧客テーブルの顧客データを更新する
	 * @param customer 顧客データ
	 * @return 更新成功時　data=true、更新対象がない時　data=false
	 */
	@PutMapping("/update")
	public Map<String, Object> update(@RequestBody Customer customer) {
		boolean isResult = customerService.update(customer);
		Map<String, Object> response = new HashMap<>();
		response.put("data", isResult);
		response.put("status", "success");
		return response;
	}

	/**
	 * 指定した顧客IDで顧客テーブルの顧客データを削除する
	 * @param id 顧客ID
	 * @return 削除成功時　data=true、削除対象がない時　data=false
	 */
	@DeleteMapping("/delete")
	public Map<String, Object> delete(@RequestParam("id") int id) {
		boolean isResult = customerService.delete(id);
		Map<String, Object> response = new HashMap<>();
		response.put("data", isResult);
		response.put("status", "success");
		return response;
	}
	
	/**
	 * エラー処理
	 * @param e　例外オブジェクト
	 * @return　status=error、data=エラー内容
	 */
	@ExceptionHandler({Exception.class})
	public Map<String, Object> exceptionHandler(Exception e) {
		Map<String, Object> error = new HashMap<String, Object>();
		error.put("data", e.getMessage());
		error.put("status", "error");
		return error;
	}	
}