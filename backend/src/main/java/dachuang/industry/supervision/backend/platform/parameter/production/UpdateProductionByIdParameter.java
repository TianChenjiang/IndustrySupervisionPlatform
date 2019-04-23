package dachuang.industry.supervision.backend.platform.parameter.production;

import lombok.Data;

@Data
public class UpdateProductionByIdParameter {
    int id;
    int date;
    String data;
}
