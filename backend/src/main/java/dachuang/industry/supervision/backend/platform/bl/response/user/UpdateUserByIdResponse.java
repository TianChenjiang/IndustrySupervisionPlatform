package dachuang.industry.supervision.backend.platform.bl.response.user;

import lombok.Data;

@Data
public class UpdateUserByIdResponse {
    private int id;
    public UpdateUserByIdResponse(int id){
        this.id = id;
    }
}
