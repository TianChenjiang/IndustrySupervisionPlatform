package dachuang.industry.supervision.backend.platform.response.production;

import dachuang.industry.supervision.backend.platform.response.Response;
import dachuang.industry.supervision.backend.platform.entity.Production;
import lombok.Data;


@Data
public class GetProductionByIdResponse extends Response {
    private Production production;
    public GetProductionByIdResponse(Production production){
        this.production = production;
    }
}
