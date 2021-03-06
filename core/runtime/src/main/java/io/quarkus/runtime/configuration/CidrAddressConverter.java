package io.quarkus.runtime.configuration;

import static io.quarkus.runtime.configuration.ConverterSupport.DEFAULT_QUARKUS_CONVERTER_PRIORITY;

import javax.annotation.Priority;

import org.eclipse.microprofile.config.spi.Converter;
import org.wildfly.common.net.CidrAddress;
import org.wildfly.common.net.Inet;

/**
 * A converter which converts a CIDR address into an instance of {@link CidrAddress}.
 */
@Priority(DEFAULT_QUARKUS_CONVERTER_PRIORITY)
public class CidrAddressConverter implements Converter<CidrAddress> {

    @Override
    public CidrAddress convert(final String value) {
        if (value.isEmpty()) {
            return null;
        }
        final CidrAddress result = Inet.parseCidrAddress(value);
        if (result == null) {
            throw new IllegalArgumentException("Failed to parse CIDR address \"" + value + "\"");
        }
        return result;
    }
}
