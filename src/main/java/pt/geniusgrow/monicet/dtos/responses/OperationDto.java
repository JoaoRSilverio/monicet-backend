package pt.geniusgrow.monicet.dtos.responses;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OperationDto {
    private String errorMessage;
    private Boolean success;

    public OperationDto(Boolean success) {
        this.errorMessage = "";
        this.success = success;
    }

    public OperationDto(String errorMessage, Boolean success) {
        this.errorMessage = errorMessage;
        this.success = success;
    }
}
