package dachuang.industry.supervision.backend.platform.bl.response.production;

import lombok.Data;

@Data
public class UpdateProductionByIdResponse {
    private int id;
    public UpdateProductionByIdResponse(int id){
        this.id = id;
    }
}
