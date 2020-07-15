/**
 * 
 */
package lexian.service;

import java.util.Map;

/**
 * @author yang990322
 *
 */
public interface PaymentService {

	int saveOrder(Map<String, Object> params);

	Boolean payBill(Map<String, Object> params);
}
