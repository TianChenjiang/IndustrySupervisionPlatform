package dachuang.industry.supervision.backend.platform.dataservice;

import dachuang.industry.supervision.backend.platform.entity.User;

public interface UserDataAccessService {
    User GetUserById(int id);
    User UpdateUserById(int id, String phone, String wx_id, String username, String password);
    User InsertUser(int id, String phone, String wx_id, String username, String password);
    boolean isUserExistent(String username);
    void saveUser(User user);
}
