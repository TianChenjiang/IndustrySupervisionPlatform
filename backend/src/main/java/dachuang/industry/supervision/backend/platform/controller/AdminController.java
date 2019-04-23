package dachuang.industry.supervision.backend.platform.controller;

import dachuang.industry.supervision.backend.platform.parameter.admin.InsertAdminParameter;
import dachuang.industry.supervision.backend.platform.parameter.admin.UpdateAdminByIdParameter;
import dachuang.industry.supervision.backend.platform.response.admin.InsertAdminResponse;
import dachuang.industry.supervision.backend.platform.response.admin.UpdateAdminByIdResponse;
import dachuang.industry.supervision.backend.platform.blservice.AdminBlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AdminController {
    private AdminBlService adminBlService;
    @Autowired
    public AdminController(AdminBlService adminBlService){
        this.adminBlService = adminBlService;
    }

    @RequestMapping(value = "InsertAdmin", method = RequestMethod.POST)
    @ResponseBody
    public InsertAdminResponse insertAdmin(@RequestBody InsertAdminParameter parameter){
        return adminBlService.insertAdmin(parameter);
    }

    @RequestMapping(value = "UpdateAdminById", method = RequestMethod.POST)
    @ResponseBody
    public UpdateAdminByIdResponse updateAdminById(@RequestBody UpdateAdminByIdParameter parameter){
        return adminBlService.updateAdminById(parameter);
    }

}
