package dachuang.industry.supervision.backend.platform.bl.parameter.user;

import lombok.Data;

@Data
public class InsertUserParameter {
    int id;
    String wx_id;
    String phone;
}
