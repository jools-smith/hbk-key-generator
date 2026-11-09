package com.revenera.gcs.implementor;

import com.flexnet.external.type.*;

public interface GeneratorInterface {

  Status validateProduct(ProductRequest request);

  Status validateLicenseModel(LicenseModelRequest request);

  GeneratorResponse generateLicense(GeneratorRequest request);

  ConsolidatedLicense consolidateFulfillments(FulfillmentRecordSet request);

  LicenseFileDefinitionMap generateLicenseFilenames(GeneratorRequest request);

  LicenseFileDefinitionMap generateConsolidatedLicenseFilenames(ConsolidatedLicenseResquest request);

  String generateCustomHostIdentifier(HostIdRequest request);
}
