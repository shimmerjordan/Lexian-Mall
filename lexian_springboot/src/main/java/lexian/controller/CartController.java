package lexian.controller;

import lexian.entity.Cart;
import lexian.entity.CartList;
import lexian.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {
    private CartService cartService;

    /**
     * @param cartService
     */
    @Autowired
    public void setCartService(CartService cartService){
        this.cartService = cartService;
    }

    /**
     * @note 加载购物车数据
     * @param map
     * @return CartList类型的List
     */
    @PostMapping("/loadCart")
    public List<CartList> loadCart(@RequestBody Map<String,Object> map){
        List<CartList> result = cartService.loadCart(map);
        return result;
    }

    /**
     * @note 购物车更新所选商品个数
     * @param map
     * @return 标识操作成功与否（0，1）
     */
    @PostMapping("/updateQuantity")
    public int updateQuantity(@RequestBody Map<String, Object> map){
        int result = cartService.updateQuantity(map);
        return result;
    }

    /**
     * @note 删除购物车的操作，将isDelete置为0
     * @param map
     * @return 操作成功的boolean变量
     */
    @PostMapping("/deleteCartItem")
    public boolean deleteCartItem(@RequestBody Map<String, Object> map){
        boolean result = cartService.deleteCartItem(map);
        System.out.println(map);
        return result;
    }

    /**
     * @note 清空购物车，相当于批量删除
     * @param cartIdList
     * @return 标识操作成功与否（0，1）
     */
    @PostMapping("/clearCart")
    public int clearCart(@RequestBody List<Object> cartIdList){
        System.out.println(cartIdList);
        return cartService.clearCart(cartIdList);
    }
    
    
    /**
     * @bnote 商品加入购物车
     * @param cart
     */
    @RequestMapping("/save")
    public boolean save(@RequestBody Cart cart){
    	return cartService.save(cart);
    }

}
