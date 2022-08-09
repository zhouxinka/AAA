package com.example.serviceImpl;

import com.example.dao.UserDao;
import com.example.entity.User;
import com.example.service.CrudService;
import com.example.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;


/**
 * @author zhoupeng
 * @create time 2021-04-14-15:10
 */
@Service
public class UserServiceImpl extends CrudService<UserDao, User> implements UserService {
    @Resource
    private UserDao userDao;

    @Override
    public void addUser(User user, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User current_user = (User)session.getAttribute("CURRENT_USER");
        //插入前处理的方法
        user.preInsert(current_user);
        System.out.println("UserServiceImpl里面的addUser方法的user:"+user.toString());
        userDao.addUser(user);
    }

    @Override
    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    @Override
    @Transactional
    public void deleteUser(User user) {
        delete(user);//调用的是父类CrudService的delete方法
    }

    @Override
    public User getUserById(Integer id) {
        return super.get(id+"");//调用父类CrudService的get方法

    }

    @Override
    public List<User> findAllUser(User user) {
        return findList(user);//调用的是父类CrudService的findList方法
    }

    @Override
    public List<User> findAllUser_2(Map<String,Integer> map) {
        return userDao.findAllUser_2(map);
    }

    public void test(){
        System.out.println("UserServiceImpl.test()");
    }
}
