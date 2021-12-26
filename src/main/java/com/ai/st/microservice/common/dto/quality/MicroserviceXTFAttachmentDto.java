package com.ai.st.microservice.common.dto.quality;

import java.util.Date;

public final class MicroserviceXTFAttachmentDto {

    private Long attachmentId;
    private String type;
    private XTF data;
    private Date attachmentDate;
    private String observations;
    private Long deliveryProductId;

    public MicroserviceXTFAttachmentDto() {

    }

    public Long getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(Long attachmentId) {
        this.attachmentId = attachmentId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public XTF getData() {
        return data;
    }

    public void setData(XTF data) {
        this.data = data;
    }

    public Date getAttachmentDate() {
        return attachmentDate;
    }

    public void setAttachmentDate(Date attachmentDate) {
        this.attachmentDate = attachmentDate;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public Long getDeliveryProductId() {
        return deliveryProductId;
    }

    public void setDeliveryProductId(Long deliveryProductId) {
        this.deliveryProductId = deliveryProductId;
    }

    public static class XTF {

        private Boolean isValid;
        private String status;
        private String version;
        private boolean hasReportRevision;

        public Boolean getValid() {
            return isValid;
        }

        public void setValid(Boolean valid) {
            isValid = valid;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public boolean isHasReportRevision() {
            return hasReportRevision;
        }

        public void setHasReportRevision(boolean hasReportRevision) {
            this.hasReportRevision = hasReportRevision;
        }
    }


}
