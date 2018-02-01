package org.identifiers.org.cloud.ws.register.models;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * Project: register
 * Package: org.identifiers.org.cloud.ws.register.models
 * Timestamp: 2018-02-01 9:28
 * ---
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PrefixValidatorTests {

    class TestDataUseCase {
        PrefixRegistrationRequestValidator validator;
        RegisterApiRequestRegisterPrefix request;
        String testDescription;

        TestDataUseCase setValidator(PrefixRegistrationRequestValidator validator) {
            this.validator = validator;
            return this;
        }

        TestDataUseCase setRequest(RegisterApiRequestRegisterPrefix request) {
            this.request = request;
            return this;
        }

        TestDataUseCase setTestDescription(String testDescription) {
            this.testDescription = testDescription;
            return this;
        }
    }

    @Autowired
    private PrefixRegistrationRequestValidatorPreferredPrefix prefixValidator;

    @Test
    public void testValidUseCases() {
        getValidTestCasesData().parallelStream().forEach(testDataUseCase -> assertThat(testDataUseCase.testDescription, testDataUseCase.validator.validate(testDataUseCase.request), is(true)));
    }

    @Test
    public void testInvalidUseCases() {

    }

    private List<TestDataUseCase> getValidTestCasesData() {
        // TODO
        return Arrays.asList(
                new TestDataUseCase()
                        .setTestDescription("Valid prefix accepted")
                        .setRequest(new RegisterApiRequestRegisterPrefix().setPreferredPrefix("mynewprefix"))
                        .setValidator(prefixValidator),
                new TestDataUseCase()
                        .setTestDescription("Another valid prefix accepted")
                        .setRequest(new RegisterApiRequestRegisterPrefix().setPreferredPrefix("myotherprefix"))
                        .setValidator(prefixValidator)
        );
    }

    private List<TestDataUseCase> getNotValidTestCasesData() {
        // TODO
        return Arrays.asList(
                new TestDataUseCase()
                        .setTestDescription("Valid prefix accepted")
                        .setRequest(new RegisterApiRequestRegisterPrefix().setPreferredPrefix("chebi"))
                        .setValidator(prefixValidator),
                new TestDataUseCase()
                        .setTestDescription("Another valid prefix accepted")
                        .setRequest(new RegisterApiRequestRegisterPrefix().setPreferredPrefix("pdb"))
                        .setValidator(prefixValidator)
        );
    }

}
