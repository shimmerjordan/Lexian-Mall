/**
 * 
 */
package lexian.service.serviceImpl;

import java.sql.Timestamp;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;

import lexian.common.DateUtils;
import lexian.entity.Order;
import lexian.entity.model.GoodDetailsModel;
import lexian.mapper.PaymentMapper;
import lexian.service.PaymentService;

/**
 * @author yang990322
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentMapper paymentMapper;

	@Transactional
	public int saveOrder(Map<String, Object> params) {
		List<GoodDetailsModel> gdms = JSON.parseArray(String.valueOf(params.get("jsonStr")), GoodDetailsModel.class);
		Order order = new Order();
		order.setStatus(0);
		order.setDate(new Timestamp(System.currentTimeMillis()));
		paymentMapper.insertOrder(order);
		params.put("orderId", order.getID());
		List<String> shopOrders = new ArrayList<>();
		List<GoodDetailsModel> gdmList = new ArrayList<>();
		for (GoodDetailsModel goodDetailsModel : gdms) {
			shopOrders.add(goodDetailsModel.getShopId());
			gdmList.addAll(goodDetailsModel.getCids());
		}
		paymentMapper.insertShopOrder(shopOrders, order.getID());
		paymentMapper.insertOrderItem(gdmList, order.getID());
		paymentMapper.insertCustomeOrder(params);
		paymentMapper.insertOrderAddress(params);
		return order.getID();
	}

	@Transactional
	@Override
	public boolean payBill(Map<String, Object> params) {
		HashMap<String, Object> map = new HashMap<>();
		params.put("orderNumber", getNum15());
		params.put("consumeTime", new Date());
		params.put("orderStatus", "待收货");
		paymentMapper.insertBill(params);
		params.put("billId", params.get("id"));
		paymentMapper.insertWalletBill(params);
		params.put("consumePrice", Double.parseDouble(String.valueOf(params.get("consumePrice"))));
		map.put("orderId", params.get("orderId"));
		System.out.println(params);
		System.out.println(map);
		paymentMapper.updateOrderStatus(map);
		System.out.println(paymentMapper.updateOrderStatus(map));
		return paymentMapper.updateBalance(params) > 0;
	}

	public String getNum15() {
		StringBuffer strbuf = new StringBuffer();
		strbuf.append(String.valueOf((Math.random() * 9 + 1) * 1000000).substring(0, 4));
		String dateTimeNow = DateUtils.dateTimeNow();
		strbuf.append(dateTimeNow.substring(dateTimeNow.length() - 11, dateTimeNow.length()));
		return strbuf.toString();

	}

}
