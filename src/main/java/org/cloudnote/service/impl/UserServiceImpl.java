package org.cloudnote.service.impl;

import java.util.List;

import org.cloudnote.core.dao.IBaseDao;
import org.cloudnote.core.exception.OMException;
import org.cloudnote.core.query.BaseQueryPage;
import org.cloudnote.entity.User;
import org.cloudnote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private IBaseDao<User> entityDao;

	@Override
	public String userLogin(User user) throws OMException {
		String pw = user.getCn_user_password();
        BaseQueryPage<User> query = new BaseQueryPage<User>();
        query.setDto(user);
        query.setEntityCls(User.class);
        query.setBatisKey("findByName");
        List<User> userList = entityDao.findList(query);
        if (userList.size() == 0){
            return "登录用户名不存在";
        }else {
            User entity = userList.get(0);
            if (!pw.equals(entity.getCn_user_password())) {
                return "登录密码不正确";
            }
        }
        return null;
	}

}
