package jp.empressia.test.jsonb;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbConfig;
import javax.json.bind.config.PropertyNamingStrategy;

import org.junit.jupiter.api.Test;

public class JsonBTest01 {

	@Test
	public void testSerialize() {
		JsonbConfig config = new JsonbConfig().withPropertyNamingStrategy(PropertyNamingStrategy.UPPER_CAMEL_CASE);
		Jsonb jsonb = JsonbBuilder.newBuilder().withConfig(config).build();

		String jsonString = jsonb.toJson(new SomethingClass());
		assertAll(
			() -> assertThat(jsonString, is("{\"Subject\":\"Getter\"}"))
		);
	}

	public static class SomethingClass {
		@SuppressWarnings("unused")
		private String Subject = "Field";
		public String getSubject() {
			return "Getter";
		}
	}

}
