package com.example.event.listener;

import java.net.URI;

import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.event.ResourceCreateEvent;

@Component
public class ResourceCreateListener implements ApplicationListener<ResourceCreateEvent>{

	@Override
	public void onApplicationEvent(ResourceCreateEvent resourceCreateEvent) {
		HttpServletResponse response = resourceCreateEvent.getResponse();
		Long id = resourceCreateEvent.getId();
		
		adicionarHeaderLocation(response, id);
	}

	private void adicionarHeaderLocation(HttpServletResponse response, Long id) {
		URI uri =  ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
				.buildAndExpand(id).toUri();
		response.setHeader("Location", uri.toASCIIString());
	}
}
