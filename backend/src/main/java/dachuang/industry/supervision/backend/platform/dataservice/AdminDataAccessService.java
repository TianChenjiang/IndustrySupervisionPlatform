package dachuang.industry.supervision.backend.platform.dataservice;

import dachuang.industry.supervision.backend.platform.entity.Admin;

public interface AdminDataAccessService {
    Admin GetAdminById(int id);
    Admin UpdateAdminById(int id, String phone, String wx_id, String username, String password);
    Admin InsertAdminById(int id, String phone, String wx_id, String username, String password);
}
