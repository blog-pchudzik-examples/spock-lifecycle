package com.pchudzik.blog.example.spocklifecycle.extension

import org.spockframework.runtime.extension.ExtensionAnnotation

import java.lang.annotation.ElementType
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.lang.annotation.Target

@Retention(RetentionPolicy.RUNTIME)
@Target([ElementType.TYPE, ElementType.FIELD, ElementType.METHOD])
@ExtensionAnnotation(AnnotationExtension.class)
@interface SampleAnnotation {

}