package com.adam.config;

import java.util.List;

public class Rule {
    private String rule;
    private String fileName;
    private List<String> fileType;

    public String getRule() {
        return rule;
    }

    public void setRule(String rule) {
        this.rule = rule;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public List<String> getFileType() {
        return fileType;
    }

    public void setFileType(List<String> fileType) {
        this.fileType = fileType;
    }

    @Override
    public String toString() {
        return "Rule{" +
                "rule='" + rule + '\'' +
                ", fileName='" + fileName + '\'' +
                ", fileType=" + fileType +
                '}';
    }
}
