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
public class XMLRuleModel {
  @JacksonXmlProperty(localName = "Conditions")
  private XMLConditionsModel xmlConditions;

  @JacksonXmlProperty(localName = "id", isAttribute = true)
  private String id;

  @JacksonXmlProperty(localName = "scenario-id", isAttribute = true)
  private String scenarioId;
}