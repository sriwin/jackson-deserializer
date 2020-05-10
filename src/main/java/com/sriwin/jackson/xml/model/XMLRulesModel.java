package com.sriwin.jackson.xml.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class XMLRulesModel {
  @JacksonXmlProperty(localName = "Rule")
  @JacksonXmlElementWrapper(useWrapping = false)
  private List<XMLRuleModel> rulesList = new ArrayList<>();
}