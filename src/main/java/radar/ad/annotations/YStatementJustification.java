package radar.ad.annotations;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// TODO decide where to put the Y statement template text - defaults? IO helper? ...?
// see IEEE SOftware/InfoQ article and SATURN 2012 presentation for introduction of Y statements (as well as AppArch lecture at HSR FHO)
// http://www.ifs.hsr.ch/Method-Selection-and-Tailoring.13195.0.html?&L=4

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
@Documented
public @interface YStatementJustification {

    String id() default "AD-xx";

    String context() default "";

    String facing() default "";

    String chosen() default "";

    String neglected() default "";

    String achieving() default "";

    String accepting() default "";

    String moreInformation() default  ""; // this could take URI
}
