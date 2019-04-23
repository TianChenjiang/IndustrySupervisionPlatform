package dachuang.industry.supervision.backend.platform.controller;

import dachuang.industry.supervision.backend.platform.parameter.production.UpdateProductionByIdParameter;
import dachuang.industry.supervision.backend.platform.response.production.GetProductionByIdResponse;
import dachuang.industry.supervision.backend.platform.response.production.UpdateProductionByIdResponse;
import dachuang.industry.supervision.backend.platform.blservice.ProductionBlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductionController {
    private final ProductionBlService productionBlService;

    @Autowired
    public ProductionController(ProductionBlService productionBlService){
        this.productionBlService = productionBlService;
    }

    @RequestMapping(value = "GetProductionById", method = RequestMethod.GET)
    public GetProductionByIdResponse getProductionById(@RequestParam(name = "id", defaultValue = "0") int id){
        return productionBlService.getProductionById(id);
    }

    @RequestMapping(value = "UpdateProductionById", method = RequestMethod.POST)
    public UpdateProductionByIdResponse updateProductionById(@RequestBody UpdateProductionByIdParameter parameter){
        return productionBlService.updateProductionById(parameter);
    }

}
