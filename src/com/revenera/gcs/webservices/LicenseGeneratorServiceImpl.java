package com.revenera.gcs.webservices;

import com.flexnet.external.type.*;
import com.flexnet.external.webservice.keygenerator.LicGeneratorException;
import com.flexnet.external.webservice.keygenerator.LicenseGeneratorServiceInterface;
import com.revenera.gcs.ApplicationProperties;
import com.revenera.gcs.Beans;
import com.revenera.gcs.ExecutionContext;
import com.revenera.gcs.implementor.GeneratorInterface;
import com.revenera.gcs.implementor.LMXImplementor;
import com.revenera.gcs.utils.HandyBag;
import com.revenera.gcs.utils.Serializer;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.SystemProperties;
import org.apache.commons.lang3.SystemUtils;

import javax.jws.WebService;
import java.time.Instant;


@WebService(
    serviceName = "revenera-gcs",
    name = "License Generator Service",
    endpointInterface = "com.flexnet.external.webservice.keygenerator.LicenseGeneratorServiceInterface",
    wsdlLocation = "WEB-INF/wsdl/schema/LicenseGeneratorService.wsdl")
public class LicenseGeneratorServiceImpl extends ServiceProperties implements LicenseGeneratorServiceInterface {

  ///TODO:rip this out
  private static GeneratorInterface generator() {
    return new LMXImplementor();
  }

  public LicenseGeneratorServiceImpl() {
    logger.me(this);
  }

  @Override
  public PingResponse ping(PingRequest request) throws LicGeneratorException {
    logger.in();

    try (final ExecutionContext ctx = new ExecutionContext()) {
      ///register the request
      ExecutionContext.injectRequest(request);

      /// register the response
      return ExecutionContext.injectResponse(new PingResponse() {
        {
          final ApplicationProperties props = ExecutionContext.getApplicationProperties();
          this.str = Serializer.safeSerializeYaml(new HandyBag()
              .withJoined("version",
                  props.getVersion(),
                  props.getReleaseDate(),
                  props.getReleaseTime())
              ///TODO:rempove proficy
              .withJoined("proficy",
                  props.getItem(ApplicationProperties.Items.PROFICY_CHARSET),
                  props.getItem(ApplicationProperties.Items.PROFICY_SEPARATOR),
                  props.getItem(ApplicationProperties.Items.PROFICY_GROUP_COUNT),
                  props.getItem(ApplicationProperties.Items.PROFICY_GROUP_LENGTH),
                  props.getItem(ApplicationProperties.Items.PROFICY_PRODUCT_LINES),
                  props.getHousekeepingFrequency(),
                  props.getHousekeepingRetention())
              .withJoined("system",
                  SystemProperties.getOsName(),
                  SystemProperties.getOsVersion(),
                  SystemProperties.getOsArch()
              )
              .withJoined("host",
                  SystemUtils.getHostName(),
                  SystemProperties.getUserName("unknown"))
              .with("path", Beans.getResourcePath())
              .with("up-time", ExecutionContext.getApplicationDuration().toString()));

          this.info = Serializer.safeSerializeYaml(ExecutionContext.getApplicationData());

          this.processedTime = Instant.now().toString();
        }
      });
    }
  }

  @Override
  public Status validateProduct(ProductRequest request) throws LicGeneratorException {
    logger.in();
    try (final ExecutionContext ctx = new ExecutionContext()) {
      ///register the request
      ExecutionContext.injectRequest(request);

      return ExecutionContext.injectResponse(generator().validateProduct(request));
    }
    catch (final Throwable t) {
      logger.exception(t);
      return ServiceHelper.raiseLicGeneratorException(t);
    }
    finally {
      logger.out();
    }
  }

  @Override
  public Status validateLicenseModel(LicenseModelRequest request) throws LicGeneratorException {
    logger.in();
    try (final ExecutionContext ctx = new ExecutionContext()) {
      ///register the request
      ExecutionContext.injectRequest(request);

      return ExecutionContext.injectResponse(generator().validateLicenseModel(request));
    }
    catch (final Throwable t) {
      logger.exception(t);
      return ServiceHelper.raiseLicGeneratorException(t);
    }
    finally {
      logger.out();
    }
  }

  @Override
  public GeneratorResponse generateLicense(GeneratorRequest request) throws LicGeneratorException {
    logger.in();
    try (final ExecutionContext ctx = new ExecutionContext()) {
      ///register the request
      ExecutionContext.injectRequest(request);

      return ExecutionContext.injectResponse(generator().generateLicense(request));
    }
    catch (final Throwable t) {
      logger.exception(t);
      return ServiceHelper.raiseLicGeneratorException(t);
    }
    finally {
      logger.out();
    }
  }

  @Override
  public ConsolidatedLicense consolidateFulfillments(FulfillmentRecordSet request) throws LicGeneratorException {
    logger.in();
    try (final ExecutionContext ctx = new ExecutionContext()) {
      ///register the request
      ExecutionContext.injectRequest(request);

      return ExecutionContext.injectResponse(generator().consolidateFulfillments(request));
    }
    catch (final Throwable t) {
      logger.exception(t);
      return ServiceHelper.raiseLicGeneratorException(t);
    }
    finally {
      logger.out();
    }
  }

  @Override
  public LicenseFileDefinitionMap generateLicenseFilenames(GeneratorRequest request) throws LicGeneratorException {
    logger.in();
    try (final ExecutionContext ctx = new ExecutionContext()) {
      ///register the request
      ExecutionContext.injectRequest(request);

      return ExecutionContext.injectResponse(generator().generateLicenseFilenames(request));
    }
    catch (final Throwable t) {
      logger.exception(t);
      return ServiceHelper.raiseLicGeneratorException(t);
    }
    finally {
      logger.out();
    }
  }

  @Override
  public LicenseFileDefinitionMap generateConsolidatedLicenseFilenames(ConsolidatedLicenseResquest request) throws LicGeneratorException {
    logger.in();
    try (final ExecutionContext ctx = new ExecutionContext()) {
      ///register the request
      ExecutionContext.injectRequest(request);

      return ExecutionContext.injectResponse(generator().generateConsolidatedLicenseFilenames(request));
    }
    catch (final Throwable t) {
      logger.exception(t);
      return ServiceHelper.raiseLicGeneratorException(t);
    }
    finally {
      logger.out();
    }
  }

  @Override
  public String generateCustomHostIdentifier(HostIdRequest request) throws LicGeneratorException {
    logger.in();
    try (final ExecutionContext ctx = new ExecutionContext()) {
      ///register the request
      ExecutionContext.injectRequest(request);

      return ExecutionContext.injectResponse(generator().generateCustomHostIdentifier(request));
    }
    catch (final Throwable t) {
      logger.exception(t);
      return ServiceHelper.raiseLicGeneratorException(t);
    }
    finally {
      logger.out();
    }
  }

}
