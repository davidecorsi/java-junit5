package it.partec.java_junit5;

import java.util.stream.Stream;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArgumentProvider implements ArgumentsProvider {

	@Override
	public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
		return Stream.of(
				arguments(1, 1),
				arguments(2, 4),
				arguments(4, 5)
			);
	}

}
