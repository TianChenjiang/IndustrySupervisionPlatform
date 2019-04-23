package dachuang.industry.supervision.backend.platform.blservice;

import dachuang.industry.supervision.backend.platform.parameter.admin.InsertAdminParameter;
import dachuang.industry.supervision.backend.platform.parameter.admin.UpdateAdminByIdParameter;
import dachuang.industry.supervision.backend.platform.response.admin.InsertAdminResponse;
import dachuang.industry.supervision.backend.platform.response.admin.UpdateAdminByIdResponse;

public interface AdminBlService {
    UpdateAdminByIdResponse updateAdminById(UpdateAdminByIdParameter parameter);
    InsertAdminResponse insertAdmin(InsertAdminParameter parameter);
}
