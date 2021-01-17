package optionals;

import java.util.Optional;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Object value = Optional.ofNullable("Hello").orElseGet(() -> "Default Value");
        System.out.println(value);

        Supplier<IllegalStateException> exception = () -> new IllegalStateException("Exception");
        Object valueException = Optional.ofNullable("").orElseThrow(exception);
        System.out.println(valueException);

        Optional.ofNullable("john@gmail.com").ifPresent(i -> System.out.println("Sending email to: " + i));

        Optional.ofNullable(null).ifPresentOrElse((i -> System.out.println("Sending email to: " + i)),
                () -> System.out.println("Cannot send an email")
        );

    }
}
