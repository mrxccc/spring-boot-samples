package cn.mrxccc.validator.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Validation注解
 *
 * @author mrxccc
 * @date 2021/1/15 17:28
 */

public class ValidationBeanModel {

    @Data
    public class AbcAssertFalse {

        @AssertFalse
        private Boolean myAssertFalse;
    }

    @Data
    public class AbcAssertTrue {

        @AssertTrue
        private Boolean myAssertTrue;
    }

    @Data
    public class AbcDecimalMax {

        @DecimalMax(value = "12.3")
        private String myDecimalMax;
    }

    @Data
    public class AbcDecimalMin {

        @DecimalMin(value = "10.3")
        private String myDecimalMin;
    }

    @Data
    public class AbcDigits {

        @Digits(integer = 5, fraction = 3)
        private Integer myDigits;
    }

    @Data
    public class AbcEmail {

        @Email
        private String myEmail;
    }

    @Data
    public class AbcFuture {

        @Future
        private Date myFuture;
    }

    @Data
    public class AbcLength {

        @Length(min = 5, max = 10)
        private String myLength;
    }

    @Data
    public class AbcMax {

        @Max(value = 200)
        private Long myMax;
    }

    @Data
    public class AbcMin {

        @Min(value = 100)
        private Long myMin;
    }

    @Data
    public class AbcNotBlank {

        @NotBlank
        private String myStringNotBlank;

        @NotBlank
        private String myObjNotBlank;
    }

    @Data
    public class AbcNotEmpty {

        @NotEmpty
        private String myStringNotEmpty;

        @NotEmpty
        private String myNullNotEmpty;

        @NotEmpty
        private Map<String, Object> myMapNotEmpty;

        @NotEmpty
        private List<Object> myListNotEmpty;

        @NotEmpty
        private Object[] myArrayNotEmpty;
    }

    @Data
    public class AbcNotNull {

        @NotNull
        private String myStringNotNull;

        @NotNull
        private Object myNullNotNull;

        @NotNull
        private Map<String, Object> myMapNotNull;
    }

    @Data
    public class AbcNull {

        @Null
        private String myStringNull;

        @Null
        private Map<String, Object> myMapNull;
    }

    @Data
    public class AbcPast {

        @Past
        private Date myPast;
    }

    @Data
    public class AbcPattern {

        @Pattern(regexp = "\\d+")
        private String myPattern;
    }

    @Data
    public class AbcRange {

        @Range(min = 100, max = 100000000000L)
        private Double myRange;
    }

    @Data
    public class AbcSize {

        @Size(min = 3, max = 5)
        private List<Integer> mySize;
    }

    @Data
    public class AbcURL {

        @URL
        private String myURL;
    }
}
