package com.example.orderAI.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TipoPagamentoValidator implements ConstraintValidator<TipoPagamento, String>{
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context){
        return value.equals("Débito") || value.equals("Crédito") || value.equals("PIX");
    }
}
