package dachuang.industry.supervision.backend.platform.parameter.admin;

import lombok.Data;

@Data
public class UpdateAdminByIdParameter {
    int id;
    String wx_id;
    String phone;
}
