package com.ai.st.microservice.common.dto.tasks;

import java.io.Serializable;
import java.util.Date;

public class MicroserviceTaskMemberDto implements Serializable {

    private static final long serialVersionUID = 7581006574042957605L;

    private Long id;
    private Long memberCode;
    private Date createdAt;

    public MicroserviceTaskMemberDto() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMemberCode() {
        return memberCode;
    }

    public void setMemberCode(Long memberCode) {
        this.memberCode = memberCode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
