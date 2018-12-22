package com.example.daggerdemo;

import javax.inject.Scope;
import java.lang.annotation.*;

@Scope
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityScope {
}
