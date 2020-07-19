/**
 * 
 */
package lexian.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lexian.service.PaymentService;

/**
 * @author yang990322
 *
 */
@RestController
@RequestMapping("/api/pay")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@RequestMapping("/placeOrder")
	public int placeOrder(@RequestBody Map<String, Object> params) {
		return paymentService.saveOrder(params);
	}
	
	@RequestMapping("/payBill")
	public Boolean payBill(@RequestBody Map<String, Object> params){
		return paymentService.payBill(params);
	}
	
	

}
