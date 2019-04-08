package dachuang.industry.supervision.backend.platform.bl.response.admin;

import lombok.Data;

@Data
public class UpdateAdminByIdResponse {
    private int id;
    public UpdateAdminByIdResponse(int id){
        this.id = id;
    }
}
