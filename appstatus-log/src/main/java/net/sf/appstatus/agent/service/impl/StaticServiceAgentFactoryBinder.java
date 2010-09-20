/*
 * Copyright 2010 Capgemini
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. 
 * See the License for the specific language governing permissions and 
 * limitations under the License. 
 * 
 */
package net.sf.appstatus.agent.service.impl;

import net.sf.appstatus.agent.service.IServiceAgentFactory;
import net.sf.appstatus.agent.service.ServiceAgentFactory;
import net.sf.appstatus.agent.service.spi.IServiceAgentFactoryBinder;

/**
 * The binding of {@link ServiceAgentFactory} class with an actual instance of
 * {@link IServiceAgentFactory} is performed using information returned by this class.
 * 
 * @author Guillaume Mary
 */
public class StaticServiceAgentFactoryBinder implements
		IServiceAgentFactoryBinder {

	/**
	 * The unique instance of this class.
	 * 
	 */
	private static final StaticServiceAgentFactoryBinder SINGLETON = new StaticServiceAgentFactoryBinder();

	/**
	 * Return the singleton of this class.
	 * 
	 * @return the StaticServiceAgentFactoryBinder singleton
	 */
	public static final StaticServiceAgentFactoryBinder getSingleton() {
		return SINGLETON;
	}
	
	
	private static final String serviceMonitorAgentFactoryClassStr = LogServiceAgentFactory.class
			.getName();
	
	/**
	 * {@inheritDoc}
	 */
	public IServiceAgentFactory getServiceAgentFactory() {
		return serviceMonitorAgentFactory;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public String getServiceAgentFactoryStr() {
		return serviceMonitorAgentFactoryClassStr;
	}
	
	private final IServiceAgentFactory serviceMonitorAgentFactory;
	
	private StaticServiceAgentFactoryBinder() {
		serviceMonitorAgentFactory = new LogServiceAgentFactory();
	}

}