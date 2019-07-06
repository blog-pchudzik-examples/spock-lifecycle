package com.pchudzik.blog.example.spocklifecycle.extension


import org.spockframework.runtime.extension.IAnnotationDrivenExtension
import org.spockframework.runtime.extension.IMethodInterceptor
import org.spockframework.runtime.extension.IMethodInvocation
import org.spockframework.runtime.model.FeatureInfo
import org.spockframework.runtime.model.FieldInfo
import org.spockframework.runtime.model.MethodInfo
import org.spockframework.runtime.model.SpecInfo

class AnnotationExtension implements IAnnotationDrivenExtension<SampleAnnotation> {
    @Override
    void visitSpecAnnotation(SampleAnnotation annotation, SpecInfo spec) {
        println("visitSpecAnnotation")
    }

    @Override
    void visitFeatureAnnotation(SampleAnnotation annotation, FeatureInfo feature) {
        println "visitFeatureAnnotation"

        feature.addInterceptor(new PrintingMethodInterceptor(msg: "feature interceptor"))
        feature.addIterationInterceptor(new PrintingMethodInterceptor(msg: "iteration interceptor"))
    }

    @Override
    void visitFixtureAnnotation(SampleAnnotation annotation, MethodInfo fixtureMethod) {
        println "visitFixtureAnnotation"

        fixtureMethod.addInterceptor(new PrintingMethodInterceptor(msg: "fixture interceptor"))
    }

    @Override
    void visitFieldAnnotation(SampleAnnotation annotation, FieldInfo field) {
        println "visitFieldAnnotation"
    }

    @Override
    void visitSpec(SpecInfo spec) {
        println "visitSpec"

        spec.addInitializerInterceptor(new PrintingMethodInterceptor(msg: "initializer interceptor"))

        spec.addSetupInterceptor(new PrintingMethodInterceptor(msg: "setup interceptor"))
        spec.addCleanupInterceptor(new PrintingMethodInterceptor(msg: "cleanup interceptor"))
        spec.addSetupSpecInterceptor(new PrintingMethodInterceptor(msg: "setup spec interceptor"))
        spec.addCleanupSpecInterceptor(new PrintingMethodInterceptor(msg: "cleanup spec interceptor"))

        spec.addInterceptor(new PrintingMethodInterceptor(msg: "test interceptor"))
    }

    private static class PrintingMethodInterceptor implements IMethodInterceptor {
        String msg

        @Override
        void intercept(IMethodInvocation invocation) throws Throwable {
            println "  Starting ${msg}"
            try {
                invocation.proceed()
            } finally {
                println "  Finish ${msg}"
            }
        }
    }
}
