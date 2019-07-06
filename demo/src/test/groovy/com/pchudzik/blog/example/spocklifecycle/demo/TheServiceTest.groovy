package com.pchudzik.blog.example.spocklifecycle.demo

import com.pchudzik.blog.example.spocklifecycle.toggle.ToggleValue
import spock.lang.Specification

class TheServiceTest extends Specification {
    private def service = new TheService(Toggler.instance)

    @ToggleValue(toggle = Toggler.EXTRA_PROCESSING, value = false)
    def "toggle disabled"() {
        when:
        final result = service.doProcess([1, 2])

        then:
        result == [2, 3]
    }

    @ToggleValue(toggle = Toggler.EXTRA_PROCESSING, value = true)
    def "toggle enabled"() {
        when:
        final result = service.doProcess([1, 2])

        then:
        result == [-2, -3]
    }
}
