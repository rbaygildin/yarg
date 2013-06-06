/**
 *
 * @author degtyarjov
 * @version $Id$
 */
package com.haulmont.newreport.structure.impl;

import com.haulmont.newreport.formatters.CustomReport;
import com.haulmont.newreport.structure.ReportOutputType;
import com.haulmont.newreport.structure.ReportTemplate;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReportTemplateImpl implements ReportTemplate {
    protected String code = ReportTemplate.DEFAULT_TEMPLATE_CODE;
    protected String documentName;
    protected String documentPath;
    protected byte[] documentContent;
    protected ReportOutputType reportOutputType;
    protected String outputNamePattern;

    protected CustomReport customReport;
    protected boolean custom = false;

    ReportTemplateImpl() {
    }

    public ReportTemplateImpl(String code, String documentName, String documentPath, ReportOutputType reportOutputType) throws IOException {
        this.code = code;
        this.documentName = documentName;
        this.documentPath = documentPath;
        this.documentContent = FileUtils.readFileToByteArray(new File(documentPath));
        this.reportOutputType = reportOutputType;
    }

    public ReportTemplateImpl(String code, String documentName, String documentPath, InputStream documentContent, ReportOutputType reportOutputType) throws IOException {
        this.code = code;
        this.documentName = documentName;
        this.documentPath = documentPath;
        this.documentContent = IOUtils.toByteArray(documentContent);
        this.reportOutputType = reportOutputType;
    }

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getDocumentName() {
        return documentName;
    }

    @Override
    public InputStream getDocumentContent() {
        return new ByteArrayInputStream(documentContent);
    }

    @Override
    public ReportOutputType getOutputType() {
        return reportOutputType;
    }

    public String getDocumentPath() {
        return documentPath;
    }

    public String getOutputNamePattern() {
        return outputNamePattern;
    }

    @Override
    public boolean isCustom() {
        return custom;
    }

    @Override
    public CustomReport getCustomReport() {
        return customReport;
    }
}
