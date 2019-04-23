package dachuang.industry.supervision.backend.platform.data;

import dachuang.industry.supervision.backend.platform.data.dao.AdminDao;
import dachuang.industry.supervision.backend.platform.dataservice.AdminDataAccessService;
import dachuang.industry.supervision.backend.platform.entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminDataAccessServiceImpl implements AdminDataAccessService {
    private final AdminDao adminDao;
    @Autowired
    public AdminDataAccessServiceImpl(AdminDao adminDao){
        this.adminDao = adminDao;
    }

    @Override
    public Admin GetAdminById(int id) {
        return adminDao.findById(id).orElse(null);
    }



    @Override
    public Admin UpdateAdminById(int id, String phone, String wx_id, String username, String password) {
        return adminDao.save(new Admin(id, phone, wx_id, username, password));
    }

    @Override
    public Admin InsertAdminById(int id, String phone, String wx_id, String username, String password) {
        return adminDao.save(new Admin(id, phone, wx_id, username, password));
    }
}
