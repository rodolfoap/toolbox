package io.swagger.api.factories;

import io.swagger.api.DeviceApiService;
import io.swagger.api.impl.DeviceApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaJerseyServerCodegen", date = "2019-02-18T09:12:01.963Z")
public class DeviceApiServiceFactory {
	private final static DeviceApiService service = new DeviceApiServiceImpl();

	public static DeviceApiService getDeviceApi() {
		return service;
	}
}
