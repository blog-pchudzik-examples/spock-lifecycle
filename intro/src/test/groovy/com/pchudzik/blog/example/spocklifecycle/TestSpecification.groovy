package com.pchudzik.blog.example.spocklifecycle

import com.pchudzik.blog.example.spocklifecycle.extension.SampleAnnotation
import spock.lang.Specification

@SampleAnnotation
class TestSpecification extends Specification {
    @SampleAnnotation
    def object = new Object()

    def setupSpec() {
        println "setup spec"
    }
    def cleanupSpec() {
        println "cleanup spec"
    }

    @SampleAnnotation
    def setup() {
        println "setup"
    }

    def cleanup() {
        println "cleanup"
    }

    @SampleAnnotation
    def "some test 1"() {
        given:
        println "given block some test 1"

        when:
        println "when block some test 1"

        then:
        println "then block some test 1"
    }

    @SampleAnnotation
    def "some test 2"() {
        given:
        println "given block some test 2"

        when:
        println "when block some test 2"

        then:
        println "then block some test 2"
    }
}