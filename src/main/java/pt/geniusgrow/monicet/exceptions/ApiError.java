package pt.geniusgrow.monicet.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ApiError {
    private String message;
    private List<String> errors = new ArrayList<String>();

}
