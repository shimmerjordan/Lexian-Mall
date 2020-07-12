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
    public int clearCart(@RequestBody List<HashMap> cartList){
        for(int i = 0; i < cartList.size(); i++){

            Collection<Integer> values = cartList.get(i).values();			//获取HashMap值
            System.out.print("Map值：");
            for(Integer value:values){					//遍历输出HashMap值
                System.out.print(value+" ");
            }

        }
        System.out.println(cartList);
        return 1;
    }
    
    
    /**
     * 商品加入购物车
     * @param cart
     */
    @RequestMapping("save")
    public Boolean save(@RequestBody Cart cart){
    	return cartService.save(cart);
    }

}
