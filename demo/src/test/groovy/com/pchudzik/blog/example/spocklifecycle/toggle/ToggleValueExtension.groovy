package com.pchudzik.blog.example.spocklifecycle.toggle

import com.pchudzik.blog.example.spocklifecycle.demo.Toggler
import org.spockframework.runtime.extension.AbstractAnnotationDrivenExtension
import org.spockframework.runtime.model.FeatureInfo

class ToggleValueExtension extends AbstractAnnotationDrivenExtension<ToggleValue> {
    @Override
    void visitFeatureAnnotation(ToggleValue annotation, FeatureInfo feature) {
        print("toggle ${annotation.toggle()} set to ${annotation.value()}")
        feature.addInterceptor({invocation ->
            final originalValue = Toggler.instance.getValue(annotation.toggle())
            Toggler.instance.setValue(annotation.toggle(), annotation.value())
            invocation.proceed()
            Toggler.instance.setValue(annotation.toggle(), originalValue)
        })
    }
}

