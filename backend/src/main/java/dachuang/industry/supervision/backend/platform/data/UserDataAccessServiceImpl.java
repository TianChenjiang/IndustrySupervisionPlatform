package dachuang.industry.supervision.backend.platform.data;

import dachuang.industry.supervision.backend.platform.data.dao.UserDao;
import dachuang.industry.supervision.backend.platform.dataservice.UserDataAccessService;
import dachuang.industry.supervision.backend.platform.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDataAccessServiceImpl implements UserDataAccessService {
    private final UserDao userDao;
    @Autowired
    public UserDataAccessServiceImpl(UserDao userDao){
        this.userDao = userDao;
    }

    @Override
    public User GetUserById(int id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public User UpdateUserById(int id, String phone, String wx_id, String username, String password) {
        return userDao.save(new User(id, phone, wx_id, username, password));
    }

    @Override
    public User InsertUser(int id, String phone, String wx_id, String username, String password) {
        return userDao.save(new User(id, phone, wx_id, username, password));
    }

    @Override
    public boolean isUserExistent(String username) {
        return userDao.findUserByUsername(username) != null;
    }

    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

}
