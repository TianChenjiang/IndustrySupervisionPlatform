package dachuang.industry.supervision.backend.platform.blservice;

import dachuang.industry.supervision.backend.platform.parameter.production.UpdateProductionByIdParameter;
import dachuang.industry.supervision.backend.platform.response.production.GetProductionByIdResponse;
import dachuang.industry.supervision.backend.platform.response.production.UpdateProductionByIdResponse;

public interface ProductionBlService {
    GetProductionByIdResponse getProductionById(int id);
    UpdateProductionByIdResponse updateProductionById(UpdateProductionByIdParameter parameter);
}
