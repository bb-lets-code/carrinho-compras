package br.shop.bb.annotations;

import java.lang.annotation.Target;
import java.lang.annotation.*;

// ElementType.FIELD para permitir anotações no atributo
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ID {

    
}
