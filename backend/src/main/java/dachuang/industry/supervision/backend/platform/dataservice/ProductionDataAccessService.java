package dachuang.industry.supervision.backend.platform.dataservice;

import dachuang.industry.supervision.backend.platform.entity.Production;

public interface ProductionDataAccessService {
    Production GetProductionById(int id);
    Production UpdateProductionById(int id, int date, String data);
    Production InsertProductionById(int id, int date, String data);//TODO
}
