package com.example;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailParser {

    public static void main(String[] args) {
        String subject = "Leave Application from Deepak Shingan [KRIS0013]";
        String messageBody = "Hi,\n" +
                "\n" +
                "Deepak Shingan [KRIS0013] leave has been accepted by admin user HR.   \n" +
                "Following are the leave details:\n" +
                "\n" +
                "Leave type: Work From Home\n" +
                "From Date: 11 Dec 2024   \n" +
                "To Date: 11 Dec 2024\n" +
                "Number of days: 1.0\n" +
                "Reason: Have to go for medical tests \n" +
                "Leave Balance: -4.0\n" +
                "From Session: Session1\n" +
                "To Session: Session2\n";

        Map<String, Object> obj = parseEmail(subject, messageBody);
        System.out.println(" Object : " + obj);

    }


    /* For Client Krista Internal Mail Format
    * */
    public static Map<String , Object> parseEmail(String subject, String messageBody) {
        Map<String, Object> detailsMap = new HashMap<>();

        // Extract name and ID from the subject
        Pattern subjectPattern = Pattern.compile("(?:Leave Application from|Leave application of) (.+?) \\[(.+?)\\]");
        Matcher subjectMatcher = subjectPattern.matcher(subject);
        if (subjectMatcher.find()) {
            detailsMap.put("Name", subjectMatcher.group(1));
            detailsMap.put("ID", subjectMatcher.group(2));
        }

        // Extract details from the body
        detailsMap.put("Leave Type", extractDetail(messageBody, "Leave type: (.*?)$"));
        detailsMap.put("From Date", extractDetail(messageBody, "From Date: (.*?)$"));
        detailsMap.put("To Date", extractDetail(messageBody, "To Date: (.*?)$"));
        detailsMap.put("Number of Days", extractDetail(messageBody, "Number of days: (.*?)$"));
        detailsMap.put("Reason", extractDetail(messageBody, "Reason: (.*?)$"));
        detailsMap.put("From Session", extractDetail(messageBody, "From Session: (.*?)$"));
        detailsMap.put("To Session", extractDetail(messageBody, "To Session: (.*?)$"));

        return detailsMap;
    }

    private static String extractDetail(String body, String regex) {
        Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        Matcher matcher = pattern.matcher(body);
        if (matcher.find()) {
            return matcher.group(1).trim();
        }
        return null;
    }

}