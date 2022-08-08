package com.amadeus.resources;

import com.amadeus.dutyOfCare.diseases.Covid19Report;
import lombok.Getter;
import lombok.ToString;

/**
 * A DiseaseReport object as returned by the Travel Restrictions V2 API.
 * @see Covid19Report#get()
 */
@ToString
public class DiseaseReport extends Resource {
  protected DiseaseReport() {}

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

  @ToString
  public class Area {
    protected Area() {}

    private @Getter String name;
    private @Getter String code;
    private @Getter GeoCode geoCode;
    private @Getter String areaType;
  }

  @ToString
  public class GeoCode {
    protected GeoCode() {}

    private @Getter String latitude;
    private @Getter String longitude;
  }

  @ToString
  public class SubArea {
    protected SubArea() {}

    private @Getter Area area;
    private @Getter DatedInformation summary;
    private @Getter DatedInformation diseaseRiskLevel;
    private @Getter Links[] relatedArea;
  }

  @ToString
  public class DiseaseInfection {
    protected DiseaseInfection() {}

    private @Getter String level;
    private @Getter String rate;
    private @Getter String infectionMapLink;
    private @Getter String trend;
    private @Getter String lastUpdate;
    private @Getter String text;
  }

  @ToString
  public class DiseaseCases {
    protected DiseaseCases() {}

    private @Getter int active;
    private @Getter int recovered;
    private @Getter int deaths;
    private @Getter int confirmed;
    private @Getter String lastUpdate;
    private @Getter String text;
  }

  @ToString
  public class DataSources {
    protected DataSources() {}

    private @Getter String covidDashboardLink;
    private @Getter String healthDepartmentSiteLink;
    private @Getter String governmentSiteLink;
  }

  @ToString
  public class AreaRestrictions {
    protected AreaRestrictions() {}

    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String restrictionType;
    private @Getter String title;
  }

  @ToString
  public class AreaAccessRestriction {
    protected AreaAccessRestriction() {}

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
  }

  @ToString
  public class Transportation {
    protected Transportation() {}

    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String transportationType;
    private @Getter String isBanned;
    private @Getter String throughDate;
  }

  @ToString
  public class DeclarationDocuments {
    protected DeclarationDocuments() {}

    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String isRequired;
    private @Getter String healthDocumentationLink;
    private @Getter String travelDocumentationLink;
    private @Getter HealthInsuranceModality[] healthInsurance;
  }

  @ToString
  public class HealthInsuranceModality {
    protected HealthInsuranceModality() {}

    private @Getter String isRequired;
    private @Getter String minAmount;
    private @Getter String currencyCode;
    private @Getter String text;
  }

  @ToString
  public class Entry {
    protected Entry() {}

    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String ban;
    private @Getter String throughDate;
    private @Getter String referenceLink;
    private @Getter String exemptions;
    private @Getter Area[] bannedArea;
    private @Getter Border[] borderBan;
    private @Getter String bannedTravellers;
  }

  @ToString
  public class Border {
    protected Border() {}

    private @Getter String borderType;
    private @Getter String status;
  }

  @ToString
  public class TravelTest {
    protected TravelTest() {}

    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String isRequired;
    private @Getter String requirement;
    private @Getter String referenceLink;
    private @Getter TravelTestConditionsAndRules[] travelTestConditionsAndRules;
  }

  @ToString
  public class TravelTestConditionsAndRules {
    protected TravelTestConditionsAndRules() {}

    private @Getter String travelPhases;
    private @Getter TravelTestScenario[] scenarios;
  }

  @ToString
  public class TravelTestScenario {
    protected TravelTestScenario() {}

    private @Getter String name;
    private @Getter TravelTestCondition condition;
    private @Getter TravelTestRules rule;
  }

  @ToString
  public class TravelTestCondition {
    protected TravelTestCondition() {}

    private @Getter TravelTestTravellerCondition traveller;
    private @Getter TravelTestTripCondition trip;
    private @Getter String textualScenario;
  }

  @ToString
  public class TravelTestTravellerCondition {
    protected TravelTestTravellerCondition() {}

    private @Getter String whoNeeds;
    private @Getter String minimumAge;
  }

  @ToString
  public class TravelTestTripCondition {
    protected TravelTestTripCondition() {}

    private @Getter Area[] countries;
    private @Getter String destinationCity;
    private @Getter String transitCountry;
    private @Getter String transitCity;
  }

  @ToString
  public class TravelTestRules {
    protected TravelTestRules() {}

    private @Getter String[] exemptions;
    private @Getter TravelTestRequirementsRules[] test;
    private @Getter String arrivalTestDays;
  }

  @ToString
  public class TravelTestRequirementsRules {
    protected TravelTestRequirementsRules() {}

    private @Getter String[] types;
    private @Getter Validity validity;
  }

  @ToString
  public class Validity {
    protected Validity() {}

    private @Getter String delay;
    private @Getter String referenceDateTime;
  }

  @ToString
  public class TracingApplication {
    protected TracingApplication() {}

    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String isRequired;
    private @Getter String[] iosUrl;
    private @Getter String[] androidUrl;
  }

  @ToString
  public class TravelQuarantine {
    protected TravelQuarantine() {}

    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String eligiblePerson;
    private @Getter String quarantineType;
    private @Getter int duration;
    private @Getter String referenceLink;
    private @Getter String mandateList;
    private @Getter Area[] quarantineOnArrivalAreas;
  }

  @ToString
  public class Mask {
    protected Mask() {}

    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String isRequired;
  }

  @ToString
  public class Exit {
    protected Exit() {}

    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String specialRequirements;
    private @Getter String rulesLink;
    private @Getter String isBanned;
  }

  @ToString
  public class DatedInformation {
    protected DatedInformation() {}

    private @Getter String lastUpdate;
    private @Getter String text;
  }

  @ToString
  public class TravelVaccination {
    protected TravelVaccination() {}

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
  }

  @ToString
  public class QualifiedVaccines {
    protected QualifiedVaccines() {}

    private @Getter String supportedVaccineProducts;
    private @Getter int numberOfDoses;
    private @Getter Expiration exemption;
    private @Getter String boosterRequired;
    private @Getter Expiration boosterExpiration;
    private @Getter Validity validity;
  }

  @ToString
  public class Expiration {
    protected Expiration() {}

    private @Getter String expiresAfter;
    private @Getter String referenceDateTime;
  }

  @ToString
  public class VaccinatedTravellers {
    protected VaccinatedTravellers() {}

    private @Getter String policy;
    private @Getter String exemptions;
  }

  @ToString
  public class AreaHealthPass {
    protected AreaHealthPass() {}

    private @Getter String isRequired;
    private @Getter String applicationGuidance;
    private @Getter String obtentionMethods;
    private @Getter String referenceLink;
    private @Getter String lastUpdate;
    private @Getter String text;
  }

  @ToString
  public class AreaPolicy {
    protected AreaPolicy() {}

    private @Getter String lastUpdate;
    private @Getter String text;
    private @Getter String status;
    private @Getter String startDate;
    private @Getter String endDate;
    private @Getter String referenceLink;
  }

  @ToString
  public class Links {
    protected Links() {}

    private @Getter String href;
    private @Getter String[] methods;
    private @Getter String rel;
  }

  @ToString
  public class AreaVaccinated {
    protected AreaVaccinated() {}

    private @Getter String vaccinationDoseStatus;
    private @Getter double percentage;
    private @Getter String lastUpdate;
    private @Getter String text;
  }
}
