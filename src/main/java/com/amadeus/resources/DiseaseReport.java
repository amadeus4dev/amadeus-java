package com.amadeus.resources;

import com.amadeus.dutyofcare.diseases.Covid19Report;

import lombok.Getter;
import lombok.ToString;

/**
 * A DiseaseReport object as returned by the Travel Restrictions V2 API.
 * @see Covid19Report#get()
 */
@ToString
public class DiseaseReport extends Resource {
  private @Getter String type;
  private @Getter Area area;
  private @Getter SubArea[] subAreas;
  private @Getter DatedInformation summary;
  private @Getter DataSources dataSources;
  private @Getter Links[] relatedArea;
  private @Getter AreaVaccinated[] areaVaccinated;
  private @Getter DatedInformation hotspots;
  private @Getter DiseaseCases diseaseCases;
  private @Getter DiseaseInfection diseaseInfection;
  private @Getter DatedInformation diseaseRiskLevel;
  private @Getter AreaPolicy areaPolicy;
  private @Getter AreaAccessRestriction areaAccessRestriction;
  private @Getter AreaRestrictions[] areaRestrictions;

  protected DiseaseReport() {}

  @ToString
  public class Area {
    private @Getter String name;
    private @Getter String code;
    private @Getter GeoCode geoCode;
    private @Getter String areaType;

    protected Area() {}
  }

  @ToString
  public class GeoCode {
    private @Getter String latitude;
    private @Getter String longitude;

    protected GeoCode() {}
  }

  @ToString
  public class SubArea {
    private @Getter Area area;
    private @Getter DatedInformation summary;
    private @Getter DatedInformation diseaseRiskLevel;
    private @Getter Links[] relatedArea;

    protected SubArea() {}
  }

  @ToString
  public class DiseaseInfection {
    private @Getter String level;
    private @Getter String rate;
    private @Getter String infectionMapLink;
    private @Getter String trend;
    private @Getter String lastUpdate;
    private @Getter String text;

    protected DiseaseInfection() {}
  }

  @ToString
  public class DiseaseCases {
    private @Getter int active;
    private @Getter int recovered;
    private @Getter int deaths;
    private @Getter int confirmed;
    private @Getter String lastUpdate;
    private @Getter String text;

    protected DiseaseCases() {}
  }

  @ToString
  public class DataSources {
    private @Getter String covidDashboardLink;
    private @Getter String healthDepartmentSiteLink;
    private @Getter String governmentSiteLink;

    protected DataSources() {}
  }

  @ToString
  public class AreaRestrictions {
    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String restrictionType;
    private @Getter String title;

    protected AreaRestrictions() {}
  }

  @ToString
  public class AreaAccessRestriction {
    private @Getter Transportation transportation;
    private @Getter DeclarationDocuments declarationDocuments;
    private @Getter Entry entry;
    private @Getter TravelTest diseaseTesting;
    private @Getter TracingApplication tracingApplication;
    private @Getter Mask mask;
    private @Getter Exit exit;
    private @Getter DatedInformation otherRestriction;
    private @Getter TravelVaccination travelVaccination;
    private @Getter TravelQuarantine travelQuarantineModality;
    private @Getter AreaHealthPass areaHealthPass;

    protected AreaAccessRestriction() {}
  }

  @ToString
  public class Transportation {
    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String transportationType;
    private @Getter String isBanned;
    private @Getter String throughDate;

    protected Transportation() {}
  }

  @ToString
  public class DeclarationDocuments {
    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String isRequired;
    private @Getter String healthDocumentationLink;
    private @Getter String travelDocumentationLink;
    private @Getter HealthInsuranceModality[] healthInsurance;

    protected DeclarationDocuments() {}
  }

  @ToString
  public class HealthInsuranceModality {
    private @Getter String isRequired;
    private @Getter String minAmount;
    private @Getter String currencyCode;
    private @Getter String text;

    protected HealthInsuranceModality() {}
  }

  @ToString
  public class Entry {
    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String ban;
    private @Getter String throughDate;
    private @Getter String referenceLink;
    private @Getter String exemptions;
    private @Getter Area[] bannedArea;
    private @Getter Border[] borderBan;
    private @Getter String bannedTravellers;

    protected Entry() {}
  }

  @ToString
  public class Border {
    private @Getter String borderType;
    private @Getter String status;

    protected Border() {}
  }

  @ToString
  public class TravelTest {
    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String isRequired;
    private @Getter String requirement;
    private @Getter String referenceLink;
    private @Getter TravelTestConditionsAndRules[] travelTestConditionsAndRules;

    protected TravelTest() {}
  }

  @ToString
  public class TravelTestConditionsAndRules {
    private @Getter String travelPhases;
    private @Getter TravelTestScenario[] scenarios;

    protected TravelTestConditionsAndRules() {}
  }

  @ToString
  public class TravelTestScenario {
    private @Getter String name;
    private @Getter TravelTestCondition condition;
    private @Getter TravelTestRules rule;

    protected TravelTestScenario() {}
  }

  @ToString
  public class TravelTestCondition {
    private @Getter TravelTestTravellerCondition traveller;
    private @Getter TravelTestTripCondition trip;
    private @Getter String textualScenario;

    protected TravelTestCondition() {}
  }

  @ToString
  public class TravelTestTravellerCondition {
    private @Getter String whoNeeds;
    private @Getter String minimumAge;

    protected TravelTestTravellerCondition() {}
  }

  @ToString
  public class TravelTestTripCondition {
    private @Getter Area[] countries;
    private @Getter String destinationCity;
    private @Getter String transitCountry;
    private @Getter String transitCity;

    protected TravelTestTripCondition() {}
  }

  @ToString
  public class TravelTestRules {
    private @Getter String[] exemptions;
    private @Getter TravelTestRequirementsRules[] test;
    private @Getter String arrivalTestDays;

    protected TravelTestRules() {}
  }

  @ToString
  public class TravelTestRequirementsRules {
    private @Getter String[] types;
    private @Getter Validity validity;

    protected TravelTestRequirementsRules() {}
  }

  @ToString
  public class Validity {
    private @Getter String delay;
    private @Getter String referenceDateTime;

    protected Validity() {}
  }

  @ToString
  public class TracingApplication {
    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String isRequired;
    private @Getter String[] iosUrl;
    private @Getter String[] androidUrl;

    protected TracingApplication() {}
  }

  @ToString
  public class TravelQuarantine {
    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String eligiblePerson;
    private @Getter String quarantineType;
    private @Getter int duration;
    private @Getter String referenceLink;
    private @Getter String mandateList;
    private @Getter Area[] quarantineOnArrivalAreas;

    protected TravelQuarantine() {}
  }

  @ToString
  public class Mask {
    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String isRequired;

    protected Mask() {}
  }

  @ToString
  public class Exit {
    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String specialRequirements;
    private @Getter String rulesLink;
    private @Getter String isBanned;

    protected Exit() {}
  }

  @ToString
  public class DatedInformation {
    private @Getter String lastUpdate;
    private @Getter String text;

    protected DatedInformation() {}
  }

  @ToString
  public class TravelVaccination {
    private @Getter String isRequired;
    private @Getter String referenceLink;
    private @Getter String[] acceptedCertificates;
    private @Getter QualifiedVaccines[] qualifiedVaccines;
    private @Getter String details;
    private @Getter String minimumAge;
    private @Getter String exemptionFromVaccination;
    private @Getter VaccinatedTravellers vaccinatedTravellers;
    private @Getter String lastUpdate;
    private @Getter String text;

    protected TravelVaccination() {}
  }

  @ToString
  public class QualifiedVaccines {
    private @Getter String supportedVaccineProducts;
    private @Getter int numberOfDoses;
    private @Getter Expiration exemption;
    private @Getter String boosterRequired;
    private @Getter Expiration boosterExpiration;
    private @Getter Validity validity;

    protected QualifiedVaccines() {}
  }

  @ToString
  public class Expiration {
    private @Getter String expiresAfter;
    private @Getter String referenceDateTime;

    protected Expiration() {}
  }

  @ToString
  public class VaccinatedTravellers {
    private @Getter String policy;
    private @Getter String exemptions;

    protected VaccinatedTravellers() {}
  }

  @ToString
  public class AreaHealthPass {
    private @Getter String isRequired;
    private @Getter String applicationGuidance;
    private @Getter String obtentionMethods;
    private @Getter String referenceLink;
    private @Getter String lastUpdate;
    private @Getter String text;

    protected AreaHealthPass() {}
  }

  @ToString
  public class AreaPolicy {
    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String status;
    private @Getter String startDate;
    private @Getter String endDate;
    private @Getter String referenceLink;

    protected AreaPolicy() {}
  }

  @ToString
  public class Links {
    private @Getter String href;
    private @Getter String[] methods;
    private @Getter String rel;

    protected Links() {}
  }

  @ToString
  public class AreaVaccinated {
    private @Getter String vaccinationDoseStatus;
    private @Getter double percentage;
    private @Getter String lastUpdate;
    private @Getter String text;

    protected AreaVaccinated() {}
  }
}
