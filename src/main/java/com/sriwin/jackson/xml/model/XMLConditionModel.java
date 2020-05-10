package com.sriwin.jackson.xml.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class XMLConditionModel {
  @JacksonXmlProperty(localName = "fieldName", isAttribute = true)
  private String fieldName;

  @JacksonXmlProperty(localName = "fieldValue", isAttribute = true)
  private String fieldValue;

  @JacksonXmlProperty(localName = "fieldCheck", isAttribute = true)
  private String fieldCheck;

  @JacksonXmlProperty(localName = "nextFieldCheck", isAttribute = true)
  private String nextFieldCheck;
}