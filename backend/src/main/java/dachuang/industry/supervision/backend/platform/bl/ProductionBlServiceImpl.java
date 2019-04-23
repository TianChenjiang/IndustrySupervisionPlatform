package dachuang.industry.supervision.backend.platform.bl;

import dachuang.industry.supervision.backend.platform.parameter.production.UpdateProductionByIdParameter;
import dachuang.industry.supervision.backend.platform.response.production.GetProductionByIdResponse;
import dachuang.industry.supervision.backend.platform.response.production.UpdateProductionByIdResponse;
import dachuang.industry.supervision.backend.platform.blservice.ProductionBlService;
import dachuang.industry.supervision.backend.platform.dataservice.ProductionDataAccessService;
import dachuang.industry.supervision.backend.platform.entity.Production;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductionBlServiceImpl implements ProductionBlService {
    private final ProductionDataAccessService productionDataAccessService;

    @Autowired
    public ProductionBlServiceImpl(ProductionDataAccessService productionDataAccessService){
        this.productionDataAccessService = productionDataAccessService;
    }
    @Override
    public GetProductionByIdResponse getProductionById(int id) {
        Production res = productionDataAccessService.GetProductionById(id);
        return new GetProductionByIdResponse(res);
    }

    @Override
    public UpdateProductionByIdResponse updateProductionById(UpdateProductionByIdParameter parameter) {
        Production res = productionDataAccessService.UpdateProductionById(parameter.getId(), parameter.getDate(), parameter.getData());
        return new UpdateProductionByIdResponse(res.getId(), res.getDate(), res.getData());
    }
}
