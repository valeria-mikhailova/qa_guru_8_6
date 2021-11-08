package com.mikhailova.homework;

import org.junit.jupiter.api.Test;

public class AnnotatedStepTestHomeWork {

    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static String ISSUE_NAME = "Listeners NamedBy";

    @Test
    public void testGithub() {
        WebStepsHomeWork steps = new WebStepsHomeWork();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithName(ISSUE_NAME);
    }
}
