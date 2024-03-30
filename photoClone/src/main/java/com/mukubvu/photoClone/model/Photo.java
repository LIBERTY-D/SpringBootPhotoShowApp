package com.mukubvu.photoClone.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Table(name = "PHOTOS")
public class Photo {

    @Id
    private Integer ID;


    private  String FILENAME;

    private String CONTENTTYPE;

    @JsonIgnore
    private  byte[] DATA;
    @NotEmpty()
    public Photo() {
    }

    public String getContentType() {
        return CONTENTTYPE;
    }

    public void setContentType(String contentType) {
        this.CONTENTTYPE = contentType;
    }

    public Integer getId() {
        return ID;
    }

    public void setId(Integer id) {
        this.ID = id;
    }

    public String getFileName() {
        return FILENAME;
    }

    public void setFileName(String fileName) {
        this.FILENAME = fileName;
    }

    public byte[] getData() {
        return DATA;
    }

    public void setData(byte[] data) {
        this.DATA = data;
    }
}
