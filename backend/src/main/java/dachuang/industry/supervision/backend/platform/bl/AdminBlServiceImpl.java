package dachuang.industry.supervision.backend.platform.bl;

import dachuang.industry.supervision.backend.platform.parameter.admin.InsertAdminParameter;
import dachuang.industry.supervision.backend.platform.parameter.admin.UpdateAdminByIdParameter;
import dachuang.industry.supervision.backend.platform.response.admin.InsertAdminResponse;
import dachuang.industry.supervision.backend.platform.response.admin.UpdateAdminByIdResponse;
import dachuang.industry.supervision.backend.platform.blservice.AdminBlService;
import dachuang.industry.supervision.backend.platform.dataservice.AdminDataAccessService;
import dachuang.industry.supervision.backend.platform.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminBlServiceImpl implements AdminBlService {
    private final AdminDataAccessService adminDataAccessService;

    @Autowired
    public AdminBlServiceImpl(AdminDataAccessService adminDataAccessService){
        this.adminDataAccessService = adminDataAccessService;
    }
    @Override
    public UpdateAdminByIdResponse updateAdminById(UpdateAdminByIdParameter parameter) {
        Admin res = adminDataAccessService.UpdateAdminById(parameter.getId(), parameter.getWx_id(), parameter.getPhone());
        return new UpdateAdminByIdResponse(res.getId(), res.getPhone(), res.getWx_id());
    }


    @Override
    public InsertAdminResponse insertAdmin(InsertAdminParameter parameter) {
        Admin res = adminDataAccessService.InsertAdminById(parameter.getId(), parameter.getWx_id(), parameter.getPhone());
        return new InsertAdminResponse(res);
    }
}
