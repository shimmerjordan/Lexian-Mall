/**
 * 
 */
package lexian.service;

import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

/**
 * @author yang990322
 *
 */
@Transactional
public interface PaymentService {

	int saveOrder(Map<String, Object> params);

	Boolean payBill(Map<String, Object> params);
}
