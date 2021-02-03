package com.hh.usermybatisplus.service.impl;

        import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
        import com.hh.usermybatisplus.mapper.UserBeanMapper;
        import com.hh.usermybatisplus.pojo.UserBean;
        import com.hh.usermybatisplus.service.UserBeanService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

        import java.util.List;

@Service
public class UserBeanServiceImpl implements UserBeanService {

    @Autowired
    private UserBeanMapper userBeanMapper;

    @Override
    public UserBean findUserBean(String id) {
        QueryWrapper queryWrapper = new QueryWrapper<UserBean>();
        return (UserBean) userBeanMapper.selectList(queryWrapper).stream().findFirst().get();
    }

    @Override
    public List<UserBean> findUserBeanByName(String username) {
        QueryWrapper<UserBean> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("username",username);
        return userBeanMapper.selectList(queryWrapper);
    }
}
