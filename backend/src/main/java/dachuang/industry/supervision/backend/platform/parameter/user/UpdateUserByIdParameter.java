package dachuang.industry.supervision.backend.platform.parameter.user;

import lombok.Data;

@Data
public class UpdateUserByIdParameter {
    int id;
    String wx_id;
    String phone;
    String username;
    String password;
}
