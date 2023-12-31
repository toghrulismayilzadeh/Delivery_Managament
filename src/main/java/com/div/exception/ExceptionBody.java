package com.div.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionBody {
    private List<String> globalExceptions;
    private List<FieldException> fieldExceptions;
}
