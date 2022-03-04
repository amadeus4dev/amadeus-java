package com.amadeus.resources;

import com.amadeus.dutyOfCare.diseases.TravelRestrictions;
import lombok.Getter;
import lombok.ToString;

/**
 * A DiseaseAreaReport object as returned by the Travel Restrictions API.
 * @see TravelRestrictions#get()
 */
@ToString
public class DiseaseAreaReport extends Resource {
  protected DiseaseAreaReport() {}

  private @Getter String type;
  private @Getter Area area;
  private @Getter String[] subAreas;
  private @Getter String summary;
  private @Getter String diseaseRiskLevel;
  private @Getter DiseaseInfection diseaseInfection;
  private @Getter DiseaseCase diseaseCases;
  private @Getter String hotspots;
  private @Getter Sources dataSources;
  private @Getter AreaRestriction[] areaRestrictions;
  private @Getter AreaAccessRestriction areaAccessRestriction;
  private @Getter AreaPolicy areaPolicy;
  private @Getter Link[] relatedArea;
  private @Getter AreaVaccinated[] areaVaccinated;

  @ToString
  public class Area {
    protected Area() {}

    private @Getter String name;
    private @Getter String iataCode;
    private @Getter String geoCode;
    private @Getter String areaType;

  }

  @ToString
  public class GeoCode {
    protected GeoCode() {}

    private @Getter String latitude;
    private @Getter String longitude;
  }

  @ToString
  public class DiseaseInfection {
    protected DiseaseInfection() {}

    private @Getter String date;
    private @Getter String level;
    private @Getter String rate;
    private @Getter String infectionMapLink;
  }

  @ToString
  public class DiseaseCase {
    protected DiseaseCase() {}

    private @Getter String date;
    private @Getter int active;
    private @Getter int recovered;
    private @Getter int deaths;
    private @Getter int confirmed;
  }

  @ToString
  public class Sources {
    protected Sources() {}

    private @Getter String covidDashboardLink;
    private @Getter String healthDepartmentSiteLink;
    private @Getter String governmentSiteLink;
  }

  @ToString
  public class AreaRestriction {
    protected AreaRestriction() {}

    private @Getter String date;
    private @Getter String text;
    private @Getter String restrictionType;
    private @Getter String type;
  }

  @ToString
  public class AreaAccessRestriction {
    protected AreaAccessRestriction() {}

    private @Getter Transportation transportation;
    private @Getter DeclarationDocuments declarationDocuments;
    private @Getter EntryRestriction entry;
    private @Getter DiseaseTestingRestriction diseaseTesting;
    private @Getter DatedTracingApplicationRestriction tracingApplication;
    private @Getter DatedQuarantineRestriction quarantineModality;
    private @Getter MaskRestriction mask;
    private @Getter ExitRestriction exit;
    private @Getter DatedInformation otherRestriction;
    private @Getter DiseaseVaccination diseaseVaccination;
  }

  @ToString
  public class Transportation {
    protected Transportation() {}

    private @Getter String date;
    private @Getter String text;
    private @Getter String transportationType;
    private @Getter String isBanned;
    private @Getter String throughDate;
  }

  @ToString
  public class DeclarationDocuments {
    protected DeclarationDocuments() {}

    private @Getter String date;
    private @Getter String text;
    private @Getter String documentRequired;
    private @Getter String healthDocumentationLink;
  }

  @ToString
  public class EntryRestriction {
    protected EntryRestriction() {}

    private @Getter String date;
    private @Getter String text;
    private @Getter String ban;
    private @Getter String throughDate;
    private @Getter String rules;
    private @Getter String exemptions;
    private @Getter Area[] bannedArea;
    private @Getter Border[] borderBan;
  }

  @ToString
  public class Border {
    protected Border() {}

    private @Getter String borderType;
    private @Getter String status;
  }

  @ToString
  public class DiseaseTestingRestriction {
    protected DiseaseTestingRestriction() {}

    private @Getter String date;
    private @Getter String text;
    private @Getter String isRequired;
    private @Getter String when;
    private @Getter String requirement;
    private @Getter String rules;
    private @Getter String testType;
    private @Getter int minimumAge;
    private @Getter ValidityPeriod validityPeriod;
  }

  @ToString
  public class ValidityPeriod {
    protected ValidityPeriod() {}

    private @Getter String delay;
    private @Getter String referenceDateType;
  }

  @ToString
  public class DatedTracingApplicationRestriction {
    protected DatedTracingApplicationRestriction() {}

    private @Getter String date;
    private @Getter String text;
    private @Getter String isRequired;
    private @Getter String[] iosUrl;
    private @Getter String[] androidUrl;
    private @Getter String website;
  }

  @ToString
  public class DatedQuarantineRestriction {
    protected DatedQuarantineRestriction () {}

    private @Getter String date;
    private @Getter String text;
    private @Getter String eligiblePerson;
    private @Getter String quarantineType;
    private @Getter int duration;
    private @Getter String rules;
    private @Getter String mandateList;
    private @Getter Area[] quarantineOnArrivalAreas;
  }

  @ToString
  public class MaskRestriction {
    protected MaskRestriction () {}

    private @Getter String date;
    private @Getter String text;
    private @Getter String isRequired;
  }

  @ToString
  public class ExitRestriction {
    protected ExitRestriction () {}

    private @Getter String date;
    private @Getter String text;
    private @Getter String specialRequirements;
    private @Getter String rulesLink;
    private @Getter String isBanned;
  }

  @ToString
  public class DatedInformation {
    protected DatedInformation() {}

    private @Getter String date;
    private @Getter String text;
  }

  @ToString
  public class DiseaseVaccination {
    protected DiseaseVaccination() {}

    private @Getter String isRequired;
    private @Getter String referenceLink;
    private @Getter String[] acceptedCertificates;
    private @Getter String[] qualifiedVaccines;
    private @Getter String policy;
    private @Getter String exemptions;
    private @Getter String details;
    private @Getter String date;
    private @Getter String text;
  }

  @ToString
  public class AreaPolicy {
    protected AreaPolicy() {}

    private @Getter String date;
    private @Getter String text;
    private @Getter String status;
    private @Getter String startDate;
    private @Getter String endDate;
    private @Getter String referenceLink;
  }

  @ToString
  public class Link {
    protected Link() {}

    private @Getter String href;
    private @Getter String[] methods;
    private @Getter String rel;
  }

  @ToString
  public class AreaVaccinated {
    protected AreaVaccinated() {}

    private @Getter String vaccinationDoseStatus;
    private @Getter double percentage;
    private @Getter String date;
    private @Getter String text;
  }


}
