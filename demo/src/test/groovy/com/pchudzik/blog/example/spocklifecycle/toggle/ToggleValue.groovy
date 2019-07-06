package com.pchudzik.blog.example.spocklifecycle.toggle

import org.spockframework.runtime.extension.ExtensionAnnotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@ExtensionAnnotation(ToggleValueExtension.class)
@interface ToggleValue {
    String toggle();

    boolean value();
}