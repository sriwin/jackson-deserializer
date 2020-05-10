package com.sriwin.jackson.xml.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.sriwin.jackson.xml.model.EmployeeReqModel;
import com.sriwin.jackson.xml.model.XMLConditionModel;
import com.sriwin.jackson.xml.model.XMLRootModel;
import com.sriwin.jackson.xml.model.XMLRuleModel;
import com.sriwin.jackson.xml.utils.JavaReflectionUtil;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class DeserializeTest {
  public static void main(String[] args) {
    try {
      ObjectMapper objectMapper = new XmlMapper();

      String userDir = System.getProperty("user.dir");
      Path path = Paths.get(userDir + File.separator + "rules.xml");
      byte[] fileBytes = Files.readAllBytes(path);
      String xmlContent = StringUtils.toEncodedString(fileBytes, StandardCharsets.UTF_8);

      XMLRootModel xmlRootModel = objectMapper.readValue(xmlContent, XMLRootModel.class);
      System.out.println(xmlRootModel);

      EmployeeReqModel employeeReqModel = EmployeeReqModel.builder()
          .employeeInd(1)
          .build();
      Class clazz = employeeReqModel.getClass();

      List<XMLRuleModel> rulesList = xmlRootModel.getXmlRulesModel().getRulesList();
      for (XMLRuleModel xmlRuleModel : rulesList) {
        String ruleId = xmlRuleModel.getId();

        List<XMLConditionModel> conditionList = xmlRuleModel.getXmlConditions().getConditionList();
        for (XMLConditionModel xmlConditionModel : conditionList) {
          String xmlNextFieldCheck = xmlConditionModel.getNextFieldCheck();
          String xmlFieldValue = xmlConditionModel.getFieldValue();
          String xmlFieldCheck = xmlConditionModel.getFieldCheck();
          String xmlFieldName = xmlConditionModel.getFieldName();

          String dataFieldValue = JavaReflectionUtil.getFieldValue(employeeReqModel, xmlFieldName);
          System.out.println("rulesReqModel Field Value = " + dataFieldValue);

          boolean evaluateFlag = compareFieldData(xmlFieldValue, dataFieldValue, xmlFieldCheck);
          if (evaluateFlag) {
            System.out.println("Rule Id : " + ruleId);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  private static boolean compareFieldData(String xmlFieldValue, String dataFieldValue, String fieldCondition) {
    if (fieldCondition.equals("eq")) {
      return xmlFieldValue.equalsIgnoreCase(dataFieldValue);
    }
    return false;
  }
}