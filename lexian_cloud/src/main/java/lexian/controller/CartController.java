package lexian.controller;

import lexian.entity.CartList;
import lexian.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    public void setCartService(CartService cartService){
        this.cartService = cartService;
    }

    @PostMapping("/loadCart")
    public List<CartList> loadCart(@RequestBody Map<String,Object> map){
        System.out.println(map);
        return cartService.loadCart(map);
    }

}
