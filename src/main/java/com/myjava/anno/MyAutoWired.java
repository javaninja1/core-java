package com.myjava.anno;

import java.lang.annotation.*;

@Target (ElementType.FIELD)
@Retention (value = RetentionPolicy.RUNTIME)
public @interface MyAutoWired {
}
