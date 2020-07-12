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

    @Autowired
    public void setCartService(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("/loadCart")
    public List<CartList> loadCart(@RequestBody Map<String,Object> map){
        List<CartList> result = cartService.loadCart(map);
        return result;
    }

    @PostMapping("/updateQuantity")
    public int updateQuantity(@RequestBody Map<String, Object> map){
        int result = cartService.updateQuantity(map);
        return result;
    }

    @PostMapping("/deleteCartItem")
    public boolean deleteCartItem(@RequestBody Map<String, Object> map){
        boolean result = cartService.deleteCartItem(map);
        System.out.println(map);
        return result;
    }

    @PostMapping("/clearCart")
    public int clearCart(@RequestBody List<Object> cartIdList){
        System.out.println(cartIdList);
        return cartService.clearCart(cartIdList);
    }
    
    
    /**
     * 商品加入购物车
     * @param cart
     */
    @RequestMapping("save")
    public boolean save(@RequestBody Cart cart){
    	return cartService.save(cart);
    }

}
