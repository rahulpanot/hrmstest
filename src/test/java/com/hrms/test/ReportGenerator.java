package com.hrms.test;


import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;
import net.masterthought.cucumber.Reportable;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * An example showing how to generate html report summary from the json results thats been produced by
 * the Cucumber runner. This uses the one of the free html cucumber-reporting tool (https://github.com/damianszczepanik/cucumber-reporting)
 */
public class ReportGenerator {


    public static void main(String[] args) {
        File reportOutputDirectory = new File("D:\\Development\\testing\\hrmstest\\target\\cucumber");
        List<String> jsonFiles = new ArrayList<>();
        jsonFiles.add("D:\\Development\\testing\\hrmstest\\target\\cucumber\\json.json");
        String buildNumber = "2";
        String projectName = "cucumberProject";
        boolean runWithJenkins = false;
        boolean parallelTesting = false;

        Configuration configuration = new Configuration(reportOutputDirectory, projectName);
        // optional configuration
        configuration.setParallelTesting(parallelTesting);
        configuration.setRunWithJenkins(runWithJenkins);
        configuration.setBuildNumber(buildNumber);

        ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, configuration);
        Reportable result = reportBuilder.generateReports();

    }
}
