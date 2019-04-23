package dachuang.industry.supervision.backend.platform.data.dao;

import dachuang.industry.supervision.backend.platform.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {
    User findUserByUsername(String username);
}
