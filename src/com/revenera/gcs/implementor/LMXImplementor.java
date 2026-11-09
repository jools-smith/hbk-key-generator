package com.revenera.gcs.implementor;

import com.flexnet.external.type.*;
import org.apache.commons.lang3.NotImplementedException;

@GeneratorImplementor(
    technologyId = "LMX",
    technologyName = "LMX Implementor")
public class LMXImplementor extends AbstractGenerator {

  @Override
  public Status validateProduct(ProductRequest request) {
    throw new NotImplementedException("technologyId");
  }

  @Override
  public Status validateLicenseModel(LicenseModelRequest request) {
    throw new NotImplementedException("technologyId");
  }

  @Override
  public GeneratorResponse generateLicense(GeneratorRequest request) {
    throw new NotImplementedException("technologyId");
  }

  @Override
  public ConsolidatedLicense consolidateFulfillments(FulfillmentRecordSet request) {
    throw new NotImplementedException("technologyId");
  }

  @Override
  public LicenseFileDefinitionMap generateLicenseFilenames(GeneratorRequest request) {
    throw new NotImplementedException("technologyId");
  }

  @Override
  public LicenseFileDefinitionMap generateConsolidatedLicenseFilenames(ConsolidatedLicenseResquest request) {
    throw new NotImplementedException("technologyId");
  }

  @Override
  public String generateCustomHostIdentifier(HostIdRequest request) {
    throw new NotImplementedException("technologyId");
  }
}
