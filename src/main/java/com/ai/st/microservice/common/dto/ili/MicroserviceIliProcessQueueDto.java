package com.ai.st.microservice.common.dto.ili;

import java.io.Serializable;

public class MicroserviceIliProcessQueueDto implements Serializable {

    public static final Long VALIDATOR = (long) 1;
    public static final Long INTEGRATOR = (long) 2;
    public static final Long EXPORT = (long) 3;
    public static final Long IMPORT_REFERENCE = (long) 4;
    public static final Long EXPORT_REFERENCE = (long) 5;
    public static final Long IMPORT_SINIC = (long) 6;

    private Long type;
    private MicroserviceIlivalidatorBackgroundDto ilivalidatorData;
    private MicroserviceIli2pgIntegrationCadastreRegistrationWithoutFilesDto integrationData;
    private MicroserviceIli2pgExportDto exportData;
    private MicroserviceIli2pgImportReferenceDto importReferenceData;
    private MicroserviceIli2pgExportReferenceDto exportReferenceData;
    private MicroserviceIli2pgImportSinicDto importSinicDto;

    public MicroserviceIliProcessQueueDto() {

    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public MicroserviceIlivalidatorBackgroundDto getIlivalidatorData() {
        return ilivalidatorData;
    }

    public void setIlivalidatorData(MicroserviceIlivalidatorBackgroundDto ilivalidatorData) {
        this.ilivalidatorData = ilivalidatorData;
    }

    public MicroserviceIli2pgIntegrationCadastreRegistrationWithoutFilesDto getIntegrationData() {
        return integrationData;
    }

    public void setIntegrationData(MicroserviceIli2pgIntegrationCadastreRegistrationWithoutFilesDto integrationData) {
        this.integrationData = integrationData;
    }

    public MicroserviceIli2pgExportDto getExportData() {
        return exportData;
    }

    public void setExportData(MicroserviceIli2pgExportDto exportData) {
        this.exportData = exportData;
    }

    public MicroserviceIli2pgImportReferenceDto getImportReferenceData() {
        return importReferenceData;
    }

    public void setImportReferenceData(MicroserviceIli2pgImportReferenceDto importReferenceData) {
        this.importReferenceData = importReferenceData;
    }

    public MicroserviceIli2pgExportReferenceDto getExportReferenceData() {
        return exportReferenceData;
    }

    public void setExportReferenceData(MicroserviceIli2pgExportReferenceDto exportReferenceData) {
        this.exportReferenceData = exportReferenceData;
    }

    public MicroserviceIli2pgImportSinicDto getImportSinicDto() {
        return importSinicDto;
    }

    public void setImportSinicDto(MicroserviceIli2pgImportSinicDto importSinicDto) {
        this.importSinicDto = importSinicDto;
    }
}
