package dachuang.industry.supervision.backend.platform.response;

import lombok.Data;

@Data
public class WrongResponse extends Response{
    private int infoCode;
    private String description;

    public WrongResponse(int infoCode, String description) {
        this.infoCode = infoCode;
        this.description = description;
    }
}
