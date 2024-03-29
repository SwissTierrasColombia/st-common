package com.ai.st.microservice.common.dto.ili;

import java.io.Serializable;

public final class MicroserviceIli2pgImportSinicDto implements Serializable {

    private String databaseHost;
    private String databasePort;
    private String databaseSchema;
    private String databaseUsername;
    private String databasePassword;
    private String databaseName;
    private String pathXTF;
    private String versionModel;
    private Long conceptId;
    private String reference;
    private int totalFiles;
    private int currentFile;

    public String getDatabaseHost() {
        return databaseHost;
    }

    public void setDatabaseHost(String databaseHost) {
        this.databaseHost = databaseHost;
    }

    public String getDatabasePort() {
        return databasePort;
    }

    public void setDatabasePort(String databasePort) {
        this.databasePort = databasePort;
    }

    public String getDatabaseSchema() {
        return databaseSchema;
    }

    public void setDatabaseSchema(String databaseSchema) {
        this.databaseSchema = databaseSchema;
    }

    public String getDatabaseUsername() {
        return databaseUsername;
    }

    public void setDatabaseUsername(String databaseUsername) {
        this.databaseUsername = databaseUsername;
    }

    public String getDatabasePassword() {
        return databasePassword;
    }

    public void setDatabasePassword(String databasePassword) {
        this.databasePassword = databasePassword;
    }

    public String getDatabaseName() {
        return databaseName;
    }

    public void setDatabaseName(String databaseName) {
        this.databaseName = databaseName;
    }

    public String getPathXTF() {
        return pathXTF;
    }

    public void setPathXTF(String pathXTF) {
        this.pathXTF = pathXTF;
    }

    public String getVersionModel() {
        return versionModel;
    }

    public void setVersionModel(String versionModel) {
        this.versionModel = versionModel;
    }

    public Long getConceptId() {
        return conceptId;
    }

    public void setConceptId(Long conceptId) {
        this.conceptId = conceptId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getTotalFiles() {
        return totalFiles;
    }

    public void setTotalFiles(int totalFiles) {
        this.totalFiles = totalFiles;
    }

    public int getCurrentFile() {
        return currentFile;
    }

    public void setCurrentFile(int currentFile) {
        this.currentFile = currentFile;
    }
}
