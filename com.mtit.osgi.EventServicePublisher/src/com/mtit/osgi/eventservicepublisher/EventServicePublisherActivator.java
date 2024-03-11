package com.mtit.osgi.eventservicepublisher;

import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class EventServicePublisherActivator implements BundleActivator {

	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		
		EventServicePublisherActivator.context = bundleContext;
		Hashtable<String, String> props = new Hashtable<String, String>();
		props.put("Language","English");
		bundleContext.registerService(EventService.class.getName(),new EventServicePublishImpl(),props);
		System.out.println("Event Publisher Service Started");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
		EventServicePublisherActivator.context = null;
		System.out.println("Event Publisher Service Stop");
	}

}
