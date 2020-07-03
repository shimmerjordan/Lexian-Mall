package lexian.server.service;
import lexian.server.mapper.UserMapper;
import lexian.server.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author neu
 * @date 2020/6/10
 **/
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> queryAll() {
        return userMapper.selectList(null);
    }
}
