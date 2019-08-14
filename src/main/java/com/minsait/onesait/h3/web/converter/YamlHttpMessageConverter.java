package com.minsait.onesait.h3.web.converter;

import java.io.IOException;
import java.io.OutputStreamWriter;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.yaml.snakeyaml.Yaml;

public class YamlHttpMessageConverter<T> extends AbstractHttpMessageConverter<T> {

	public YamlHttpMessageConverter() {
		super(new MediaType("application", "yaml"));
	}

	@Override
	protected boolean supports(Class<?> clazz) {

		return true;
	}

	@Override
	protected T readInternal(Class<? extends T> clazz, HttpInputMessage inputMessage)
			throws IOException {
		final Yaml yaml = new Yaml();
		return yaml.loadAs(inputMessage.getBody(), clazz);
	}

	@Override
	protected void writeInternal(T t, HttpOutputMessage outputMessage)
			throws IOException {
		final Yaml yaml = new Yaml();
		final OutputStreamWriter writer = new OutputStreamWriter(outputMessage.getBody());
		yaml.dump(t, writer);
		writer.close();

	}
}