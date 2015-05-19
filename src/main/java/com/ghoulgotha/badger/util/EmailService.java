package com.ghoulgotha.badger.util;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import com.sun.jersey.core.util.MultivaluedMapImpl;
import freemarker.template.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.ws.rs.core.MediaType;
import java.util.Map;

@Service
public class EmailService {

	private static String AUTH_KEY = "key-173701b40541299bd3b7d40c3ac6fd43";
	private static String BASE_URI = "https://api.mailgun.net/v3/sandbox73d66ccb60f948708fcaf2e2d1b3cd4c.mailgun.org";

	public ClientResponse send(String from, String to, String subject, String text, String html) {
		Client client = Client.create();
		WebResource resource = client.resource(BASE_URI + "/messages");
		MultivaluedMapImpl data = new MultivaluedMapImpl();
		client.addFilter(new HTTPBasicAuthFilter("api", AUTH_KEY));
		data.add("from", from);
		data.add("to", to);
		data.add("subject", subject);
		data.add("text", text);
		data.add("html", html);
		return resource.type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class, data);
	}
	//freemarker template support

	@Autowired
	private Configuration config;

	public ClientResponse send(String from, String to, String subject, String text, String template, Map data) {
		String body = null;
		try {
			body = FreeMarkerTemplateUtils.processTemplateIntoString(config.getTemplate(template), data);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return send(from, to, subject, text, body);
	}
}
