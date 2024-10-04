package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConverterTest {

    @Test
    void StringToInteger(){
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        Assertions.assertThat(result).isEqualTo(10);
    }


    @Test
    void IntegerToString(){
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);
        Assertions.assertThat(result).isEqualTo("10");
    }

    @Test
    void stringToIpPort(){
        IpPortToStringConverter ipPortToStringConverter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = ipPortToStringConverter.convert(source);
        Assertions.assertThat(result).isEqualTo("127.0.0.1:8080");
    }


    @Test
    void ipPortString(){
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);
        Assertions.assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080));
    }
}
