package com.sriwin.jackson.xml.model;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@JacksonXmlRootElement(localName = "Collections-Strategies")
public class XMLRootModel {

  @JacksonXmlProperty(localName = "Rules")
  private XMLRulesModel xmlRulesModel;
}